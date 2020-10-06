package arwoon_shlaka.gestion1;

public class Gestion1 {

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

class Vehicule {
    protected String immat = "ZZ 000 ZZ";

    Vehicule() {}
    public void avancer(){
        System.out.println("Je suis un véhicule et j'avance");
    }

    public void afficher(){
        System.out.println("Je suis un véhicule et mon immatriculation est " + immat);
    }
}

class Voiture extends Vehicule{
    private int couleur = 0;
    private int places = 5;

    Voiture() {}
    Voiture(String i, int c, int p) {
        places = p;
        couleur = c;
        immat = i;
    }

    @Override
    public void avancer(){
        System.out.println("Je suis une voiture et j'avance");
    }

    @Override
    public void afficher(){
        System.out.println("Je suis une voiture et mon immatriculation est " + immat);
        System.out.println("Ma couleur est le  " + couleur + " et j'ai " + places + " places");
    }
}

class Camion extends Vehicule {
    private float capacite = (float) 10.5;

    Camion() {}
    Camion(String immat, float c) {
        capacite = c;
    }

    @Override
    public void avancer(){
        System.out.println("Je suis une camion et j'avance");
    }

    @Override
    public void afficher(){
        System.out.println("Je suis un camion et mon immatriculation est " + immat);
        System.out.println("Ma capacité est de " + capacite);
    }
}