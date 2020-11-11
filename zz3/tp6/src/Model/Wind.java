package Model;

public class Wind {
    private final Double speed;
    private final Double deg;

    public Double getSpeed() {
        return speed;
    }

    public Double getDeg() {
        return deg;
    }

    public Wind(Double speed, Double deg) {
        this.speed = speed;
        this.deg = deg;
    }
}