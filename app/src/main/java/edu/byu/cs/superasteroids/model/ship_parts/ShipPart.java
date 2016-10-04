package edu.byu.cs.superasteroids.model.ship_parts;

import android.graphics.PointF;

import edu.byu.cs.superasteroids.model.Image;

/**
 * This class describes the common properties in any of the ship parts.
 * @author Scott Leland Crossen
 */
public abstract class ShipPart {
    private Image image;
    private MountPoint mount_point;
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
    public void draw(PointF ship_location/*, MainBody main_body*/, float rotation, float scale) {}

}
