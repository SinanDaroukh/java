public class Coordinates {
    private String lon;
    private String lat;

    public String getLongitude() {
        return lon;
    }

    public void setLongitude(String longitude) {
        this.lon = longitude;
    }

    public String getLatitude() {
        return lat;
    }

    public void setLatitude(String latitude) {
        this.lat = latitude;
    }

    public Coordinates(String longitude, String latitude) {
        this.lon = longitude;
        this.lat = latitude;
    }
}