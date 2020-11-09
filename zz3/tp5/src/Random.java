public class Random {
    public int integerOne;
    public Integer integerTwo;
    private double doubleOne;
    public float floatOne;
    public String string;

    public Random(int integerOne) {
        this.integerOne = integerOne;
    }

    public Random(double doubleOne) {
        this.doubleOne = doubleOne;
    }

    public Random(float floatOne) {
        this.floatOne = floatOne;
    }

    public Random(int integerOne, double doubleOne, float floatOne) {
        this.integerOne = integerOne;
        this.doubleOne = doubleOne;
        this.floatOne = floatOne;
    }

    public void Hello(int random){ }

    private String Bye() {
        return "-Cya-";
    }
}
