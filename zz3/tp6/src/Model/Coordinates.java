package Model;

public class Coordinates {
    private Double lon;
    private Double lat;

    public Double getLongitude() {
        return lon;
    }

    public void setLongitude(Double longitude) {
        this.lon = longitude;
    }

    public Double getLatitude() {
        return lat;
    }

    public void setLatitude(Double latitude) {
        this.lat = latitude;
    }

    public Coordinates(Double longitude, Double latitude) {
        this.lon = longitude;
        this.lat = latitude;
    }
}