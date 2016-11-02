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
        setMapCoords(_map_coords);
    }
/*
METHODS
 */
    @Override
    public int addUponDeletion()
    {
        return 0;
    }
/*
CONSTANTS/FINALS
 */
/*
GETTERS/SETTERS
 */
}
