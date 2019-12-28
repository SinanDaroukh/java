package arwoon_shlaka;

public class Point {
    int x = 0;
    int y = 0;

    static int cpt = 0;


    Point(){cpt++;}
    Point(int x, int y){
        setX(x);
        setY(y);
        cpt++;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public static int getCpt() {
        return cpt;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
