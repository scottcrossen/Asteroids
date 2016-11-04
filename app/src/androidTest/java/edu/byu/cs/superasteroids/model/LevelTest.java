package edu.byu.cs.superasteroids.model;

import android.graphics.PointF;
import android.graphics.RectF;

import junit.framework.TestCase;

import java.util.LinkedList;
import java.util.List;

import edu.byu.cs.superasteroids.model.asteroids.Asteroid;
import edu.byu.cs.superasteroids.model.asteroids.GrowingAsteroid;

/**
 * @author Scott Leland Crossen
 */
public class LevelTest extends TestCase {
    List<BackgroundObject> background_objects = new LinkedList<>();
    List<Asteroid> asteroids = new LinkedList<>();
    Level level = new Level(1, "my title", "my hint", 2, 3, "music path", background_objects, asteroids);
    /**
     * Setups this class to be tested.
     */
    @Override
    public void setUp() {
        background_objects.add(new BackgroundObject(new Image("background object path", 1, 1), new PointF(0, 0), 1, (float).5));
        asteroids.add(new GrowingAsteroid(new Image("asteroid path", 1, 1)));
    }
    /**
     * Tests the given method
     * @throws Exception if the assertEquals statements don't hold
     */
    public void testGetLevelNumber() throws Exception {
        assertEquals(1, level.getLevelNumber());
    }
    /**
     * Tests the given method
     * @throws Exception if the assertEquals statements don't hold
     */
    public void testGetTitle() throws Exception {
        assertEquals("my title", level.getTitle());
    }
    /**
     * Tests the given method
     * @throws Exception if the assertEquals statements don't hold
     */
    public void testGetHint() throws Exception {
        assertEquals("my hint", level.getHint());
    }
    /**
     * Tests the given method
     * @throws Exception if the assertEquals statements don't hold
     */
    public void testGetBound() throws Exception {
        assertEquals(new RectF(0, 0, 2, 3), level.getBound());
    }
    /**
     * Tests the given method
     * @throws Exception if the assertEquals statements don't hold
     */
    public void testGetWidth() throws Exception {
        assertEquals(2, level.getWidth());
    }
    /**
     * Tests the given method
     * @throws Exception if the assertEquals statements don't hold
     */
    public void testGetHeight() throws Exception {
        assertEquals(3, level.getHeight());
    }
    /**
     * Tests the given method
     * @throws Exception if the assertEquals statements don't hold
     */
    public void testGetCenter() throws Exception {
        assertEquals(new PointF(1, 3/2), level.getCenter());
    }
    /**
     * Tests the given method
     * @throws Exception if the assertEquals statements don't hold
     */
    public void testGetMusic() throws Exception {
        assertEquals("music path", level.getMusic());
    }
    /**
     * Tests the given method
     * @throws Exception if the assertEquals statements don't hold
     */
    public void testIsFinished() throws Exception {
        assertEquals(false, level.isFinished());
    }
    /**
     * Tests the given method
     * @throws Exception if the assertEquals statements don't hold
     */
    public void testGetLevelAsteroids() throws Exception {
        List<Asteroid> more_asteroids = level.getLevelAsteroids();
        assertEquals(asteroids, more_asteroids);
        assertNotSame(new PointF(-1, -1), more_asteroids.iterator().next().getPosition()); // Tests the asteroid initialization function for new levels.
    }
}