package edu.byu.cs.superasteroids.model.ship_parts;

import android.graphics.PointF;

import java.util.LinkedList;
import java.util.List;

import edu.byu.cs.superasteroids.model.Image;
import edu.byu.cs.superasteroids.model.MovingObject;

/**
 * The overall Ship-build class.
 * @author Scott Leland Crossen
 */
public class Ship extends MovingObject {
/*
FIELDS
 */
    /**
     * The time it takes untill the ship can fire again.
     */
    private double time_until_fire = 0;
    /**
     * The main body of the ship.
     */
    private MainBody main_body;
    /**
     * This cannon gets attached in the constructor.
     */
    private Cannon cannon;
    /**
     * This extra part gets attached in the constructor.
     */
    private ExtraPart extrapart;
    /**
     * This engine gets attached in the constructor.
     */
    private Engine engine;
    /**
     * This powercore gets attached in the constructor.
     */
    private PowerCore powercore;
    /**
     * The ship's current list of bullets outstanding.
     */
    private static List<Projectile> bullets = new LinkedList<>();
    /**
     * The only instance of the ship.
     */
    private static Ship ourInstance = new Ship();
    /**
     * How long it takes to recharge it's bullets.
     */
    private static final double FIRE_RATE = .5; //the rate of fire between bullets (bullets per second)
/*
CONSTRUCTORS
 */
    /**
     * The constructor for the ship object.
     */
    private Ship() {    //private because its a singleton
        super(new Image(null, 650, 650), new PointF(0, 0), 0, 0);
    }
/*
METHODS
 */
    /**
     * The getter of the only-allowed instance of the ship.
     * @return  the current ship
     */
    public static Ship getInstance() {
        return ourInstance;
    }
    /**
     * Creates a new ship.
     */
    public static void createNew() {
        ourInstance = new Ship();
    }
    /**
     * Update the ship on the screen.
     */
    @Override
    public void update(){}
    /**
     * Updates the ship on the screen for a given elapsed time.
     * @param elapsedTime   the time elapsed.
     */
    public void update(double elapsedTime){}

/*
CONSTANTS/FINALS
 */
/*
GETTERS/SETTERS
 */
    /**
     * The getter for the main-body
     * @return  the main-body
     */
    public MainBody getMainBody() {
        return main_body;
    }
    /**
     * The setter of the main-body
     * @param main_body the main-body
     */
    public void setMainBody(MainBody main_body) {
        this.main_body = main_body;
    }
    /**
     * The getter of the cannon
     * @return  the cannon
     */
    public Cannon getCannon() {
        return cannon;
    }
    /**
     * The setter of the cannon
     * @param cannon    the cannon
     */
    public void setCannon(Cannon cannon) {
        this.cannon = cannon;
    }
    /**
     * The getter of the extra part
     * @return  the extra-part
     */
    public ExtraPart getExtraPart() {
        return extrapart;
    }
    /**
     * The settter of the extra-part
     * @param extrapart the extra-part
     */
    public void setExtraPart(ExtraPart extrapart) {
        this.extrapart = extrapart;
    }
    /**
     * The getter of the engine
     * @return  the engine
     */
    public Engine getEngine() {
        return engine;
    }
    /**
     * The setter of the engine
     * @param engine    the engine
     */
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
    /**
     * The getter of the power-core
     * @return  the power-core
     */
    public PowerCore getPowerCore() {
        return powercore;
    }
    /**
     * The setter of the power-core
     * @param powercore the power-core.
     */
    public void setPowerCore(PowerCore powercore) {
        this.powercore = powercore;
    }
    /**
     * The getter for the bullet-list
     * @return  the bullet-list
     */
    public static List<Projectile> getBullets() {
        return bullets;
    }
    /**
     * The getter for the ship
     * @return  the current ship
     */
    public static Ship getOurInstance() {
        return ourInstance;
    }
    /**
     * The getter for the fire-rate
     * @return  the fire-rate.
     */
    public static double getFireRate() {
        return FIRE_RATE;
    }
}