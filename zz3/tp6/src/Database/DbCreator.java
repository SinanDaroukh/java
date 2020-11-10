package Database;

import Model.Weather;

import java.sql.*;
import java.util.Date;

public class DbCreator {

    public static void createNewDatabase(String fileName) {

        String url = "jdbc:sqlite:src/Database/" + fileName;

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createWeatherTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:src/Database/hello.db";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS weather (\n"
                + "	fetchedAt integer NOT NULL,\n"
                + "	cityName text NOT NULL,\n"
                + "	longitude real NOT NULL,\n"
                + " latitude real NOT NULL,\n"
                + " currentTemp real NOT NULL,\n"
                + " tempFelt real NOT NULL,\n"
                + " minTemp real NOT NULL,\n"
                + " maxTemp real NOT NULL,\n"
                + " pressure real,\n"
                + " humidity real,\n"
                + " windSpeed real,\n"
                + " windDeg real,\n"
                + " windGust real,\n"
                + " PRIMARY KEY (fetchedAt, cityName)"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertWeatherFetched(Weather weather) {
        String url = "jdbc:sqlite:src/Database/hello.db";

        String sql = "INSERT INTO weather(  " +
                "fetchedAt," +
                "cityName," +
                "longitude," +
                "latitude," +
                "currentTemp," +
                "tempFelt," +
                "minTemp," +
                "maxTemp," +
                "pressure," +
                "humidity," +
                "windSpeed," +
                "windDeg," +
                "windGust) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(url);

        PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, weather.getDt());
            pstmt.setString(2, weather.getName());
            pstmt.setDouble(3, weather.getCoord().getLongitude());
            pstmt.setDouble(4, weather.getCoord().getLatitude());
            pstmt.setDouble(5, weather.getMain().getTemp());
            pstmt.setDouble(6, weather.getMain().getFeels_like());
            pstmt.setDouble(7, weather.getMain().getTemp_min());
            pstmt.setDouble(8, weather.getMain().getTemp_max());
            pstmt.setDouble(9, weather.getMain().getPressure());
            pstmt.setDouble(10, weather.getMain().getHumidity());
            pstmt.setDouble(11, weather.getWind().getSpeed());
            pstmt.setDouble(12, weather.getWind().getDeg());
            pstmt.setNull(13, 2 );
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public DbCreator() {
    }

}
