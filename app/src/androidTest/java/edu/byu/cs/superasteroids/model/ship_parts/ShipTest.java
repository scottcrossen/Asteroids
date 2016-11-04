package edu.byu.cs.superasteroids.model.ship_parts;

import junit.framework.TestCase;

/**
 * @author Scott Leland Crossen
 */
public class ShipTest extends TestCase {
    private Ship ship = Ship.getInstance();
    /**
     * Tests the given method
     * @throws Exception if the assertEquals statements don't hold
     */
    public void testIsComplete() throws Exception {
        if(ship.getMainBody() == null)
            assertEquals(false, ship.isComplete());
        if(ship.getCannon() == null)
            assertEquals(false, ship.isComplete());
        if(ship.getExtraPart() == null)
            assertEquals(false, ship.isComplete());
        if(ship.getEngine() == null)
            assertEquals(false, ship.isComplete());
        if(ship.getPowerCore() == null)
            assertEquals(false, ship.isComplete());
    }
    /**
     * Tests the given method
     * @throws Exception if the assertEquals statements don't hold
     */
    public void GetInstance() throws Exception {
            assertEquals(this.ship, ship.getInstance());
    }

}
