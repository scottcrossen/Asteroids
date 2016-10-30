package edu.byu.cs.superasteroids.model.ship_parts;

import android.graphics.PointF;

import java.util.LinkedList;
import java.util.List;

import edu.byu.cs.superasteroids.model.Image;
import edu.byu.cs.superasteroids.model.MovingObject;

/**
 * The bullets of the ship.
 * @author Scott Leland Crossen
 */
public class Projectile extends MovingObject{
/*
FIELDS
 */
    /**
     * The speed of each bullet.
     */
    private static final int PROJECTILE_SPEED = 450;
    /**
     * The remaining time of the bullet's life.
     */
    private double time_remaining = 5;
/*
CONSTRUCTORS
 */
    /**
     * The constructor for a projectile
     * @param image     how the projectile looks
     * @param direction_deg the intiial direction of the projectile
     */
    Projectile(Image image, PointF map_coords, float direction_deg, float scale)
    {
        super(image, map_coords, PROJECTILE_SPEED, direction_deg);
    }
/*
METHODS
 */
    /**
     * The update function is overridden for projectiles. They move slightly different.
     */
    public void update(){}
    /**
     * The update function is overridden for projectiles. They move slightly different.
     * @param elapsedTime   The elapsed time of the game.
     */
    @Override
    public void update(double elapsedTime)
    {
        time_remaining -= elapsedTime;
    }
/*
CONSTANTS/FINALS
 */
/*
GETTERS/SETTERS
 */
    /**
     * The getter of the projectile Speed
     * @return  the projectile speed
     */
    public static int getProjectileSpeed() {
        return PROJECTILE_SPEED;
    }
    /**
     * The getter of the time remaining value
     * @return  the time remaining
     */
    public double getTime_remaining() {
        return time_remaining;
    }
}
