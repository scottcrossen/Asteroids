package edu.byu.cs.superasteroids.model.ship_parts;

import android.graphics.PointF;

import edu.byu.cs.superasteroids.core.GraphicsUtils;
import edu.byu.cs.superasteroids.drawing.DrawingHelper;
import edu.byu.cs.superasteroids.model.Image;

/**
 * This class describes the common properties in any of the ship parts.
 * @author Scott Leland Crossen
 */
public abstract class ShipPart {
/*
FIELDS
 */
    /**
     * The image of the ship part.
     */
    private Image image;
    /**
     * The mount-point of the ship part.
     */
    protected MountPoint mount_point;
/*
CONSTRUCTORS
 */
    /**
     * the constructor for a ship part
     * @param _image        what the ship part looks like
     * @param _mount_point  where the ship part mounts to the main body
     */
    public ShipPart(Image _image, MountPoint _mount_point)
    {
        image = _image;
        mount_point = _mount_point;
    }
/*
METHODS
 */
    /**
     * The draw function for the ship. This draws the image compiled.
     * @param ship_location the location of the ship on the screen.
     * @param rotation      the current rotation of the ship.
     * @param scale         the scale of the image
     */
    public void draw(PointF ship_location/*, MainBody main_body*/, float rotation, float scale) {}
    //This method is mainly used for polymorphism and connecting parts to ship
    abstract public MountPoint getBodyAttachPoint(MainBody main_body);
    public void draw(PointF ship_location, MainBody main_body, float rotation, float scale) {
        PointF pic_center = new PointF(
                scale*(getBodyAttachPoint(main_body).x - getMountPoint().x),
                scale*(getBodyAttachPoint(main_body).y - getMountPoint().y));
        PointF rotated = GraphicsUtils.rotate(pic_center, rotation);
        DrawingHelper.drawImage(
                image.getContentID(),
                rotated.x + ship_location.x,
                rotated.y + ship_location.y,
                rotation,
                scale,
                scale,
                255);
    }
/*
CONSTANTS/FINALS
 */
/*
GETTERS/SETTERS
 */
    /**
     * The getter of the part image
     * @return  the image
     */
    public Image getImage() {
        return image;
    }
    /**
     * The getter of the mount-point
     * @return  the mount-point
     */
    public MountPoint getMountPoint() {
        return mount_point;
    }
}
