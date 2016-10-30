package edu.byu.cs.superasteroids.model;

import android.graphics.PointF;

import edu.byu.cs.superasteroids.game.ViewPort;

/**
 * Any object that has an x,y coordinate is considered a positioned object.
 * @author Scott Leland Crossen
 */
public abstract class PositionedObject extends VisibleObject{
/*
FIELDS
 */
    protected ViewPort view_port;
    /**
     * The position of the object.
     */
    private PointF position; // The x, y coordinates.
/*
CONSTRUCTORS
 */
    /**
     * The constructor of the positioned object
     * @param image     how the object looks
     * @param _position  where the object is located.
     */
    public PositionedObject(Image image, PointF _position) {
        super(image);
        position=_position;
    }
/*
METHODS
 */
    /**
     * Draws the object if in the viewport.
     */
    @Override
    public void draw(){}
/*
CONSTANTS/FINALS
 */
/*
GETTERS/SETTERS
 */
public PointF getViewCoords()
{
    return view_port.convertToView(position);
}
    /**
     * The getter for position
     * @return  the current position of the object
     */
    public PointF getPosition() {
        return position;
    }
    /**
     * The setter for the position
     */
    public void setPosition(PointF _position){
        position=_position;
    }
}
