package edu.byu.cs.superasteroids.importer;

import android.content.Context;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;

import edu.byu.cs.superasteroids.base.Debug;
import edu.byu.cs.superasteroids.database.Database;

/**
 * @author Scott Leland Crossen
 */
public class GameDataImporter implements IGameDataImporter {
/*
FIELDS
*/
    private Database db;
    private Context context;
    private static Debug debug;
/*
CONSTRUCTORS
 */
    /**
     * The constructor for the class
     * @param _context  the context to read in the database.
     */
    public GameDataImporter(Context _context) {
        db = new Database(_context);
        context = _context;
        debug = new Debug(1);
    }
    /**
     * The constructor for the JUnit test cases
     */
    public GameDataImporter(){}// For Test Case
/*
METHODS
 */
    /**
     * The main method called that reads in the JSON
     * @param dataInputReader The InputStreamReader connected to the .json file needing to be imported.
     * @return  whether the JSON was read in.
     */
    @Override
    public boolean importData(InputStreamReader dataInputReader) {
        db.dao.clearAll(); // Remake the database so we can fill it.
        JSONObject root_obj;
        try {
            root_obj = new JSONObject(makeString(dataInputReader));
        } catch(java.io.IOException e) {
            return false;
        } catch(org.json.JSONException e) {
            return false;
        }
        try {
            db.dao.importJSON(root_obj); // Give this to the dao to import. It has the methods.
        } catch (org.json.JSONException e) {
            debug.output("Failed while reading JSON:");
            debug.output(root_obj.toString());
            debug.printFlags(1);
            return false;
        }
        return true;
    }
    /**
     * Allows for easy object manipulation
     * @param reader    the InputStreamReader containing the .json
     * @return      the string of the reader.
     * @throws IOException  In case the the reader can't work.
     */
    private static String makeString(InputStreamReader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        char[] buf = new char[512];
        int n = 0;
        while ((n = reader.read(buf)) > 0)  // Read in Reader to String.
            sb.append(buf, 0, n);
        debug.output("Reading in JSON:");
        debug.output(sb.toString());
        return sb.toString(); // Output string. this will be converted to JSON.
    }
/*
CONSTANTS/FINALS
 */
/*
GETTERS/SETTERS
 */
}
