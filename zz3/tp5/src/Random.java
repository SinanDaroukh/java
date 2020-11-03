public class Random {
    private int integerOne;
    private Integer integerTwo;
    private double doubleOne;
    private Double doubleTwo;
    private float floatOne;
    private Float floatTwo;

    public Random(int integerOne, Integer integerTwo) {
        this.integerOne = integerOne;
        this.integerTwo = integerTwo;
    }

    public Random(double doubleOne, Double doubleTwo) {
        this.doubleOne = doubleOne;
        this.doubleTwo = doubleTwo;
    }

    public Random(float floatOne, Float floatTwo) {
        this.floatOne = floatOne;
        this.floatTwo = floatTwo;
    }

    public Random(int integerOne, Integer integerTwo, double doubleOne, Double doubleTwo, float floatOne, Float floatTwo) {
        this.integerOne = integerOne;
        this.integerTwo = integerTwo;
        this.doubleOne = doubleOne;
        this.doubleTwo = doubleTwo;
        this.floatOne = floatOne;
        this.floatTwo = floatTwo;
    }
}
