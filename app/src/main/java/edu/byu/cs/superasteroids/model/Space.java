package edu.byu.cs.superasteroids.model;

import android.graphics.PointF;
import android.graphics.RectF;

import edu.byu.cs.superasteroids.drawing.DrawingHelper;

/**
 * This is the background image of the game
 * @author Scott Leland Crossen
 */
public class Space extends PositionedObject{
/*
FIELDS
 */
    private float scale_x;
    private float scale_y;
/*
CONSTRUCTORS
 */
    /**
     * The constructor of the background image.
     */
    public Space(RectF level_bound) {
        super(new Image("images/space.bmp", 2048, 2048), null);
        setScale(level_bound.right, level_bound.bottom);
    }
/*
METHODS
 */
    /**
     * This method takes a width and height of the space and scales it.
     * @param width     the width of the object
     * @param height    the height of the object.
     */
    public void setScale(float width, float height) {
        scale_x = width / 2048;
        scale_y = height / 2048;
        setPosition(new PointF(width / 2, height / 2));
    }
    /**
     * Draws the object on screen.
     */
    @Override
    public void draw() {
        PointF view_coords = view_port.convertToViewPort(getPosition());
        DrawingHelper.drawImage(getImage().getContentID(), view_coords.x, view_coords.y, (float) 0, scale_x, scale_y, 255);
    }
/*
CONSTANTS/FINALS
 */
/*
GETTERS/SETTERS
 */
}
