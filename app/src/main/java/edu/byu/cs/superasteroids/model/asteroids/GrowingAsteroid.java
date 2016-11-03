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
    /**
     * The constructor given image and position
     * @param image     the image of the asteroid.
     */
    public GrowingAsteroid(Image image, PointF _map_coords) {
        super(image);
        setScale((float) .5);
        setPosition(_map_coords);
    }
/*
METHODS
 */
    /**
     * The inherited update function overriden here so it can grow.
     */
    @Override
    public void update(double elapsedTime) {
        setScale((float)(getScale() + elapsedTime*SCALE_INCREMENT));
        super.update(elapsedTime);
    }
    /**
     * Returns how many asteroids to return when this one gets shot.
     */
    @Override
    public int addUponDeletion() {
        if (getScale() > 1)
            return (int) (getScale() * super.addUponDeletion());
        else
            return 0;
    }
    /**
     * returns whether this asteroid is growing.
     * @return  true. it is. that's the whole purpose of this class.
     */
    @Override
    public boolean isGrowing() {
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
