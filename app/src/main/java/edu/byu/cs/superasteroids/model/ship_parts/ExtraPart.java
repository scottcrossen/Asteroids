package edu.byu.cs.superasteroids.model.ship_parts;

import edu.byu.cs.superasteroids.model.Image;

/**
 * One of the parts of a ship
 * @author Scott Leland Crossen
 */
public class ExtraPart extends ShipPart {
/*
FIELDS
 */
/*
CONSTRUCTORS
 */
    /**
     * The constructor needs the following information
     * @param image         what the extra part looks like
     * @param mount_point   where the extra part connects to the ship
     */
    public ExtraPart(Image image, MountPoint mount_point) {
        super(image, mount_point);
    }
/*
METHODS
 */
/*
CONSTANTS/FINALS
 */
/*
GETTERS/SETTERS
 */
}
