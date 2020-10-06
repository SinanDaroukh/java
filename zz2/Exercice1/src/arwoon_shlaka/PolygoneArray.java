package arwoon_shlaka;

import java.util.Arrays;

public class PolygoneArray {

    Point[] tableauDePoint = new Point[3];
    private int cpt = 0;

    PolygoneArray(){}

    void ajouter(Point p) throws FullException {
        if (cpt == 3){
            throw new FullException();
        }
        else {
            tableauDePoint[cpt] = p;
            cpt++;
        }
    }

    void enlever() throws EmptyException {
        if (cpt == 0){
            throw new EmptyException();
        }
        else {
            tableauDePoint[cpt - 1] = null;
            cpt--;
        }
    }

    public String toString() {
        return "PolygoneArray {" +
                "tableauDePoint = " + Arrays.toString(tableauDePoint) +
                "}";
    }
}
