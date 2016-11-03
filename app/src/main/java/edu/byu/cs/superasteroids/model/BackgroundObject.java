package edu.byu.cs.superasteroids.model;

import android.graphics.PointF;

/**
 * Any object that exists in the background with a position but isn't interacted with is this class.
 * @author Scott Leland Crossen
 */
public class BackgroundObject extends PositionedObject {
/*
FIELDS
 */
    /**
     * the scale is the factor to resize the image by
     */
    private float scale;
    private int id;
/*
CONSTRUCTORS
 */
    /**
     * The constructor for a background object
     * @param image     how the object looks
     * @param position  where the object is located.
     * @param _id       the id of the object
     * @param _scale    the scale of the image
     */
    public BackgroundObject(Image image, PointF position, int _id, float _scale) {
        super(image, position);
        scale = _scale;
        id = _id;
    }
/*
METHODS
 */
/*
CONSTANTS/FINALS
 */
/*
GETTERS/SETTERS
 */
    public float getScale() {return scale;}
    public int getID() {
        return id;
    }
}
