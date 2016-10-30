package edu.byu.cs.superasteroids.model;

/**
 * Any object that can be seen on screen inherits properties from this or one of it's extended classes.
 * @author Scott Leland Crossen
 */
public abstract class VisibleObject extends Object {
/*
FIELDS
 */
    /**
     * The rotation of the object's image on screen.
     */
    private float rotation =(float)0;
    /**
     * The scale of the image displayed.
     */
    private float scale = (float)1;
    /**
     * The image of the visible object has a class "Image".
     */
    protected Image image;
/*
CONSTRUCTORS
 */
    /**
     * The constructor of the visible object
     * @param _image     how the object looks
     */
    public VisibleObject(Image _image) {
        image=_image;
    }
/*
METHODS
 */
    /**
     * Draws the object on screen.
     */
    public abstract void draw();
/*
CONSTANTS/FINALS
 */
/*
GETTERS/SETTERS
 */
    /**
     * The getter for rotation
     * @return  the current rotation
     */
    public float getRotation() {
        return rotation;
    }
    /**
     * The setter for rotation
     */
    public void setRotation(){}
    /**
     * The getter for the image scale
     * @return  the image scale
     */
    public float getScale() {
        return scale;
    }
    /**
     * the getter for the image
     * @return  the image.
     */
    public Image getImage() {
        return image;
    }
}