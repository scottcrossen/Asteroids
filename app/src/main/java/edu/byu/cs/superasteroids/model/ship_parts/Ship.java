package edu.byu.cs.superasteroids.model.ship_parts;

import android.graphics.PointF;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import edu.byu.cs.superasteroids.base.Debug;
import edu.byu.cs.superasteroids.content.ContentManager;
import edu.byu.cs.superasteroids.core.GraphicsUtils;
import edu.byu.cs.superasteroids.game.InputManager;
import edu.byu.cs.superasteroids.model.Image;
import edu.byu.cs.superasteroids.model.MovingObject;

/**
 * The overall Ship-build class.
 * @author Scott Leland Crossen
 */
public class Ship extends MovingObject {
/*
FIELDS
 */
    /**
     * The main body of the ship.
     */
    private MainBody main_body;
    /**
     * This cannon gets attached in the constructor.
     */
    private Cannon cannon;
    /**
     * This extra part gets attached in the constructor.
     */
    private ExtraPart extrapart;
    /**
     * This engine gets attached in the constructor.
     */
    private Engine engine;
    /**
     * This powercore gets attached in the constructor.
     */
    private PowerCore powercore;
    /**
     * The ship's current list of bullets outstanding.
     */
    private static List<Projectile> bullets = new LinkedList<>();
    /**
     * The only instance of the ship.
     */
    private static Ship ourInstance = new Ship();
    /**
     * How long it takes to recharge it's bullets.
     */
    private static final double FIRE_RATE = .5; //the rate of fire between bullets (bullets per second)
    /**
     * The time it takes untill the ship can fire again.
     */
    private double time_until_fire = 0;
    private Debug debug=new Debug(6);
/*
CONSTRUCTORS
 */
    /**
     * The constructor for the ship object.
     */
    private Ship() {
            super(new Image(null, 650, 650), new PointF(0, 0), 0, 0);
    }
/*
METHODS
 */
    /**
     * Creates a new ship.
     */
    public static Ship createNew() {
        ourInstance = new Ship();
        return getInstance();
    }
    /**
     * Updates the ship on the screen for a given elapsed time.
     * @param elapsedTime   the time elapsed.
     */
    @Override
    public void update(double elapsedTime){
        // Don't fire constantly when the user presses finger. Make a time limit.
        time_until_fire -= elapsedTime;
        // Check if the user is pressing down.
        if (InputManager.movePoint != null) { // User is touching screen
            // Set the direction to where the user touched.
            setDirection((float) (GraphicsUtils.radiansToDegrees(Math.atan2((InputManager.movePoint.y- getViewPortCoords().y),(InputManager.movePoint.x- getViewPortCoords().x)))));
            // For this case, rotation and direction should be the same
            setRotation(direction);
            // Move the ship towards direction
            speed = engine.getBaseSpeed();
            // Fire some bullets if allowed
            if (time_until_fire <= 0) {
                // Find emitter point
                PointF nozzle = new PointF(getScale()*(main_body.getCannonAttach().x - cannon.getMountPoint().x + cannon.getNozzle().x),
                        getScale()*(main_body.getCannonAttach().y - cannon.getMountPoint().y + cannon.getNozzle().y));
                // Rotate the emit point
                PointF rotated = GraphicsUtils.rotate(nozzle, GraphicsUtils.degreesToRadians(getRotation()));
                // Create a new rotated bullet
                Projectile bullet = new Projectile(cannon.getAttackImage(),
                        new PointF(rotated.x + getPosition().x, rotated.y + getPosition().y), getRotation()-90, getScale());
                // Play the sound
                if (cannon.getAttackSoundID() != -1)
                    ContentManager.getInstance().playSound(cannon.getAttackSoundID(), (float) .5, (float) 1);
                // Tell the bullet where it is on the screen
                bullet.setViewPort(view_port);
                // Keep track of the bullets so we can delete them.
                bullets.add(bullet);
                // Reset the bullet timer.
                time_until_fire = FIRE_RATE;
            }
        }
        else // The user isn't touching, so don't move the ship.
            speed = 0;
        super.update(elapsedTime);
        // Iterate over all the bullets and update.
        Iterator<Projectile> bullet_index = bullets.iterator();
        while (bullet_index.hasNext()) {
            Projectile current_bullet = bullet_index.next();
            current_bullet.update(elapsedTime); // Update all the bullets
            if (current_bullet.needsDeletion())
                bullet_index.remove();
        }
    }
    /**
     * Default draw funciton
     */
    @Override
    public void draw() { // This draw function is used when no position is given.
        draw(getViewPortCoords());
        Iterator<Projectile> bullet_index = bullets.iterator();
        while (bullet_index.hasNext()) {
            bullet_index.next().draw();
        }
    }
    /**
     * Draw function given position
     */
    private void draw(PointF position){ // This draw function is used when a position is given.
        draw(position,getScale());
    }
    /**
     * Draw function give position and scale
     */
    public void draw(PointF position, float scale){ // Initial draw.
        if (main_body != null) {
            main_body.draw(position, main_body, getRotation(), scale);
            if (extrapart != null)
                extrapart.draw(position, main_body, getRotation(), scale);
            if (cannon != null)
                cannon.draw(position, main_body, getRotation(), scale);
            if (engine != null)
                engine.draw(position, main_body, getRotation(), scale);
        }
    }
    /**
     * Tells the ShipBuilder activity if the ship is complete
     * @return  whether the ship is complete.
     */
    public boolean isComplete() { // For ShipBuilder activity check on if game can start.
        if (main_body != null &&
                extrapart != null &&
                cannon != null &&
                powercore != null &&
                engine != null)
            return true;
        else
            return false;
    }
/*
CONSTANTS/FINALS
 */
/*
GETTERS/SETTERS
 */
    public List<Projectile> getProjectiles() {return bullets;}
    /**
     * The getter for the main-body
     * @return  the main-body
     */
    public MainBody getMainBody() {return main_body;}
    /**
     * The setter of the main-body
     * @param main_body the main-body
     */
    public void setMainBody(MainBody main_body) {this.main_body = main_body;}
    /**
     * The getter of the cannon
     * @return  the cannon
     */
    public Cannon getCannon() {return cannon;}
    /**
     * The setter of the cannon
     * @param cannon    the cannon
     */
    public void setCannon(Cannon cannon) {this.cannon = cannon;}
    /**
     * The getter of the extra part
     * @return  the extra-part
     */
    public ExtraPart getExtraPart() {return extrapart;}
    /**
     * The settter of the extra-part
     * @param extrapart the extra-part
     */
    public void setExtraPart(ExtraPart extrapart) {this.extrapart = extrapart;}
    /**
     * The getter of the engine
     * @return  the engine
     */
    public Engine getEngine() {return engine;}
    /**
     * The setter of the engine
     * @param engine    the engine
     */
    public void setEngine(Engine engine) {this.engine = engine;}
    /**
     * The getter of the power-core
     * @return  the power-core
     */
    public PowerCore getPowerCore() {return powercore;}
    /**
     * The setter of the power-core
     * @param powercore the power-core.
     */
    public void setPowerCore(PowerCore powercore) {this.powercore = powercore;}
    /**
     * The getter for the bullet-list
     * @return  the bullet-list
     */
    public static List<Projectile> getBullets() {return bullets;}
    /**
     * The getter of the only-allowed instance of the ship.
     * @return  the current ship
     */
    public static Ship getInstance() {return ourInstance;}
    /**
     * The getter for the fire-rate
     * @return  the fire-rate.
     */
    public static double getFireRate() {return FIRE_RATE;}
}
