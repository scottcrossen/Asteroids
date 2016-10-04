package edu.byu.cs.superasteroids.model;

import android.graphics.PointF;

/**
 * Any object that exists in the background with a position but isn't interacted with is this class.
 */
public class BackgroundObject extends PositionedObject {
    /**
     * The constructor for a background object
     * @param image     how the object looks
     * @param position  where the object is located.
     */
    public BackgroundObject(Image image, PointF position) {
        //include scale here that changes "visible object" scale.
        super(image, position);
    }
}
