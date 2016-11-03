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
    /**
     * The getter for the mount point where this part attaches.
     * @param main_body the main body it attaches to
     * @return the created mount point
     */
    @Override
    public MountPoint getBodyAttachPoint(MainBody main_body) {return main_body.getExtraAttach();}
/*
CONSTANTS/FINALS
 */
/*
GETTERS/SETTERS
 */
}
