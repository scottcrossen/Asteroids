package edu.byu.cs.superasteroids.model;

/**
 * Any object that can be seen on screen inherits properties from this or one of it's extended classes.
 * @author Scott Leland Crossen
 */
public abstract class VisibleObject extends Object {
    private float rotation =(float)0;
    private float scale = (float)1;
    protected Image image=new Image();
    /**
     * The constructor of the visible object
     * @param _image     how the object looks
     */
    public VisibleObject(Image _image) {
        image=_image;
    }
    /**
     * Set what angle the image of the object will appear on screen.
     */
    public void setRotation(){}
    /**
     * Draws the object on screen.
     */
    public abstract void draw();
}
