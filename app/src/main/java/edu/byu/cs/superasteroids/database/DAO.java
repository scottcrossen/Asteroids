package edu.byu.cs.superasteroids.database;

import android.database.sqlite.SQLiteDatabase;

/**
 * The accessor to the database.
 * @author Scott Leland Crossen
 */
public class DAO {
    SQLiteDatabase db;
    /**
     * the constructor of the Database Access Class
     * @param _db   the only information needed is the location of the database to use.
     */
    public DAO(SQLiteDatabase _db)
    {
        db = _db;
    }
}
