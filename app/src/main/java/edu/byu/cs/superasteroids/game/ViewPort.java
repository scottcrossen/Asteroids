package edu.byu.cs.superasteroids.game;

import android.graphics.PointF;
import android.graphics.RectF;

/**
 * The object that shows the visible section of the screen.
 * @author Scott Leland Crossen
 */
public class ViewPort {
/*
FIELDS
 */
    /*private Ship ship;*/
    /**
     * The dimensions of the viewport
     */
    private RectF dimensions;
    /**
     * The dimension of the level.
     */
    private RectF level_dimensions;
/*
CONSTRUCTORS
 */
/*
METHODS
 */
    public PointF convertToView(PointF position){
        return null;
    }
/*
CONSTANTS/FINALS
 */
/*
GETTERS/SETTERS
 */
    /**
     * The getter for the current viewport dimensions
     * @return  the viewport dimensions
     */
    public RectF getDimensions() {
        return dimensions;
    }
    /**
     * The getter for the current level dimensions
     * @return  the level dimensions
     */
    public RectF getLevel_dimensions() {
        return level_dimensions;
    }
}
