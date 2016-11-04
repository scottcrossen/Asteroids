package edu.byu.cs.superasteroids.model;

import junit.framework.TestCase;

import edu.byu.cs.superasteroids.model.asteroids.RegularAsteroid;

/**
 * @author Scott leland Crossen
 */
public class MovingObjectTest extends TestCase {
    RegularAsteroid asteroid=new RegularAsteroid(null); // This is just a type of moving object
    /**
     * Tests the given method
     * @throws Exception if the assertEquals statements don't hold
     */
    public void testNeedsDeletion() throws Exception {
        asteroid.touch(); // should return true when touched.
        assertEquals(asteroid.needsDeletion(),true);
    }
    /**
     * Tests the given method
     * @throws Exception if the assertEquals statements don't hold
     */
    public void testSetMapCoords() throws Exception{
        asteroid.setMapCoords(null,null); // Should set correctly.
        assertEquals(asteroid.getPosition(), null);
        assertEquals(asteroid.getBound(),null);
    }
    /**
     * Tests the given method
     * @throws Exception if the assertEquals statements don't hold
     */
    public void testSetDirection() throws Exception{
        asteroid.setDirection(360 + 180); // Should set correctly to 180.
        assertEquals(asteroid.getDirection(), (float)180);
        asteroid.setDirection(-90); // Should set correctly to 270.
        assertEquals(asteroid.getDirection(), (float)270);
    }
}
