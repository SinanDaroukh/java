package arwoon_shlaka.vehicule;

public class Voiture extends Vehicule {
    private int couleur = 0;
    private int places = 5;

    public Voiture() {}
    public Voiture(String i, int c, int p) {
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
