public final class Temperature {
    private final Double temp;
    private final Double feels_like;
    private final Double temp_min;
    private final Double temp_max;
    private final Double pressure;
    private final Double humidity;

    public final Double getTemp() {
        return temp;
    }

    public final Double getFeels_like() {
        return feels_like;
    }

    public final Double getTemp_min() {
        return temp_min;
    }

    public final Double getTemp_max() {
        return temp_max;
    }

    public final Double getPressure() {
        return pressure;
    }

    public final Double getHumidity() {
        return humidity;
    }

    public Temperature(Double temp, Double feels_like, Double temp_min, Double temp_max, Double pressure, Double humidity) {
        this.temp = temp;
        this.feels_like = feels_like;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
        this.pressure = pressure;
        this.humidity = humidity;
    }
}