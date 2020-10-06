package arwoon_shlaka;

public class Arc {

    Point origine = null;
    Point destination = null;

    Arc(){}
    Arc(Point x, Point y){
        setOrigine(x);
        setDestination(y);
    }

    public Point getOrigine() {
        return origine;
    }

    public void setOrigine(Point origine) {
        this.origine = origine;
    }

    public Point getDestination() {
        return destination;
    }

    public void setDestination(Point destination) {
        this.destination = destination;
    }

    public String toString() {
        return "Arc {\n" +
                "\tOrigine = " + getOrigine() +
                "\n\tDestination = " + getDestination() +
                "\n}";
    }
}
