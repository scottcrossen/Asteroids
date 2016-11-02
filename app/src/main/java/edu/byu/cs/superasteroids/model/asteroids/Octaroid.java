package edu.byu.cs.superasteroids.model.asteroids;

import android.graphics.PointF;

import edu.byu.cs.superasteroids.model.Image;

/**
 * One of the three classes of Asteroids
 * @author Scott Leland Crossen
 */
public class Octaroid extends Asteroid {
/*
FIELDS
 */
/*
CONSTRUCTORS
 */
    /**
     * The constructor for this type of asteroid
     * @param image     the image of the asteroid.
     */
    public Octaroid(Image image){
        super(image);
    }
/*
METHODS
 */
    @Override
    public int addUponDeletion()
    {
        return 8;
    }
/*
CONSTANTS/FINALS
 */
/*
GETTERS/SETTERS
 */
}
