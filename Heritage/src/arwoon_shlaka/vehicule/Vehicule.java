package arwoon_shlaka.vehicule;

public class Vehicule {
    protected String immat = "ZZ 000 ZZ";

    public Vehicule() {}
    public void avancer(){
        System.out.println("Je suis un véhicule et j'avance");
    }

    public void afficher(){
        System.out.println("Je suis un véhicule et mon immatriculation est " + immat);
    }
}
