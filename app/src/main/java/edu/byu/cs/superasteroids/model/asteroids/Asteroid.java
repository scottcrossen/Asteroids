package edu.byu.cs.superasteroids.model.asteroids;

import android.graphics.PointF;

import edu.byu.cs.superasteroids.model.Image;
import edu.byu.cs.superasteroids.model.MovingObject;

/**
 * This class describes the behavior of any of the subclasses of asteroids.
 * @author Scott Leland Crossen
 */
public abstract class Asteroid extends MovingObject {
    /**
     * The constructor for the asteroid class
     * @param image     the image of the asteroid.
     */
    public Asteroid(Image image)
    {
        super(image, new PointF(0, 0), 0, 0);
    }
}
