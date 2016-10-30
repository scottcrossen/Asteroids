package edu.byu.cs.superasteroids.ship_builder;

import android.graphics.PointF;

import java.util.LinkedList;
import java.util.List;

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
    private boolean content_is_loaded = false;
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
        state=partView;
        switch(state){
            case MAIN_BODY:
                view.setPartViewImageList(state, main_body_ids);
                view.setArrow(state, IShipBuildingView.ViewDirection.LEFT, true, "Engines");
                view.setArrow(state, IShipBuildingView.ViewDirection.UP, true, "Power Cores");
                view.setArrow(state, IShipBuildingView.ViewDirection.RIGHT, true, "Cannons");
                view.setArrow(state, IShipBuildingView.ViewDirection.DOWN, true, "Extra Parts");
                break;
            case ENGINE:
                view.setPartViewImageList(state, engine_ids);
                view.setArrow(state, IShipBuildingView.ViewDirection.LEFT, true, "Power Cores");
                view.setArrow(state, IShipBuildingView.ViewDirection.UP, true, "Cannons");
                view.setArrow(state, IShipBuildingView.ViewDirection.RIGHT, true, "Extra Parts");
                view.setArrow(state, IShipBuildingView.ViewDirection.DOWN, true, "Main Bodies");
                break;
            case POWER_CORE:
                view.setPartViewImageList(state, power_core_ids);
                view.setArrow(state, IShipBuildingView.ViewDirection.LEFT, true, "Cannons");
                view.setArrow(state, IShipBuildingView.ViewDirection.UP, true, "Extra Parts");
                view.setArrow(state, IShipBuildingView.ViewDirection.RIGHT, true, "Main Bodies");
                view.setArrow(state, IShipBuildingView.ViewDirection.DOWN, true, "Engines");
                break;
            case CANNON:
                view.setPartViewImageList(state, cannon_ids);
                view.setArrow(state, IShipBuildingView.ViewDirection.LEFT, true, "Extra Parts");
                view.setArrow(state, IShipBuildingView.ViewDirection.UP, true, "Main Bodies");
                view.setArrow(state, IShipBuildingView.ViewDirection.RIGHT, true, "Engines");
                view.setArrow(state, IShipBuildingView.ViewDirection.DOWN, true, "Power Cores");
                break;
            case EXTRA_PART:
                view.setPartViewImageList(state, extra_part_ids);
                view.setArrow(state, IShipBuildingView.ViewDirection.LEFT, true, "Main Bodies");
                view.setArrow(state, IShipBuildingView.ViewDirection.UP, true, "Engines");
                view.setArrow(state, IShipBuildingView.ViewDirection.RIGHT, true, "Power Cores");
                view.setArrow(state, IShipBuildingView.ViewDirection.DOWN, true, "Cannons");
                break;
            default:
                assert false;
                view.setPartViewImageList(state,new LinkedList<Integer>());
                break;
        }
        if (ship.isComplete()) {
            view.setStartGameButton(true);
        } else {
            view.setStartGameButton(false);
        }
    }
    @Override
    public void loadContent(ContentManager content) {

    }
    @Override
    public void unloadContent(ContentManager content) {

    }
    @Override
    public void onSlideView(IShipBuildingView.ViewDirection direction) {

    }
    @Override
    public void onPartSelected(int index) {

    }
    /**
     * Draw the ship on the center of the screen.
     */
    @Override
    public void draw() {
        //final PointF gameViewCenter = new PointF(DrawingHelper.getGameViewWidth() /2, DrawingHelper.getGameViewHeight() / 2);
        //ship.draw(gameViewCenter, (float)SHIP_SCALE);

    }
    /**
     * This starts the game when the button is pressed.
     */
    @Override
    public void onStartGamePressed() {
        view.startGame();
    }
    /**
     * This refreshes the screen. Its probably not needed but oh well.
     */
    @Override
    public void onResume() {
        onViewLoaded(state);
    }
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
    public IView getView() {
        return null;
    }
    /**
     * For this part the function is left blank
     * @param _view     the current view as implemented in IView
     */
    @Override
    public void setView(IView _view) {}
/*
CONSTANTS/FINALS
 */
/*
GETTERS/SETTERS
 */
}
