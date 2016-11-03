package edu.byu.cs.superasteroids.game;

import android.graphics.PointF;
import android.graphics.RectF;

import edu.byu.cs.superasteroids.drawing.DrawingHelper;
import edu.byu.cs.superasteroids.model.ship_parts.Ship;

/**
 * The object that shows the visible section of the screen.
 * @author Scott Leland Crossen
 */
public class ViewPort {
/*
FIELDS
 */
    /**
     * The dimensions of the viewport
     */
    private RectF dimensions;
    /**
     * The dimension of the level.
     */
    private RectF level_dimensions;
    private Ship ship;
/*
CONSTRUCTORS
 */
    /**
     * The Viewport constructor
     * @param _ship         the current ship
     * @param _level_dimensions the current level dimensions
     */
    public ViewPort(Ship _ship, RectF _level_dimensions){
        ship=_ship;
        level_dimensions=_level_dimensions;
        update();
    }
/*
METHODS
 */
    /**
     * The update function moves the viewport accordingly.
     */
    public void update(){
        dimensions = new RectF(ship.getPosition().x - DrawingHelper.getGameViewWidth()/2, ship.getPosition().y - DrawingHelper.getGameViewHeight()/2,
                ship.getPosition().x + DrawingHelper.getGameViewWidth()/2, ship.getPosition().y + DrawingHelper.getGameViewHeight()/2);
        if (dimensions.bottom > level_dimensions.bottom) { // Boundary conditions
            dimensions.bottom = level_dimensions.bottom;
            dimensions.top = level_dimensions.bottom - dimensions.height();
        }
        if (dimensions.right > level_dimensions.right) { // Boundary conditions
            dimensions.right = level_dimensions.right;
            dimensions.left = dimensions.right - dimensions.width();
        }
        if (dimensions.top < level_dimensions.top) { // Boundary conditions
            dimensions.top = level_dimensions.top;
            dimensions.bottom = dimensions.top + dimensions.height();
        }
        if (dimensions.left < level_dimensions.left) { // Boundary conditions
            dimensions.left = level_dimensions.left;
            dimensions.right = dimensions.left + dimensions.width();
        }
    }
    /**
     * Converts points from the map to the viewport for viewing.
     * @param position  the actual location
     * @return  the viewport location
     */
    public PointF convertToViewPort(PointF position){
        return new PointF(position.x - dimensions.left, position.y - dimensions.top);
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
