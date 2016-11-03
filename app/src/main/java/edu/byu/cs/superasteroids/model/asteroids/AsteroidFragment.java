package edu.byu.cs.superasteroids.model.asteroids;

import android.graphics.PointF;

import edu.byu.cs.superasteroids.model.Image;

/**
 * Asteroids splinter into these when shot.
 * @author Scott Leland Crossen
 */
public class AsteroidFragment extends Asteroid{
/*
FIELDS
 */
/*
CONSTRUCTORS
 */
    /**
     * The constructor for this type of asteroid
     * @param image     the image of the asteroid.
     * @param _map_coords    the location of the created asteroid on the map
     */
    public AsteroidFragment(Image image, PointF _map_coords) {
        super(image);
        setScale((float) .5);
        setPosition(_map_coords);
    }
/*
METHODS
 */
    /**
     * Returns how many asteroids to create when this one dies.
     * @return  Hint: its zero.
     */
    @Override
    public int addUponDeletion() {
        return DELETION_CHILDREN_SIZE;
    }
/*
CONSTANTS/FINALS
 */
    private static final int DELETION_CHILDREN_SIZE=0;
/*
GETTERS/SETTERS
 */
}
