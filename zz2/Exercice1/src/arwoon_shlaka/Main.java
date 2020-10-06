package arwoon_shlaka;

public class Main {

    public static void main(String[] args) {

        Point y = new Point();
        System.out.println(y.toString());

        /* - Retour Console -
            Point{x=0, y=0}
        * */

        Point z = new Point(10,30);
        System.out.println(z.toString());

        /* - Retour Console -
            Point{x=10, y=30}
         * */

        Point a = new Point();
        System.out.println("Nombre d'instances de Point : " + Point.getCpt());

        /* - Retour Console -
         * Nombre d'instances de Point : 3
         * */

        Arc b = new Arc(y, z);
        System.out.println(b.toString());

        /*
            Arc {
                Origine = Point{x=0, y=0}
                Destination = Point{x=10, y=30}
            }
        */

        System.out.println("\nBanque de Test avec PolygoneArray");

        PolygoneArray poly = new PolygoneArray();
        try {
            poly.ajouter(z);
            poly.ajouter(a);
            poly.ajouter(y);
            System.out.println(poly.toString());
            poly.ajouter(z);
        } catch (FullException e) {
            System.out.println(e.getMessage());
        }

        try {
            poly.enlever();
            poly.enlever();
            poly.enlever();
            System.out.println(poly.toString());
            poly.enlever();

        }
        catch (EmptyException e){
            System.out.println(e.getMessage());
        }

        System.out.println("\nBanque de Test avec PolygoneVector");

        PolygoneVector polygoneVector = new PolygoneVector();

        polygoneVector.ajouter(z);
        polygoneVector.ajouter(a);
        polygoneVector.ajouter(y);
        System.out.println(polygoneVector.toString());

        try {
            polygoneVector.enlever();
            polygoneVector.enlever();
            polygoneVector.enlever();
            System.out.println(polygoneVector.toString());
            polygoneVector.enlever();

        }
        catch (EmptyException e){
            System.out.println(e.getMessage());
        }

        System.out.println("\nBanque de Test avec PolygoneArrayList");

        PolygoneArrayList polygoneArrayList = new PolygoneArrayList();

         polygoneArrayList.ajouter(z);
         polygoneArrayList.ajouter(a);
         polygoneArrayList.ajouter(y);

         System.out.println(polygoneArrayList.toString());

        try {
            polygoneArrayList.enlever();
            polygoneArrayList.enlever();
            polygoneArrayList.enlever();
            System.out.println(polygoneArrayList.toString());
            polygoneArrayList.enlever();

        }
        catch (EmptyException e){
            System.out.println(e.getMessage());
        }

        System.out.println("\nBanque de Test avec PolygoneLinkedList");

        PolygoneLinkedList polygoneLinkedList = new PolygoneLinkedList();

        polygoneLinkedList.ajouter(z);
        polygoneLinkedList.ajouter(a);
        polygoneLinkedList.ajouter(y);

        System.out.println(polygoneLinkedList.toString());

        try {
            polygoneLinkedList.enlever();
            polygoneLinkedList.enlever();
            polygoneLinkedList.enlever();
            System.out.println(polygoneLinkedList.toString());
            polygoneLinkedList.enlever();

        }
        catch (EmptyException e){
            System.out.println(e.getMessage());
        }

    }
}
