import Database.DbManager;
import Model.Weather;
import Model.WeatherFetcher;

public class Main {

    public static void main(String[] args) {
        Weather weather = null;

        if (args.length != 1) {
            System.err.println("Usage : main.java cityName");
            throw new IllegalArgumentException();
        }
        try {
            WeatherFetcher weatherFetcher = new WeatherFetcher();
            weather = weatherFetcher.getWeatherAt(args[0]);
            //System.out.println(weather);
            DbManager db = new DbManager("weather.db");
            DbManager.createWeatherTable();
            //DbCreator.insertWeatherFetched(weather);
            DbManager.displayDatabaseOrderedBy("cityName");
            //DbCreator.displayDatabaseOrderedBy("currentTemp");
            DbManager.deleteOldData();

        } catch (Exception e){
            e.printStackTrace();
        }



    }
}
