package edu.byu.cs.superasteroids.model;

import android.graphics.PointF;

/**
 * Any obect that moves on screen is a moving object.
 * @author Scott Leland Crossen
 */
public abstract class MovingObject extends PositionedObject {
    private float rotation_drift_speed =(float)0;
    protected int speed=0;
    protected float speed_direction=0;
    /**
     * The constructor of the positioned object
     * @param image     how the object looks
     * @param position  where the object is located.
     * @param _speed     the speed of the object
     * @param _speed_direction   the direction of the speed of the object
     */
    public MovingObject(Image image, PointF position, int _speed, float _speed_direction) {
        super(image, position);
        speed=_speed;
        speed_direction=_speed_direction;
    }
    /**
     * Redraw the object according to how much time has past.
     */
    public void update(){}

    /**
     * Set the speed of the object
     */
    public void setSpeed(){}
}
