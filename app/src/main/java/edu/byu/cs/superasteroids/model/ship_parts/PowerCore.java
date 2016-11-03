package edu.byu.cs.superasteroids.model.ship_parts;

import edu.byu.cs.superasteroids.model.Image;

/**
 * One of the parts of a ship
 * @author Scott Leland Crossen
 */
public class PowerCore extends ShipPart {
/*
FIELDS
 */
    /**
     * the data regarding how much the cannon is strengthened by is recorded as an integer
     */
    private int cannon_boost;
    /**
     * the data regarding how much the engine is strengthened by is recorded as an integer
     */
    private int engine_boost;
/*
CONSTRUCTORS
 */
    /**
     * the constructor for the power core
     * @param image         how the power core looks
     * @param _cannon_boost how much the core boosts the cannon by
     * @param _engine_boost how much the core boosts the engine by
     */
    public PowerCore(Image image, int _cannon_boost, int _engine_boost) {
        super(image, null);
        cannon_boost = _cannon_boost;
        engine_boost = _engine_boost;
    }
/*
METHODS
 */
    /**
     * The getter for the mount point where this part attaches.
     * @param main_body the main body it attaches to
     * @return the created mount point
     */
    @Override
    public MountPoint getBodyAttachPoint(MainBody main_body) {return null;}
/*
CONSTANTS/FINALS
 */
/*
GETTERS/SETTERS
 */
    /**
     * The getter for the cannon boost amount.
     * @return  cannon boost
     */
    public int getCannonBoost() {return cannon_boost;}
    /**
     * The setter for the cannon boost amount.
     * @param cannon_boost  the cannon-boost amount.
     */
    public void setCannonBoost(int cannon_boost) {this.cannon_boost = cannon_boost;}
    /**
     * The getter for the engine boost amount.
     * @return  engine boost
     */
    public int getEngineBoost() {return engine_boost;}
    /**
     * The setter of the engine boost amount.
     * @param engine_boost  engine boost
     */
    public void setEngineBoost(int engine_boost) {this.engine_boost = engine_boost;}
}
