package edu.byu.cs.superasteroids.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * The database for the program
 * @author Scott Leland Crossen
 */
public class Database {
/*
FIELDS
 */
    /**
     * This is where the open helper is kept.
     */
    private DbOpenHelper db_open_helper;
    /**
     * this is where the database is kept in memory.
     */
    private SQLiteDatabase database;
    /**
     * The base context
     */
    private Context base_context;
    /**
     * A copy of the DAO for public database access.
     */
    public DAO dao;
/*
CONSTRUCTORS
 */
    /**
     * the constructor for the database class
     * @param baseContext   the only needed information is the base context
     */
    public Database(Context baseContext) {
        base_context = baseContext;
        db_open_helper = new DbOpenHelper(base_context);
        database=db_open_helper.getWritableDatabase();
        dao=new DAO(database);
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
     * The getter for the DbOpenHelper used
     * @return  the DbOpenHelper used
     */
    public DbOpenHelper getDb_open_helper() {return db_open_helper;}
    /**
     * The getter for the database used
     * @return  the database used
     */
    public SQLiteDatabase getDatabase() {return database;}
    /**
     * The getter for the context used
     * @return  the context
     */
    public Context getBase_context() {return base_context;}
    /**
     * The getter for the DAO used
     * @return  the DAO used
     */
    public DAO getDao() {return dao;}
}
