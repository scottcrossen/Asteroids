package edu.byu.cs.superasteroids.ship_builder;

import android.graphics.PointF;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import edu.byu.cs.superasteroids.base.Debug;
import edu.byu.cs.superasteroids.base.IView;
import edu.byu.cs.superasteroids.content.ContentManager;
import edu.byu.cs.superasteroids.database.Database;
import edu.byu.cs.superasteroids.drawing.DrawingHelper;
import edu.byu.cs.superasteroids.model.ship_parts.Cannon;
import edu.byu.cs.superasteroids.model.ship_parts.Engine;
import edu.byu.cs.superasteroids.model.ship_parts.ExtraPart;
import edu.byu.cs.superasteroids.model.ship_parts.MainBody;
import edu.byu.cs.superasteroids.model.ship_parts.PowerCore;
import edu.byu.cs.superasteroids.model.ship_parts.Ship;
import edu.byu.cs.superasteroids.model.ship_parts.ShipPart;

/**
 * Created by Scott Leland Crossen
 */
public class ShipBuilderController implements IShipBuildingController {
/*
FIELDS
 */
    Debug debug=new Debug(3);
    private static final double SHIP_SCALE = .75;
    private IShipBuildingView.PartSelectionView state;
    private IShipBuildingView view;
    private List<Integer> main_body_ids;
    private List<Integer> extra_part_ids;
    private List<Integer> cannon_ids;
    private List<Integer> engine_ids;
    private List<Integer> power_core_ids;
    private List<MainBody> main_bodies;
    private List<Engine> engines;
    private List<PowerCore> power_cores;
    private List<Cannon> cannons;
    private List<ExtraPart> extra_parts;
    private Ship ship;
    private boolean content_loaded = false;
    private Map<IShipBuildingView.ViewDirection,IShipBuildingView.PartSelectionView> arrows=new HashMap<>();
/*
CONSTRUCTORS
 */
    ShipBuilderController(ShipBuildingActivity calling_instance){
        Database db=new Database(calling_instance);
        view=calling_instance;
        main_bodies = db.dao.getMainBodies();
        engines = db.dao.getEngines();
        power_cores = db.dao.getPowerCores();
        cannons = db.dao.getCannons();
        extra_parts = db.dao.getExtraParts();
        ship=Ship.createNew();
        arrows.put(IShipBuildingView.ViewDirection.LEFT,null);
        arrows.put(IShipBuildingView.ViewDirection.UP,null);
        arrows.put(IShipBuildingView.ViewDirection.RIGHT,null);
        arrows.put(IShipBuildingView.ViewDirection.DOWN,null);
    }
/*
METHODS
 */
    /**
     * This is executed whenever a new frame is called.
     * @param partView
     */
    @Override
    public void onViewLoaded(IShipBuildingView.PartSelectionView partView) {
        state = partView;
        switch (state) {
            case MAIN_BODY:
                view.setPartViewImageList(state, main_body_ids);
                arrows.put(IShipBuildingView.ViewDirection.LEFT, IShipBuildingView.PartSelectionView.ENGINE);
                arrows.put(IShipBuildingView.ViewDirection.UP, IShipBuildingView.PartSelectionView.POWER_CORE);
                arrows.put(IShipBuildingView.ViewDirection.DOWN, IShipBuildingView.PartSelectionView.CANNON);
                arrows.put(IShipBuildingView.ViewDirection.RIGHT, IShipBuildingView.PartSelectionView.EXTRA_PART);
                set_arrows();
                break;
            case ENGINE:
                view.setPartViewImageList(state, engine_ids);
                arrows.put(IShipBuildingView.ViewDirection.LEFT, IShipBuildingView.PartSelectionView.POWER_CORE);
                arrows.put(IShipBuildingView.ViewDirection.UP, IShipBuildingView.PartSelectionView.CANNON);
                arrows.put(IShipBuildingView.ViewDirection.RIGHT, IShipBuildingView.PartSelectionView.EXTRA_PART);
                arrows.put(IShipBuildingView.ViewDirection.DOWN, IShipBuildingView.PartSelectionView.MAIN_BODY);
                set_arrows();
                break;
            case POWER_CORE:
                view.setPartViewImageList(state, power_core_ids);
                arrows.put(IShipBuildingView.ViewDirection.LEFT, IShipBuildingView.PartSelectionView.CANNON);
                arrows.put(IShipBuildingView.ViewDirection.UP, IShipBuildingView.PartSelectionView.EXTRA_PART);
                arrows.put(IShipBuildingView.ViewDirection.RIGHT, IShipBuildingView.PartSelectionView.MAIN_BODY);
                arrows.put(IShipBuildingView.ViewDirection.DOWN, IShipBuildingView.PartSelectionView.ENGINE);
                set_arrows();
                break;
            case CANNON:
                view.setPartViewImageList(state, cannon_ids);
                arrows.put(IShipBuildingView.ViewDirection.LEFT, IShipBuildingView.PartSelectionView.EXTRA_PART);
                arrows.put(IShipBuildingView.ViewDirection.UP, IShipBuildingView.PartSelectionView.MAIN_BODY);
                arrows.put(IShipBuildingView.ViewDirection.RIGHT, IShipBuildingView.PartSelectionView.ENGINE);
                arrows.put(IShipBuildingView.ViewDirection.DOWN, IShipBuildingView.PartSelectionView.POWER_CORE);
                set_arrows();
                break;
            case EXTRA_PART:
                view.setPartViewImageList(state, extra_part_ids);
                arrows.put(IShipBuildingView.ViewDirection.LEFT, IShipBuildingView.PartSelectionView.MAIN_BODY);
                arrows.put(IShipBuildingView.ViewDirection.UP, IShipBuildingView.PartSelectionView.ENGINE);
                arrows.put(IShipBuildingView.ViewDirection.RIGHT, IShipBuildingView.PartSelectionView.POWER_CORE);
                arrows.put(IShipBuildingView.ViewDirection.DOWN, IShipBuildingView.PartSelectionView.CANNON);
                set_arrows();
                break;
            default:
                assert false;
                view.setPartViewImageList(state, new LinkedList<Integer>());
                break;
        }
    }
    private void set_arrows(){
        view.setArrow(state,IShipBuildingView.ViewDirection.LEFT,true, part_selection_to_string(arrows.get(IShipBuildingView.ViewDirection.LEFT)));
        view.setArrow(state,IShipBuildingView.ViewDirection.UP,true, part_selection_to_string(arrows.get(IShipBuildingView.ViewDirection.UP)));
        view.setArrow(state,IShipBuildingView.ViewDirection.RIGHT,true, part_selection_to_string(arrows.get(IShipBuildingView.ViewDirection.RIGHT)));
        view.setArrow(state,IShipBuildingView.ViewDirection.DOWN,true, part_selection_to_string(arrows.get(IShipBuildingView.ViewDirection.DOWN)));
    }
    private String part_selection_to_string(IShipBuildingView.PartSelectionView part_selection){
        String output = new String();
        switch(part_selection){
            case MAIN_BODY:
                output="Main Bodies";
            case ENGINE:
                output="Engines";
            case POWER_CORE:
                output="Power Cores";
            case CANNON:
                output="Cannons";
            case EXTRA_PART:
                output="Extra Parts";
            default:
                assert false;
        }
        return output;
    }
    /**
     * This calls the content manager and keeps track of all loaded content.
     * @param content An instance of the content manager. This should be used to load images and sound.
     */
    @Override
    public void loadContent(ContentManager content) {
        if(!content_loaded){
            main_body_ids = load(main_bodies, content);
            engine_ids = load(engines, content);
            power_core_ids = load(power_cores, content);
            cannon_ids = load(cannons, content);
            extra_part_ids = load(extra_parts, content);
            content_loaded = true;
        }
    }
    private List<Integer> load (List<? extends ShipPart> parts, ContentManager content) {
        List<Integer> output=new LinkedList<>();
        Iterator<? extends ShipPart> index = parts.iterator();
        while (index.hasNext()) {
            ShipPart current_part = index.next();
            int content_id = content.loadImage(current_part.getImage().getPath());
            output.add(content_id);
            current_part.getImage().setContentID(content_id);
        }
        return output;
    }
    @Override
    public void unloadContent(ContentManager content) {
        if(content_loaded){
            unload(main_body_ids, content);
            unload(main_body_ids, content);
            unload(engine_ids, content);
            unload(power_core_ids, content);
            unload(cannon_ids, content);
            unload(extra_part_ids, content);
            content_loaded = false;
        }
    }
    private void unload(List<Integer> part_ids, ContentManager content){
        Iterator<Integer> index = part_ids.iterator();
        while(index.hasNext()) {
            content.unloadImage(index.next());
        }
    }
    @Override
    public void onSlideView(IShipBuildingView.ViewDirection direction) {
        IShipBuildingView.ViewDirection new_direction;
        switch (direction) {
            case UP:
                new_direction = IShipBuildingView.ViewDirection.DOWN;
                break;
            case DOWN:
                new_direction = IShipBuildingView.ViewDirection.UP;
                break;
            case LEFT:
                new_direction = IShipBuildingView.ViewDirection.RIGHT;
                break;
            case RIGHT:
                new_direction = IShipBuildingView.ViewDirection.LEFT;
                break;
            default:
                assert false;
                new_direction = IShipBuildingView.ViewDirection.UP;
        }
        state=arrows.get(new_direction);
        view.animateToView(state, new_direction);
    }
    /**
     *  This adds a part to the ship.
     * @param index The list index of the selected part.
     */
    @Override
    public void onPartSelected(int index) {
        switch (state) {
            case MAIN_BODY:
                ship.setMainBody(main_bodies.get(index));
                break;
            case EXTRA_PART:
                ship.setExtraPart(extra_parts.get(index));
                break;
            case CANNON:
                ship.setCannon(cannons.get(index));
                break;
            case ENGINE:
                ship.setEngine(engines.get(index));
                break;
            case POWER_CORE:
                ship.setPowerCore(power_cores.get(index));
                break;
            default:
                assert false;
                break;
        }
        if (ship.isComplete()) {
            view.setStartGameButton(true);
        }
        else {
            view.setStartGameButton(false);
        }
    }
    /**
     * Draw the ship on the center of the screen.
     */
    @Override
    public void draw() {ship.draw(gameViewCenter, (float) SHIP_SCALE);}
    /**
     * This starts the game when the button is pressed.
     */
    @Override
    public void onStartGamePressed() {view.startGame();}
    /**
     * This refreshes the screen. Its probably not needed but oh well.
     */
    @Override
    public void onResume() {onViewLoaded(state);}
    /**
     * For this part the function is left blank
     * @param elapsedTime Time since the last update. For this game, elapsedTime is always
     */
    @Override
    public void update(double elapsedTime) {}
    /**
     * For this part the function is left blank
     * @return      the current view as implemented in IView
     */
    @Override
    public IView getView() {return null;}
    /**
     * For this part the function is left blank
     * @param _view     the current view as implemented in IView
     */
    @Override
    public void setView(IView _view) {}
/*
CONSTANTS/FINALS
 */
    private final PointF gameViewCenter = new PointF(DrawingHelper.getGameViewWidth() /2, DrawingHelper.getGameViewHeight() / 2);
/*
GETTERS/SETTERS
 */
}
