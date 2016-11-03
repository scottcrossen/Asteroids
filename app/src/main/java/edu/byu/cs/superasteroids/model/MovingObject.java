package edu.byu.cs.superasteroids.model;

import android.graphics.PointF;
import android.graphics.RectF;

import edu.byu.cs.superasteroids.base.Debug;
import edu.byu.cs.superasteroids.core.GraphicsUtils;

/**
 * Any obect that moves on screen is a moving object.
 * @author Scott Leland Crossen
 */
public abstract class MovingObject extends PositionedObject {
/*
FIELDS
 */
    protected enum ROTATION_DRIFT {CLOCKW, COUNTERCLOCKW, NONE};
    /**
     * The drift-speed of the object's rotation.
     */
    private static float ROTATION_DRIFT_SPEED=(float).0001;
    /**
     * The speed of the object
     */
    protected int speed;
    /**
     * The direction the object is moving
     */
    protected float direction;
    private boolean is_hit=false;
    protected RectF bound;
    private ROTATION_DRIFT rot_drift = ROTATION_DRIFT.NONE;
    Debug debug=new Debug(7);
/*
CONSTRUCTORS
 */
    /**
     * The constructor of the positioned object
     * @param image     how the object looks
     * @param position  where the object is located.
     * @param _speed     the speed of the object
     * @param _rotation   the direction of the speed of the object
     */
    public MovingObject(Image image, PointF position, int _speed, float _rotation){
        super(image, position);
        speed=_speed;
        direction = _rotation;
        resetBounds();
    }
/*
METHODS
 */
    /**
     * Redraw the object according to how much time has past.
     */
    public void update(double elapsedTime){
        GraphicsUtils.MoveObjectResult new_pos = GraphicsUtils.moveObject(getMapCoords(), getBound(), speed, GraphicsUtils.degreesToRadians(direction), elapsedTime);
        if (rot_drift == ROTATION_DRIFT.CLOCKW) // Add on rotation drift amount since last time.
            setRotation((float)(getRotation() + ROTATION_DRIFT_SPEED * elapsedTime));
        else if (rot_drift == ROTATION_DRIFT.COUNTERCLOCKW)
            setRotation((float)(getRotation() - ROTATION_DRIFT_SPEED * elapsedTime));
        setMapCoords(new_pos.getNewObjPosition(), new_pos.getNewObjBounds());
    }
    public boolean needsDeletion() {
        return is_hit;
    }
    public void touch() {
        is_hit = true;
    }
    @Override
    public void setMapCoords(PointF point) {
        float width = bound.width();
        float height = bound.height();
        setMapCoords(point, new RectF(point.x - width / 2, point.y - height / 2, point.x + width / 2, point.y + height / 2));
    }
    public void resetBounds() {
        float max_dim;
        if (image.getHeight() > image.getWidth()) // Get the max between the two.
            max_dim = image.getHeight();
        else
            max_dim = image.getWidth();
        max_dim = max_dim*getScale();
        bound = new RectF(getMapCoords().x - max_dim / 2, getMapCoords().y - max_dim / 2, getMapCoords().x + max_dim / 2, getMapCoords().y + max_dim / 2);
    }

    /**
     * Sets the current position.
     * @param point     desired position
     * @param _bound    the bounding rectangle.
     */
    public void setMapCoords(PointF point, RectF _bound) {
        super.setMapCoords(point);
        bound = _bound;
    }
    @Override
    public void setScale(float _scale) {
        super.setScale(_scale);
        resetBounds();
    }
    public void enableRotationDrift() {
        if (Math.random() < .5) // 50% chance of cw or ccw rotation
            rot_drift = ROTATION_DRIFT.CLOCKW;
        else
            rot_drift = ROTATION_DRIFT.COUNTERCLOCKW;
    }
    public void setDirection(float _direction) {
        direction=(_direction%360); // Only allow directions in the range. Scale appropriately.
        if(direction<0) direction+=360; // In case the value is negative.
    }
/*
CONSTANTS/FINALS
 */
/*
GETTERS/SETTERS
 */
    /**
     * The getter for the rotation drift speed
     * @return  the rotation drift speed
     */
    public float getRotationDriftSpeed() {return ROTATION_DRIFT_SPEED;}
    /**
     * The getter for the translational speed
     * @return  the translational speed
     */
    public int getSpeed() {return speed;}
    /**
     * The setter for the speed
     */
    public void setSpeed(int _speed){speed=_speed;}
    public RectF getBound() {return bound;}
}
