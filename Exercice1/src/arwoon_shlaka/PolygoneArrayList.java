package arwoon_shlaka;

// To see the doc about the ArrayList : https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html

import java.util.ArrayList;

public class PolygoneArrayList {

    ArrayList<Point> arrayList = new ArrayList<>(3);

    PolygoneArrayList(){}

    /*
    * Même principe que pour le Vector et le choix de ne pas lever d'exception quand l'ArrayList est pleine.
    * */

    void ajouter(Point p) {
        arrayList.add(p);
    }

    void enlever() throws EmptyException {
        if (arrayList.isEmpty()){
            throw new EmptyException();
        }
        else {
            arrayList.remove(arrayList.size() - 1);
        }
    }

    @Override
    public String toString() {
        return "PolygoneArrayList{" +
                "arrayList=" + arrayList +
                '}';
    }
}
