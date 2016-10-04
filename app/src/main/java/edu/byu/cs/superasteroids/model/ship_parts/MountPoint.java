package edu.byu.cs.superasteroids.model.ship_parts;

import edu.byu.cs.superasteroids.model.Image;

/**
 * This class describes where ship-parts are mounted.
 * @author Scott Leland Crossen
 */
public class MountPoint {

    /**
     * the mount point consists of an x coordinate on the ship body
     */
    public int x;

    /**
     * the mount point also consists of a y coordinate on the ship body
     */
    public int y;
    /**
     * the constructor for the mount-point class
     * @param _x    the relative location of the ship part on the main body
     * @param _y    the relative location of the ship part on the main body
     */
    public MountPoint(int _x, int _y, Image image)
    {
        x = _x /*- image.getWidth()/2*/;
        y = _y /*- image.getHeight()/2*/;
    }

    private MountPoint(int _x, int _y)
    {
        x = _x;
        y = _y;
    }
}
