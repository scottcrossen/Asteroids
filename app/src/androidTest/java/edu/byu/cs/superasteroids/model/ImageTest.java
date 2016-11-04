package edu.byu.cs.superasteroids.model;

import junit.framework.TestCase;

/**
 * @author Scott Leland Crossen
 */
public class ImageTest extends TestCase {
    Image image = new Image("path", 1, 2);
    /**
     * Tests the given method
     * @throws Exception if the assertEquals statements don't hold
     */
    public void testGetContentID() throws Exception {
        image.setContentID(3);
        assertEquals(3, image.getContentID());
    }
    /**
     * Tests the given method
     * @throws Exception if the assertEquals statements don't hold
     */
    public void testGetPath() throws Exception {
        assertEquals("path", image.getPath());
    }
    /**
     * Tests the given method
     * @throws Exception if the assertEquals statements don't hold
     */
    public void testGetWidth() throws Exception {
        assertEquals(1, image.getWidth());
    }
    /**
     * Tests the given method
     * @throws Exception if the assertEquals statements don't hold
     */
    public void testGetHeight() throws Exception {
        assertEquals(2, image.getHeight());
    }
}