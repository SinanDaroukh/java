package arwoon_shlaka.gestion2;

public class Gestion2 {
    public static void main(String[] args) {
        Vehicule u = new Vehicule();
        Voiture v = new Voiture();
        Camion w = new Camion();
        Vehicule x = new Voiture();
        //Voiture y =  new Vehicule();

        u.afficher();
        v.afficher();
        w.afficher();
        x.afficher();

        u.avancer();
        v.avancer();
        w.avancer();
        x.avancer();
    }
}
