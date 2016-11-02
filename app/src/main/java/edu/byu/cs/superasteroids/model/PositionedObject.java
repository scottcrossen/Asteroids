package edu.byu.cs.superasteroids.model;

import android.graphics.PointF;

import edu.byu.cs.superasteroids.drawing.DrawingHelper;
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
        if (_position != null) {
            position = _position;
        }
        else {
            position = new PointF(0, 0);
        }
    }
/*
METHODS
 */
    /**
     * Draws the object if in the viewport.
     */
    @Override
    public void draw() {
        PointF view_coords = getViewCoords();
        DrawingHelper.drawImage(image.getContentID(), view_coords.x, view_coords.y, getRotation(), getScale(), getScale(), 255);
    }
/*
CONSTANTS/FINALS
 */
/*
GETTERS/SETTERS
 */
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
    public void setViewPort(ViewPort viewPort) {
        view_port = viewPort;
    }
    public PointF getViewCoords() {
        return view_port.convertToViewPort(position);
    }

    public PointF getMapCoords() {
        return position;
    }
    public void setMapCoords(PointF point) {
        position = point;
    }
}
