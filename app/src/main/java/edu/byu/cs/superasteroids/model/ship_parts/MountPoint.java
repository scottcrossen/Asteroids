package edu.byu.cs.superasteroids.model.ship_parts;

import edu.byu.cs.superasteroids.model.Image;

/**
 * This class describes where ship-parts are mounted.
 * @author Scott Leland Crossen
 */
public class MountPoint {
/*
FIELDS
 */
    /**
     * the mount point consists of an x coordinate on the ship body
     */
    public int x;
    /**
     * the mount point also consists of a y coordinate on the ship body
     */
    public int y;
/*
CONSTRUCTORS
 */
    /**
     * the constructor for the mount-point class
     * @param _x    the relative location of the ship part on the main body
     * @param _y    the relative location of the ship part on the main body
     */
    public MountPoint(int _x, int _y, Image image) {
        x = _x - image.getWidth()/2;
        y = _y - image.getHeight()/2;
    }
    /**
     * the constructor for the mount-point class
     * @param _x    the relative location of the ship part on the main body
     * @param _y    the relative location of the ship part on the main body
     */
    private MountPoint(int _x, int _y) {
        x = _x;
        y = _y;
    }
/*
METHODS
 */
    /**
     * Compares to objects to see if they are equal.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        else if (this == o)
            return true;
        else if (getClass() != o.getClass())
            return false;
        else {
            MountPoint other = (MountPoint)o;
            return (!(x != other.x||y != other.y));
        }
    }
/*
CONSTANTS/FINALS
 */
/*
GETTERS/SETTERS
 */
    /**
     * The getter for the x-attachment point
     * @return  the attachment x coordinate
     */
    public int getX() {return x;}
    /**
     * The getter for the y-attachment point
     * @return  the attachment y coordinate
     */
    public int getY() {return y;}
}
