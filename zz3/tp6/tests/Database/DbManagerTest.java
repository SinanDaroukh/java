package Database;

import junit.framework.TestCase;

import java.sql.SQLException;

public class DbManagerTest extends TestCase {
    
    DbManager db = new DbManager("weatherTest.db");

    public void testCreateWeatherTable() {
        try {
            DbManager.createWeatherTable();
            DbManager.createWeatherTable();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            fail("Call of createWeatherTable() should not have fail");
        }
        assertTrue(true);
    }

    public void testInsertWeatherFetched() {
    }

    public void testDisplayDatabase() {
    }

    public void testDisplayDatabaseOrderedBy() {
    }

    public void testDeleteOldData() {
    }

}