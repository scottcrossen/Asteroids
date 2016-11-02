package edu.byu.cs.superasteroids.model.asteroids;

import android.graphics.PointF;

import java.util.Iterator;

import edu.byu.cs.superasteroids.core.GraphicsUtils;
import edu.byu.cs.superasteroids.model.Image;
import edu.byu.cs.superasteroids.model.MovingObject;
import edu.byu.cs.superasteroids.model.ship_parts.Projectile;
import edu.byu.cs.superasteroids.model.ship_parts.Ship;

/**
 * This class describes the behavior of any of the subclasses of asteroids.
 * @author Scott Leland Crossen
 */
public abstract class Asteroid extends MovingObject {
/*
FIELDS
 */

    private float level_width;

    private float level_height;
/*
CONSTRUCTORS
 */
    /**
     * The constructor for the asteroid class
     * @param image     the image of the asteroid.
     */
    public Asteroid(Image image) {
        super(image, new PointF(0, 0), -1, -1); //the start values are not important until the init function is ran
        setScale(1);
        enableRotationDrift();
    }
/*
METHODS
 */
@Override
public void update(double elapsedTime) {
    GraphicsUtils.RicochetObjectResult result = GraphicsUtils.ricochetObject(getMapCoords(), getBound(), GraphicsUtils.degreesToRadians(direction - 90), level_width, level_height);
    setMapCoords(result.getNewObjPosition(), result.getNewObjBounds());
    direction = (float)GraphicsUtils.radiansToDegrees(result.getNewAngleRadians());
    super.update(elapsedTime);
    checkCollisions(Ship.getInstance());
}

    public int addUponDeletion()
    {
        return 2;
    }

    public void checkCollisions(Ship ship)
    {
        if (getBound().intersect(ship.getBound()))
        {
            ship.touch();
            touch();
        }

        Iterator<Projectile> bullet_index = ship.getProjectiles().iterator();

        while(bullet_index.hasNext())
        {
            Projectile current_bullet = bullet_index.next();
            if (getBound().intersect(current_bullet.getBound()))
            {
                current_bullet.touch();
                touch();
            }
        }
    }

    public void init(float level_width, float level_height)
    {
        setMapCoords(new PointF((float)Math.random() * level_width, (float)Math.random() * level_width));
        initVector(level_width, level_height);
    }

    public void initVector(float level_width, float level_height)
    {
        this.level_width = level_width;
        this.level_height = level_height;
        speed = (int)((Math.random() * (MAX_SPEED - MIN_SPEED)) + MIN_SPEED);
        direction = (int)(Math.random() * 360);
    }

    public boolean isGrowing() {
        return false;
    }
/*
CONSTANTS/FINALS
 */

    private static final int MAX_SPEED = 400;

    private static final int MIN_SPEED = 200;

    private static final double SCALE_INCREMENT = 1.1;
/*
GETTERS/SETTERS
 */
}
