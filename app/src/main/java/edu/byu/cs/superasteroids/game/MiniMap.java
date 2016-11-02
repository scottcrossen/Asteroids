package edu.byu.cs.superasteroids.game;

/**
 * Created by Scott Leland Crossen
 */

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
    public MiniMap(Level level, Ship _ship)
    {
        current_level = level;
        ship = _ship;
        refreash();
    }
/*
METHODS
 */
    public void refreash() {
        box = new Rect(
                (int)(DrawingHelper.getGameViewWidth()-current_level.getWidth()*SCALE), 0,
                DrawingHelper.getGameViewWidth(),
                (int)(current_level.getHeight()*SCALE));
    }
    /**
     * the draw method needs to be overridden so that more than just the image of the minimap is displayed
     */
    public void draw() {
        //this bit overcomes the small inconvenience of the map not being initialized right when the canvas isn't initialized.
        if (box.right == 0) {
            refreash();
        }
        DrawingHelper.drawFilledRectangle(box, Color.DKGRAY, 255);
        Iterator<Asteroid> asteroid_index = current_level.getLevelAsteroids().iterator();
        while (asteroid_index.hasNext()) {
            DrawingHelper.drawPoint(convertToMini(asteroid_index.next().getMapCoords()), DOT_WIDTH, Color.RED, 255);
        }
        DrawingHelper.drawPoint(convertToMini(ship.getMapCoords()), DOT_WIDTH, Color.GREEN, 255);
    }
    public PointF convertToMini(PointF map) {
        return new PointF((map.x*SCALE + box.left), (map.y*SCALE + box.top));
    }
/*
CONSTANTS/FINALS
 */
    private static final float SCALE = (float).1;
    private static final float DOT_WIDTH = 10;
/*
GETTERS/SETTERS
 */
}
