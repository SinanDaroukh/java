package arwoon_shlaka.gestion2;

public class Camion extends Vehicule{
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
