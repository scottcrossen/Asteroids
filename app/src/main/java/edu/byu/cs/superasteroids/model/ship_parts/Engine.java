package edu.byu.cs.superasteroids.model.ship_parts;

import edu.byu.cs.superasteroids.model.Image;

/**
 * One of the parts of a ship
 * @author Scott Leland Crossen
 */
public class Engine extends ShipPart{
/*
FIELDS
 */
    /**
     * the speed of the engine is stored as an integer
     */
    private int base_speed;
    /**
     * the turning speed of the engine is also stored as an integer
     */
    private int base_turn_rate;
/*
CONSTRUCTORS
 */
    /**
     * The constructor for an engine
     * @param image             how the engine looks
     * @param mount_point       where the engine connects to the ship
     * @param _base_speed       how fast the engine makes the ship move
     * @param _base_turn_rate   how fast the engine makes the ship turn by
     */
    public Engine(Image image, MountPoint mount_point, int _base_speed, int _base_turn_rate) {
        super(image, mount_point);
        base_speed = _base_speed;
        base_turn_rate = _base_turn_rate;
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
    /**
     * The getter for the translational speed.
     * @return  the translational speed.
     */
    public int getBaseSpeed() {
        return base_speed;
    }
    /**
     * The setter for the translational speed
     * @param base_speed    the translational speed.
     */
    public void setBaseSpeed(int base_speed) {
        this.base_speed = base_speed;
    }
    /**
     * The getter for the rotational speed.
     * @return  the translational speed.
     */
    public int getBaseTurnRate() {
        return base_turn_rate;
    }
    /**
     * The getter for the rotational speed.
     * @param base_turn_rate    the translational speed.
     */
    public void setBaseTurnRate(int base_turn_rate) {
        this.base_turn_rate = base_turn_rate;
    }
}
