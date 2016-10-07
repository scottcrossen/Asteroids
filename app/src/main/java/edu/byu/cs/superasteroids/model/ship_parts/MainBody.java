package edu.byu.cs.superasteroids.model.ship_parts;

import edu.byu.cs.superasteroids.model.Image;

/**
 * One of the parts of a ship
 * @author Scott Leland Crossen
 */
public class MainBody extends ShipPart {
/*
FIELDS
 */
    /**
     * the location to attach the cannon onto is determined from the database and passed into the constructor.
     */
    private MountPoint cannon_attach;
    /**
     * the location to attach the engine onto is determined from the database and passed into the constructor.
     */
    private MountPoint engine_attach;
    /**
     * the location to attach the extra part onto is determined from the database and passed into the constructor.
     */
    private MountPoint extra_attach;
/*
CONSTRUCTORS
 */
    /**
     * The Constructor for the main body.
     * @param image             the image of the main body
     * @param _cannon_attach    the attachment point of the cannon
     * @param _engine_attach    the attachment point of the engine
     * @param _extra_attach     the attachment point of the extra-part.
     */
    public MainBody(Image image, MountPoint _cannon_attach, MountPoint _engine_attach, MountPoint _extra_attach)
    {
        //the mount point is irrelevant here, so set it to the center of the body.
        super(image, new MountPoint(0,0,new Image()));
        cannon_attach = _cannon_attach;
        engine_attach = _engine_attach;
        extra_attach = _extra_attach;
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
    /**
     * The getter of the cannon attachment point.
     * @return the cannon attachment point.
     */
    public MountPoint getCannonAttach() {
        return cannon_attach;
    }
    /**
     * The getter of the engine attachment point.
     * @return the engine attachment point.
     */
    public MountPoint getEngineAttach() {
        return engine_attach;
    }
    /**
     * The getter of the extra-part attachment point.
     * @return the extra-part attachment point.
     */
    public MountPoint getExtraAttach() {
        return extra_attach;
    }
}
