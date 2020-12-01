public final class Wind {
    private final Double speed;
    private final Double deg;
    private final Double gust;

    public final Double getSpeed() {
        return speed;
    }

    public final Double getDeg() {
        return deg;
    }

    public final Double getGust() {
        return gust;
    }

    public Wind(Double speed, Double deg, Double gust) {
        this.speed = speed;
        this.deg = deg;
        this.gust = gust;
    }
}