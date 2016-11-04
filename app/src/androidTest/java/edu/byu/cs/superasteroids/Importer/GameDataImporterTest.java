package edu.byu.cs.superasteroids.Importer;

import junit.framework.TestCase;

import edu.byu.cs.superasteroids.importer.GameDataImporter;

/*
  The majority of test cases for this class happen within the DAO test class
*/
/**
 * @author Scott Leland Crossen
 */
public class GameDataImporterTest extends TestCase {
    private GameDataImporter importer=new GameDataImporter();
    /**
     * Tests the given method
     * @throws Exception if the assertEquals statements don't hold
     */
    public void testImportData() throws Exception {
        assertEquals(null, importer.importData(null));
        // The other test cases for this method are in the dao test-case class.
    }
}
