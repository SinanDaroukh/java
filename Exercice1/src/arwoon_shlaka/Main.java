package arwoon_shlaka;

public class Main {

    public static void main(String[] args) {

        Point y = new Point();
        System.out.println(y.toString());

        /* - Retour Console -
        * Nom de la Classe : Point
        * Coordonnées en X : 0
        * Coordonnées en Y : 0
        * */

        Point z = new Point(10,30);
        System.out.println(z.toString());

        /* - Retour Console -
         * Nom de la Classe : Point
         * Coordonnées en X : 10
         * Coordonnées en Y : 30
         * */

        Point a = new Point();
        System.out.println("Nombre d'instances de Point : " + Point.getCpt());

        /* - Retour Console -
         * Nombre d'instances de Point : 3
         * */

        Arc b = new Arc(y, z);
        System.out.println(b.toString());
    }
}
