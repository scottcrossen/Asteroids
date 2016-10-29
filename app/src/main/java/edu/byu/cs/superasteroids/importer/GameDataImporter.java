package edu.byu.cs.superasteroids.importer;

import android.content.Context;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;

import edu.byu.cs.superasteroids.base.Debug;
import edu.byu.cs.superasteroids.database.Database;

/**
 * Created by slxn42 on 10/29/16.
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
    public GameDataImporter(Context _context) {
        db = new Database(_context);
        context = _context;
        debug = new Debug(1);
    }
/*
METHODS
 */
    @Override
    public boolean importData(InputStreamReader dataInputReader)
    {
        db.dao.clearAll();
        JSONObject root_obj;
        try {
            root_obj = new JSONObject(makeString(dataInputReader));
        } catch(java.io.IOException e) {
            return false;
        } catch(org.json.JSONException e) {
            return false;
        }
        try {
            db.dao.importJSON(root_obj);
        } catch (org.json.JSONException e) {
            return false;
        }
        return true;
    }
    private static String makeString(InputStreamReader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        char[] buf = new char[512];
        int n = 0;
        while ((n = reader.read(buf)) > 0) {
            sb.append(buf, 0, n);
        }
        debug.output("Reading in JSON file:");
        debug.output(sb.toString());
        return sb.toString();
    }
/*
CONSTANTS/FINALS
 */
/*
GETTERS/SETTERS
 */


}
