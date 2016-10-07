package edu.byu.cs.superasteroids.database;

import android.database.sqlite.SQLiteDatabase;

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
