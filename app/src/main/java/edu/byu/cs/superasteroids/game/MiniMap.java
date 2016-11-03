package edu.byu.cs.superasteroids.game;

import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;

import java.util.Iterator;

import edu.byu.cs.superasteroids.drawing.DrawingHelper;
import edu.byu.cs.superasteroids.model.Level;
import edu.byu.cs.superasteroids.model.asteroids.Asteroid;
import edu.byu.cs.superasteroids.model.ship_parts.Ship;

/**
 * The minimap is a box in the top-left of the screen. It doesn't move, but needs to be updated to show where all the asteroids are.
 * @author Scott Leland Crossen
 */
public class MiniMap {
/*
FIELDS
 */
    private Level current_level;
    private Ship ship;
    private Rect box;
/*
CONSTRUCTORS
 */
    /**
     * The Constructor for the class
     * @param level     the level object currently on with all objects
     * @param _ship     the ship being used.
     */
    public MiniMap(Level level, Ship _ship) {
        current_level = level;
        ship = _ship;
        refresh();
    }
/*
METHODS
 */
    /**
     * Refreshes the minimap. There's often a bug that needs to be refreshed.
     */
    public void refresh() { // Make this versatile depending on the screen its seen in.
        box = new Rect((int)(DrawingHelper.getGameViewWidth()-current_level.getWidth()*SCALE), 0,
                DrawingHelper.getGameViewWidth(), (int)(current_level.getHeight()*SCALE));
    }
    /*
     * The draw method needs to be overridden so that more than just the image of the minimap is displayed
     */
    public void draw() {
        // This bit overcomes the small inconvenience of the map not being initialized right when the canvas isn't initialized.
        if (box.right == 0)
            refresh();
        DrawingHelper.drawFilledRectangle(box, Color.DKGRAY, 255);
        Iterator<Asteroid> asteroid_index = current_level.getLevelAsteroids().iterator();
        while (asteroid_index.hasNext())
            DrawingHelper.drawPoint(convertToMiniMap(asteroid_index.next().getPosition()), DOT_WIDTH, Color.RED, 255);
        DrawingHelper.drawPoint(convertToMiniMap(ship.getPosition()), DOT_WIDTH, Color.GREEN, 255);
    }
    /**
     * Converts points from the map to the minimap
     * @param map   the map point
     * @return      the minimap point
     */
    public PointF convertToMiniMap(PointF map) {
        return new PointF((map.x*SCALE + box.left), (map.y*SCALE + box.top));
    }
/*
CONSTANTS/FINALS
 */
    private static final float SCALE = (float).1; // Displays as function of total width of screen.
    private static final float DOT_WIDTH = 10;
/*
GETTERS/SETTERS
 */
}
