package edu.byu.cs.superasteroids.model.asteroids;

import android.graphics.PointF;

import edu.byu.cs.superasteroids.model.Image;

/**
 * One of the three classes of Asteroids
 * @author Scott Leland Crossen
 */
public class Octeroid extends Asteroid {
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
    public Octeroid(Image image){
        super(image);
    }
/*
METHODS
 */
    /**
     * The amount of asteroids to create out of this one when it gets shot.
     */
    @Override
    public int addUponDeletion() {
        return DELETION_CHILDREN_SIZE;
    }
/*
CONSTANTS/FINALS
 */
    private static final int DELETION_CHILDREN_SIZE=8;
/*
GETTERS/SETTERS
 */
}
