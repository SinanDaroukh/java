package Model;

import java.util.Date;

public class Weather {

    private Coordinates coord;
    private String base;
    private Temperature main;
    private Wind wind;
    private Integer dt;
    private String name;

    public Coordinates getCoord() {
        return coord;
    }

    public String getBase() {
        return base;
    }

    public Temperature getMain() {
        return main;
    }

    public Wind getWind() {
        return wind;
    }

    public Integer getDt() {
        return dt;
    }

    public String getName() {
        return name;
    }

    public Weather(Coordinates coord, String base, Temperature main, Wind wind, Integer dt, String name) {
        this.coord = coord;
        this.base = base;
        this.main = main;
        this.wind = wind;
        this.dt = dt;
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder weatherSummary = new StringBuilder();
        return weatherSummary
                .append("Weather fetched at : ").append(new Date(Long.parseLong(dt.toString()) * 1000)).append("\n")
                .append("City name : ").append(name).append("\n")
                .append("Longitude : ").append(coord.getLongitude()).append("\n")
                .append("Latitude : ").append(coord.getLatitude()).append("\n")
                .append("Current temperature : ").append(main.getTemp()).append("°C\n")
                .append("Temperature felt : ").append(main.getFeels_like()).append("°C\n")
                .append("Minimum temperature : ").append(main.getTemp_min()).append("°C\n")
                .append("Maximum temperature : ").append(main.getTemp_max()).append("°C\n")
                .append("Pressure : ").append(main.getPressure()).append("Pa\n")
                .append("Humidity : ").append(main.getHumidity()).append("%\n")
                .append("Wind speed : ").append(wind.getSpeed()).append("m/s\n")
                .append("Wind deg : ").append(wind.getDeg()).append("degrees\n")
                .append("Wind gust : ").append(wind.getGust()).append("m/s\n")
                .toString();
    }
}