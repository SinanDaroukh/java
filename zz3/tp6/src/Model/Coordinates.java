package Model;

public class Coordinates {
    private final Double lon;
    private final Double lat;

    public Double getLongitude() {
        return lon;
    }

    public Double getLatitude() {
        return lat;
    }

    public Coordinates(Double longitude, Double latitude) {
        this.lon = longitude;
        this.lat = latitude;
    }
}