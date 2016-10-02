package edu.byu.cs.superasteroids.model;

/**
 * Created by slxn42 on 10/1/16.
 */
public abstract class MovingObject extends PositionedObject {
    private float rotation_drift_speed =(float)0;
    protected int horizontal_speed=0;
    protected int vertical_speed=0;
    public void update(){}
    public void setSpeed(){}
}
