package edu.byu.cs.superasteroids.model;

import android.graphics.PointF;

/**
 * Any obect that moves on screen is a moving object.
 * @author Scott Leland Crossen
 */
public abstract class MovingObject extends PositionedObject {
/*
FIELDS
 */
    /**
     * The drift-speed of the object's rotation.
     */
    private float rotation_drift_speed =(float)0;
    /**
     * The speed of the object
     */
    protected int speed=0;
    /**
     * The direction the object is moving
     */
    protected float speed_direction=0;
/*
CONSTRUCTORS
 */
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
/*
METHODS
 */
    /**
     * Redraw the object according to how much time has past.
     */
    public void update(){}
/*
CONSTANTS/FINALS
 */
/*
GETTERS/SETTERS
 */
    /**
     * The getter for the rotation drift speed
     * @return  the rotation drift speed
     */
    public float getRotation_drift_speed() {
        return rotation_drift_speed;
    }
    /**
     * The getter for the translational speed
     * @return  the translational speed
     */
    public int getSpeed() {
        return speed;
    }
    /**
     * The getter for the rotational speed
     * @return  the rotational speed.
     */
    public float getSpeed_direction() {
        return speed_direction;
    }
    /**
     * The setter for the speed
     */
    public void setSpeed(){}
}
