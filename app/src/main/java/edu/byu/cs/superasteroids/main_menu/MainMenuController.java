package edu.byu.cs.superasteroids.main_menu;

import java.util.List;

import edu.byu.cs.superasteroids.base.IView;
import edu.byu.cs.superasteroids.database.Database;
import edu.byu.cs.superasteroids.model.ship_parts.Cannon;
import edu.byu.cs.superasteroids.model.ship_parts.Engine;
import edu.byu.cs.superasteroids.model.ship_parts.ExtraPart;
import edu.byu.cs.superasteroids.model.ship_parts.MainBody;
import edu.byu.cs.superasteroids.model.ship_parts.PowerCore;
import edu.byu.cs.superasteroids.model.ship_parts.Ship;

/**
 * Created by slxn42 on 10/29/16.
 */
public class MainMenuController implements IMainMenuController {
/*
FIELDS
 */
    private IMainMenuView view;
    private Database db;
/*
CONSTRUCTORS
 */
    public MainMenuController(MainActivity main_activity) {
        db = new Database(main_activity);//Initialize the database
        view = main_activity;
    }
/*
METHODS
 */
/*
CONSTANTS/FINALS
 */
/*
GETTERS/SETTERS
 */
    @Override
    public void onQuickPlayPressed() {
        Ship.createNew();
        Ship ship = Ship.getInstance();
        //load the parts from the database
        List<MainBody> main_bodies = db.dao.getMainBodies();
        List<Engine> engines = db.dao.getEngines();
        List<PowerCore> power_cores = db.dao.getPowerCores();
        List<Cannon> cannons = db.dao.getCannons();
        List<ExtraPart> extra_parts = db.dao.getExtraParts();
        // Find random parts and set the random parts to the ship
        ship.setMainBody(main_bodies.get((int)(Math.random() * (main_bodies.size()))));
        ship.setPowerCore(power_cores.get((int)(Math.random() * (power_cores.size()))));
        ship.setCannon(cannons.get((int)(Math.random() * (cannons.size()))));
        ship.setExtraPart(extra_parts.get((int)(Math.random() * (extra_parts.size()))));
        ship.setEngine(engines.get((int)(Math.random() * (engines.size()))));
        view.startGame();
    }
    @Override
    public IView getView() {return null;}
    @Override
    public void setView(IView view) {}
}
