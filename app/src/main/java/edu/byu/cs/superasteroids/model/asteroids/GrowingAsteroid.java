package edu.byu.cs.superasteroids.model.asteroids;

import android.graphics.PointF;

import edu.byu.cs.superasteroids.model.Image;

/**
 * One of the three classes of Asteroids
 * @author Scott Leland Crossen
 */
public class GrowingAsteroid extends Asteroid {
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
    public GrowingAsteroid(Image image) {
        super(image);
    }
    public GrowingAsteroid(Image image, PointF _map_coords)
    {
        super(image);
        setScale((float) .5);
        setMapCoords(_map_coords);
    }
/*
METHODS
 */
    @Override
    public void update(double elapsedTime) {
        setScale((float)(getScale() + elapsedTime*SCALE_INCREMENT));
        super.update(elapsedTime);
    }
    @Override
    public int addUponDeletion() {
        if (getScale() > 1) {
            return (int) (getScale() * super.addUponDeletion());
        }
        else
        {
            return 0;
        }
    }
    @Override
    public boolean isGrowing()
    {
        return true;
    }
/*
CONSTANTS/FINALS
 */
    private static final double SCALE_INCREMENT = 0.05;
/*
GETTERS/SETTERS
 */
}
