package arwoon_shlaka;

// To see the javadoc about Vector : https://docs.oracle.com/javase/8/docs/api/java/util/Vector.html

import java.util.Vector;

public class PolygoneVector {

    Vector<Point> vecteurDePoint = new Vector<Point>(3, 5);

    PolygoneVector(){}

    /*
    * Plusieurs approches sont à prendre en compte pour la méthode ajouter(), comme par exemple, est-ce que le lancement
    * d'une FullException est nécessaire ?
    * Ici, j'ai décidé de ne pas en mettre car le principe du Vector est le suivant :
    *   Lorsque ce dernier n'a plus de place en son sein, il réalloue automatiquement des nombres données de
    *   cases mémoires pour les éléments suivants. Ce nombre est l'attribut capacityIncrement de la classe Vector
    *
    * Ainsi, il n'y a pas de FullException levée
    * */

    void ajouter(Point p) {
            vecteurDePoint.add(p);
    }

    void enlever() throws EmptyException {
        if (vecteurDePoint.isEmpty()){
            throw new EmptyException();
        }
        else {
            vecteurDePoint.remove(vecteurDePoint.size() - 1);
        }
    }

    @Override
    public String toString() {
        return "PolygoneVector{" +
                "vecteurDePoint=" + vecteurDePoint +
                '}';
    }
}
