public final class Coordinates {
    private final String lon;
    private final String lat;

    public final String getLongitude() {
        return lon;
    }

    public final String getLatitude() {
        return lat;
    }

    public Coordinates(String longitude, String latitude) {
        this.lon = longitude;
        this.lat = latitude;
    }
}