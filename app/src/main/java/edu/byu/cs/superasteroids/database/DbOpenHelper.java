package edu.byu.cs.superasteroids.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * The initializer for the database.
 * @author Scott leland Crossen
 */
public class DbOpenHelper extends SQLiteOpenHelper {
/*
FIELDS
 */
    /**
     * The name of the database file.
     */
    private static final String DB_NAME = "asteroidsdata.sqlite";

/*
CONSTRUCTORS
 */
    /**
     * the constructor for the open helper.
     * @param context   only the context needs to be passed in.
     */
    public DbOpenHelper(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }
/*
METHODS
 */
    /**
     * This method is called when the database is created.
     * @param db    the sqlitedatabase that is being created.
     */
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        createTables(db);
    }
    /**
     * This method is called when the database is updated
     * @param db    the sqlitedatabase that is being created.
     * @param oldVersion    the old version of sql
     * @param newVersion    the new version of sql
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    /**
     * This method is called to "reset" the database.
     * @param db    the sqlitedatabase that is being created.
     */
    public static void dropAndCreate(SQLiteDatabase db)
    {
        dropTables(db);
        createTables(db);
    }
    /**
     * This method drops tables: ALL
     * @param db    the sqlitedatabase that is being created.
     */
    public static void dropTables(SQLiteDatabase db)
    {
        db.execSQL(DROP_TABLE_BGOBJECT_SQL);
        db.execSQL(DROP_TABLE_ASTEROIDS_SQL);
        db.execSQL(DROP_TABLE_LEVELS_SQL);
        db.execSQL(DROP_TABLE_LEVEL_OBJS_SQL);
        db.execSQL(DROP_TABLE_LEVEL_ASTEROIDS_SQL);
        db.execSQL(DROP_TABLE_MAINBODIES_SQL);
        db.execSQL(DROP_TABLE_CANNONS_SQL);
        db.execSQL(DROP_TABLE_EXTRAPARTS_SQL);
        db.execSQL(DROP_TABLE_ENGINES_SQL);
        db.execSQL(DROP_TABLE_POWERCORES_SQL);
    }
    /**
     * This method calls the create statements on the database
     * @param db    the sqlitedatabase that is being created.
     */
    public static void createTables(SQLiteDatabase db)
    {
        db.execSQL(CREATE_TABLE_BGOBJECTS_SQL);
        db.execSQL(CREATE_TABLE_ASTEROIDS_SQL);
        db.execSQL(CREATE_TABLE_LEVELS_SQL);
        db.execSQL(CREATE_TABLE_LEVEL_OBJS_SQL);
        db.execSQL(CREATE_TABLE_LEVEL_ASTEROIDS_SQL);
        db.execSQL(CREATE_TABLE_MAINBODIES_SQL);
        db.execSQL(CREATE_TABLE_CANNONS_SQL);
        db.execSQL(CREATE_TABLE_EXTRAPARTS_SQL);
        db.execSQL(CREATE_TABLE_ENGINES_SQL);
        db.execSQL(CREATE_TABLE_POWERCORES_SQL);
    }
