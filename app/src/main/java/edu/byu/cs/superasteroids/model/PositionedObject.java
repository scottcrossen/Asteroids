package edu.byu.cs.superasteroids.model;

import android.graphics.PointF;

/**
 * Any object that has an x,y coordinate is considered a positioned object.
 * @author Scott Leland Crossen
 */
public abstract class PositionedObject extends VisibleObject{
    private PointF position; // The x, y coordinates.
    /**
     * The constructor of the positioned object
     * @param image     how the object looks
     * @param _position  where the object is located.
     */
    public PositionedObject(Image image, PointF _position) {
        super(image);
        position=_position;
    }
    public void setPosition(){}
    /**
     * Draws the object if in the viewport.
     */
    @Override
    public void draw(){}
}
