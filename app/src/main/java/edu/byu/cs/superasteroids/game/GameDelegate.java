package edu.byu.cs.superasteroids.game;

import android.content.Context;
import android.graphics.Color;

import edu.byu.cs.superasteroids.base.Debug;
import edu.byu.cs.superasteroids.base.IGameDelegate;
import edu.byu.cs.superasteroids.content.ContentManager;
import edu.byu.cs.superasteroids.database.Database;
import edu.byu.cs.superasteroids.drawing.DrawingHelper;
import edu.byu.cs.superasteroids.model.Level;
import edu.byu.cs.superasteroids.model.Space;
import edu.byu.cs.superasteroids.model.ship_parts.Ship;

/**
 * @author Scott Leland Crossen
 */
public class GameDelegate implements IGameDelegate {
/*
FIELDS
 */
    enum GAME_STATE {GAME_OVER, GAME_WON, PLAYING,TRANSITION}
    private Ship ship=Ship.getInstance();
    private Level current_level;
    private Database database;
    private ViewPort viewport;
    private ContentManager content;
    private Space space;
    private GAME_STATE game_state=GAME_STATE.TRANSITION;
    private double transition_time_left=TRANSITION_TIME;
    private MiniMap minimap;
    private Debug debug=new Debug(4);
/*
CONSTRUCTORS
 */
    /**
     * The constructor for the class. It receives a context to create a database.
     * @param context
     */
    public GameDelegate(Context context){
        database=new Database(context); // Gets working database.
        ship=Ship.getInstance();
        ship.setScale((float) .25);
        //ship.enableRotationDrift();
        initializeNewLevel();
    }
/*
METHODS
 */
    /**
     * Loads new objects from database and prepares the level
     */
    private void initializeNewLevel(){
        if(current_level==null) // Test if this is the last/first level
            current_level=database.dao.getLevel(1);
        else
            current_level=database.dao.getLevel(current_level.getLevelNumber()+1);
        if(current_level==null)
            game_state=GAME_STATE.GAME_WON;
        else{ // This isn't the last level so setup the new level.
            minimap = new MiniMap(current_level, ship);
            game_state=GAME_STATE.TRANSITION;
            space=new Space(current_level.getBound());
            ship.setPosition(current_level.getCenter());
            viewport=new ViewPort(ship, current_level.getBound());
            current_level.setViewPort(viewport);
            ship.setViewPort(viewport);
            space.setViewPort(viewport);
            space.setScale(current_level.getWidth(), current_level.getHeight());
            loadLevelContent();
            transition_time_left=TRANSITION_TIME;
        }
    }
    /**
     * Removes level content
     */
    private void unloadLevelContent(){ // Call this method on the corresponding level method
        current_level.unloadContent(content);
        content.unloadImage(space.getImage().getContentID());
    }

    /**
     * Loads level content
     */
    private void loadLevelContent() {
        if(content != null) { // Make sure there's content to load
            current_level.loadContent(content);
            space.getImage().setContentID(content.loadImage(space.getImage().getPath()));
            current_level.playMusic();
        }
    }
    /**
     * Updates level, ship, objects according to how long its been.
     * @param elapsedTime Time since the last update.
     */
    @Override
    public void update(double elapsedTime) {
        if(game_state==GAME_STATE.TRANSITION){ // Allow for some time for the text to be read between levels.
            transition_time_left-=elapsedTime;
            if(transition_time_left<0)
                game_state=GAME_STATE.PLAYING;
        }
        else if(game_state==GAME_STATE.PLAYING){ // Update all contituent objects contained in level.
            current_level.update(elapsedTime);
            if(current_level.isFinished())
                initializeNewLevel();
            ship.update(elapsedTime);
            viewport.update();
            if(ship.needsDeletion()){
                unloadContent(content);
                game_state=GAME_STATE.GAME_OVER;
            }
        }
    }
    /**
     * Loads active content with content manager class.
     * @param _content  The content to be loaded.
     */
    @Override
    public void loadContent(ContentManager _content) {
        ship.getMainBody().getImage().setContentID(_content.loadImage(ship.getMainBody().getImage().getPath()));
        ship.getCannon().getImage().setContentID(_content.loadImage(ship.getCannon().getImage().getPath()));
        ship.getEngine().getImage().setContentID(_content.loadImage(ship.getEngine().getImage().getPath()));
        ship.getExtraPart().getImage().setContentID(_content.loadImage(ship.getExtraPart().getImage().getPath()));
        ship.getCannon().getAttackImage().setContentID(_content.loadImage(ship.getCannon().getAttackImage().getPath()));
        try { // This throws an exception for incorrect sound. Just set to one in this case.
            ship.getCannon().setAttackSoundID(_content.loadSound(ship.getCannon().getAttackSound()));
        } catch (java.io.IOException e) {
            ship.getCannon().setAttackSoundID(-1);
        }
        this.content = _content;
        loadLevelContent(); // Have to call this too.
    }
    /**
     * Unloads active content with content manager class.
     * @param content   The content to be unloaded.
     */
    @Override
    public void unloadContent(ContentManager content) {
        content.unloadImage(ship.getMainBody().getImage().getContentID());
        content.unloadImage(ship.getCannon().getImage().getContentID());
        content.unloadImage(ship.getEngine().getImage().getContentID());
        content.unloadImage(ship.getExtraPart().getImage().getContentID());
        content.unloadImage(ship.getCannon().getAttackImage().getContentID());
        content.unloadSound(ship.getCannon().getAttackSoundID());
        unloadLevelContent();
    }
    /**
     * The parent draw function that writes the screen.
     */
    @Override
    public void draw() {
        switch(game_state) {
            case GAME_WON: // Display victory message
                DrawingHelper.drawCenteredText("You beat all the levels!", (int)(100.0*(DrawingHelper.getGameViewWidth()/TEXT_SCALE)), Color.WHITE);
                break;
            case GAME_OVER: // Display loser message
                DrawingHelper.drawCenteredText("You died. Push Back",(int)(100.0*(DrawingHelper.getGameViewWidth()/TEXT_SCALE)), Color.WHITE);
                break;
            case TRANSITION: // Display next level message
                DrawingHelper.drawCenteredText("Level " + Integer.toString(current_level.getLevelnumber()) + " - " + current_level.getHint(), (int) (100.0 * (DrawingHelper.getGameViewWidth() / TEXT_SCALE)), Color.WHITE);
                break;
            case PLAYING: // Display game
                space.draw();
                current_level.draw();
                ship.draw();
                minimap.draw();
                break;
            default:
                assert false;
                break;
        }
    }
/*
CONSTANTS/FINALS
 */
    private static final double TRANSITION_TIME=5;
    private static final double TEXT_SCALE=1500.0; // For displaying messages on screen.
/*
GETTERS/SETTERS
 */
}
