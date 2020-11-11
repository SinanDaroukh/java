package Database;

import Model.Weather;

import java.sql.*;

public class DbManager {
  public static String url;
  public static void createWeatherTable() throws SQLException {
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
                + " PRIMARY KEY (fetchedAt, cityName)"
                + ");";
        try (Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void insertWeatherFetched(Weather weather) throws SQLException {
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
                "windDeg) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
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
            pstmt.executeUpdate();
            System.out.println("Query has been added to database");
        }
        catch (SQLException e) {
            throw e;
        }
    }

    public static void displayDatabase() throws SQLException {
        String sql = "SELECT fetchedAt,cityName,longitude,latitude,currentTemp,tempFelt,minTemp," +
                "maxTemp,pressure,humidity,windSpeed,windDeg FROM weather";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                System.out.println(rs.getInt("fetchedAt") + " - " +
                        rs.getString("cityName") + " - " +
                        rs.getDouble("longitude") + " - " +
                        rs.getDouble("latitude") + " - " +
                        rs.getDouble("currentTemp") + " - " +
                        rs.getDouble("tempFelt") + " - " +
                        rs.getDouble("minTemp") + " - " +
                        rs.getDouble("maxTemp") + " - " +
                        rs.getDouble("pressure") + " - " +
                        rs.getDouble("humidity") + " - " +
                        rs.getDouble("windSpeed") + " - " +
                        rs.getDouble("windDeg")
                );
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void displayDatabaseOrderedBy(String param) throws SQLException {
        String sql = "SELECT fetchedAt,cityName,longitude,latitude,currentTemp,tempFelt,minTemp," +
                "maxTemp,pressure,humidity,windSpeed,windDeg FROM weather ORDER BY " + param;
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                System.out.println(rs.getInt("fetchedAt") + " - " +
                        rs.getString("cityName") + " - " +
                        rs.getDouble("longitude") + " - " +
                        rs.getDouble("latitude") + " - " +
                        rs.getDouble("currentTemp") + " °C - " +
                        rs.getDouble("tempFelt") + " °C - " +
                        rs.getDouble("minTemp") + " °C - " +
                        rs.getDouble("maxTemp") + " °C - " +
                        rs.getDouble("pressure") + " Pa - " +
                        rs.getDouble("humidity") + " % - " +
                        rs.getDouble("windSpeed") + " m/s - " +
                        rs.getDouble("windDeg") + " degrees -"
                );
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void deleteOldData() throws SQLException {
      long epochDate = System.currentTimeMillis()/1000 - 86400; // 1 day before today
      String sql = "DELETE FROM weather WHERE fetchedAt < " + epochDate;

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void dropTable() throws SQLException {
        String sql = "DROP TABLE IF EXISTS weather";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            throw e;
        }
    }

    public DbManager(String fileName) {
      DbManager.url = "jdbc:sqlite:src/Database/" + fileName;
    }
}
