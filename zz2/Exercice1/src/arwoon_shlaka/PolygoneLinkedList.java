package arwoon_shlaka;

// To see the javadoc about the LinkedList : https://docs.oracle.com/javase/8/docs/api/index.html

import java.util.LinkedList;

public class PolygoneLinkedList {
    LinkedList<Point> arrayList = new LinkedList<Point>();

    PolygoneLinkedList(){}

    /*
     * Même principe que pour le Vector et le choix de ne pas lever d'exception quand l'ArrayList est pleine.
     * */

    void ajouter(Point p) {
        arrayList.push(p);
    }

    void enlever() throws EmptyException {
        if (arrayList.isEmpty()){
            throw new EmptyException();
        }
        else {
            arrayList.pop();
        }
    }

    @Override
    public String toString() {
        return "PolygoneLinkedList{" +
                "arrayList=" + arrayList +
                '}';
    }
}