/*
CONSTANTS/FINALS
 */
    /**
     * The database version (1st version).
     */
    private static final int DB_VERSION = 1;
    /**
     * The drop-table commands used.
     */
    private static final String DROP_TABLE_BGOBJECT_SQL = "DROP TABLE IF EXISTS BackgroundObjects;";
    private static final String DROP_TABLE_ASTEROIDS_SQL = "DROP TABLE IF EXISTS AsteroidTypes;";
    private static final String DROP_TABLE_LEVELS_SQL = "DROP TABLE IF EXISTS Levels;";
    private static final String DROP_TABLE_LEVEL_OBJS_SQL = "DROP TABLE IF EXISTS LevelBackgroundObjects;";
    private static final String DROP_TABLE_LEVEL_ASTEROIDS_SQL = "DROP TABLE IF EXISTS LevelAsteroids;";
    private static final String DROP_TABLE_MAINBODIES_SQL = "DROP TABLE IF EXISTS MainBodies;";
    private static final String DROP_TABLE_CANNONS_SQL = "DROP TABLE IF EXISTS Cannons;";
    private static final String DROP_TABLE_EXTRAPARTS_SQL = "DROP TABLE IF EXISTS ExtraParts;";
    private static final String DROP_TABLE_ENGINES_SQL = "DROP TABLE IF EXISTS Engines;";
    private static final String DROP_TABLE_POWERCORES_SQL = "DROP TABLE IF EXISTS PowerCores;";
    /**
     * The create-table commands used.
     */
    private static final String CREATE_TABLE_BGOBJECTS_SQL =
            "CREATE TABLE BackgroundObjects "+
                    "(" +
                    "   id integer not null primary key autoincrement," +
                    "   imagepath text not null" +
                    ");";
    private static final String CREATE_TABLE_ASTEROIDS_SQL =
            "CREATE TABLE AsteroidTypes " +
                    "(" +
                    "   id integer not null primary key autoincrement," +
                    "   name text not null," +
                    "   image_path text not null," +
                    "   image_width integer not null," +
                    "   image_height integer not null," +
                    "   atype text not null" +
                    ");";
    private static final String CREATE_TABLE_LEVELS_SQL =
            "CREATE TABLE Levels " +
                    "(" +
                    "   level_number integer not null primary key," +
                    "   title text not null," +
                    "   hint text," +
                    "   width integer not null," +
                    "   height integer not null," +
                    "   music text" +
                    ");";
    private static final String CREATE_TABLE_LEVEL_OBJS_SQL =
            "CREATE TABLE LevelBackgroundObjects " +
                    "(" +
                    "   level_number integer not null," +
                    "   position_x integer not null," +
                    "   position_y integer not null," +
                    "   object_id integer not null," +
                    "   scale real" +
                    ");";
    private static final String CREATE_TABLE_LEVEL_ASTEROIDS_SQL =
            "CREATE TABLE LevelAsteroids " +
                    "(" +
                    "   level_number integer not null," +
                    "   number integer not null," +
                    "   asteroid_id integer not null" +
                    ");";
    private static final String CREATE_TABLE_MAINBODIES_SQL =
            "CREATE TABLE MainBodies " +
                    "(" +
                    "   id integer not null primary key autoincrement," +
                    "   image text not null," +
                    "   image_width integer not null," +
                    "   image_height integer not null," +
                    "   cannon_attach_x integer not null," +
                    "   cannon_attach_y integer not null," +
                    "   engine_attach_x integer not null," +
                    "   engine_attach_y integer not null," +
                    "   extra_attach_x integer not null," +
                    "   extra_attach_y integer not null" +
                    ");";
    private static final String CREATE_TABLE_CANNONS_SQL =
            "CREATE TABLE Cannons " +
                    "(" +
                    "   id integer not null primary key autoincrement," +
                    "   image text not null," +
                    "   image_width integer not null," +
                    "   image_height integer not null," +
                    "   attach_point_x integer not null," +
                    "   attach_point_y integer not null," +
                    "   emit_point_x integer not null," +
                    "   emit_point_y integer not null," +
                    "   attack_image text not null," +
                    "   attack_image_width integer not null," +
                    "   attack_image_height integer not null," +
                    "   attack_sound text not null," +
                    "   damage integer not null" +
                    ");";
    private static final String CREATE_TABLE_EXTRAPARTS_SQL =
            "CREATE TABLE ExtraParts " +
                    "(" +
                    "   id integer not null primary key autoincrement," +
                    "   image text not null," +
                    "   image_width integer not null," +
                    "   image_height integer not null," +
                    "   attach_point_x integer not null," +
                    "   attach_point_y integer not null" +
                    ");";
    private static final String CREATE_TABLE_ENGINES_SQL =
            "CREATE TABLE Engines " +
                    "(" +
                    "   id integer not null primary key autoincrement," +
                    "   image text not null," +
                    "   image_width integer not null," +
                    "   image_height integer not null," +
                    "   attach_point_x integer not null," +
                    "   attach_point_y integer not null," +
                    "   base_speed integer not null," +
                    "   base_turn_rate integer not null" +
                    ");";
    private static final String CREATE_TABLE_POWERCORES_SQL =
            "CREATE TABLE PowerCores " +
                    "(" +
                    "   id integer not null primary key autoincrement," +
                    "   image text not null," +
                    "   cannon_boost integer not null," +
                    "   engine_boost integer not null" +
                    "); ";
/*
GETTERS/SETTERS
 */
    /**
     * The getter for the database name
     * @return  the database name
     */
    public static String getDbName() {
        return DB_NAME;
    }
}
