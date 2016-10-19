package edu.byu.cs.superasteroids.database;

import android.database.sqlite.SQLiteDatabase;

import org.json.JSONObject;

import java.util.List;

import edu.byu.cs.superasteroids.model.BackgroundObject;
import edu.byu.cs.superasteroids.model.Level;
import edu.byu.cs.superasteroids.model.asteroids.Asteroid;
import edu.byu.cs.superasteroids.model.ship_parts.Cannon;
import edu.byu.cs.superasteroids.model.ship_parts.Engine;
import edu.byu.cs.superasteroids.model.ship_parts.ExtraPart;
import edu.byu.cs.superasteroids.model.ship_parts.MainBody;
import edu.byu.cs.superasteroids.model.ship_parts.PowerCore;

/**
 * The accessor to the database.
 * @author Scott Leland Crossen
 */
public class DAO {
/*
FIELDS
 */
    /**
     * The database used.
     */
    private SQLiteDatabase db;
/*
CONSTRUCTORS
 */
    /**
     * the constructor of the Database Access Class
     * @param _db   the only information needed is the location of the database to use.
     */
    public DAO(SQLiteDatabase _db)
    {
        db = _db;
    }
/*
METHODS
 */
    /**
     * This method adds from a JSONObject. Its primary function is recursive. It will call other 'add' functions as necessary.
     * @param root_node     the JSONObject to read in.
     */
    public void addBGobjects(JSONObject root_node) throws org.json.JSONException {
    }
    /**
     * This method adds asteroids to the database
     * @param root_node    The JSONObject containing the list of asteroids.
     * @throws org.json.JSONException   Required from JSON manipulation requirement.
     */
    public void addAsteroids(JSONObject root_node) throws org.json.JSONException {
    }
    /**
     * This method gets the list of cannons contained in the database.
     * @return      the list of cannons.
     */
    public List<Cannon> getCannons() {
        return null;
    }
    /**
     * This method adds cannons to the database
     * @param root_node     The JSONObject containing the list of cannons.
     * @throws org.json.JSONException   Required from JSON manipulation requirement.
     */
    public void addCannons(JSONObject root_node) throws org.json.JSONException {
    }
    /**
     * This method gets the list of engines contained in the database.
     * @return      the list of engines.
     */
    public List<Engine> getEngines() {
        return null;
    }
    /**
     * This method adds engines to the database
     * @param root_node     The JSONObject containing the list of engines.
     * @throws org.json.JSONException   Required from JSON manipulation requirement.
     */
    private void addEngines(JSONObject root_node) throws org.json.JSONException {
    }
    /**
     * This method gets the list of extra-parts contained in the database.
     * @return      the list of extra-parts.
     */
    public List<ExtraPart> getExtraParts() {
        return null;
    }
    /**
     * This method adds extra-parts to the database
     * @param root_node     The JSONObject containing the list of extra-parts
     * @throws org.json.JSONException   Required from JSON manipulation requirement.
     */
    public void addExtraParts(JSONObject root_node) throws org.json.JSONException {
    }
    /**
     * This method gets the list of level objects contained in the database.
     * @param level_number      the queried level index
     * @return      the list of level-objects
     */
    public List<BackgroundObject> getLevelObjects(int level_number) {
        return null;
    }
    /**
     * This method gets the list of asteroids contained in the database for a certain level.
     * @param level_number      the queried level index
     * @return      the list of asteroids for a given level-index
     */
    public List<Asteroid> getLevelAsteroids(int level_number) {
        return null;
    }
    /**
     * this method gets a level from the database based on its ID.
     * @param level_number  the level index
     * @return              the desired level data
     */
    public Level getLevel(int level_number) {
        return null;
    }
    /**
     * This method adds levels to the database
     * @param root_node     The JSONObject containing the list of levels
     * @throws org.json.JSONException
     */
    public void addLevels(JSONObject root_node) throws org.json.JSONException {
    }
    /**
     * This method gets the list of main-bodies contained in the database.
     * @return      the list of main-bodies.
     */
    public List<MainBody> getMainBodies() {
        return null;
    }
    /**
     * This method adds main-bodies to the database
     * @param root_node     The JSONObject containing the list of main-bodies.
     * @throws org.json.JSONException   Required from JSON manipulation requirement.
     */
    public void addMainBodies(JSONObject root_node) throws org.json.JSONException {
    }
    /**
     * This method gets the list of power-cores contained in the database.
     * @return      the list of power-cores
     */
    public List<PowerCore> getPowerCores() {
        return null;
    }
    /**
     * This method adds power-cores to the database
     * @param root_node     The JSONObject containing the list of power-cores
     * @throws org.json.JSONException   Required from JSON manipulation requirement.
     */
    public void addPowerCores(JSONObject root_node) throws org.json.JSONException {
    }
    /**
     * This method is the root call for importing a JSONObject.
     * @param root_object   The JSONObject to be imported.
     * @throws org.json.JSONException   Required from JSON manipulation requirement.
     */
    public void importJSON(JSONObject root_object) throws org.json.JSONException {
    }
    /**
     * This method clears all the information in the table (but doesn't delete the tables).
     */
    public void clearAll() {
        DbOpenHelper.dropAndCreate(db);
    }
/*
CONSTANTS/FINALS
 */
/*
GETTERS/SETTERS
 */
    /**
     * The getter for the SQLiteDatabase used
     * @return  the SQLiteDatabase used
     */
    public SQLiteDatabase getDb() {
        return db;
    }
}
