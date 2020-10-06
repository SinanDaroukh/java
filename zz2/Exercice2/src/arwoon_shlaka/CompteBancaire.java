package arwoon_shlaka;

public class CompteBancaire {
    private double solde = 0.0;       // solde du compte

    private double decouvert = -700.; // découvert autorisé

    public CompteBancaire(){}
    public CompteBancaire(double solde){
        this.solde = solde;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }

    @Override
    public String toString() {
        return "CompteBancaire{" +
                "solde=" + getSolde() +
                ", decouvert=" + getDecouvert() +
                '}';
    }

    public void retrait(double montant) throws IllegalArgumentException, AutorisationException{
        double nouveau = solde - montant;
        if (montant<0.0)
            throw new IllegalArgumentException("Mauvais montant");
        else if (nouveau<decouvert)
            throw new AutorisationException("Operation impossible : le compte serait trop debiteur");
        else solde = nouveau;
    }

    public static void main(String[] args){

        CompteBancaire compteBancaire = new CompteBancaire(300.0);
        System.out.println(compteBancaire.toString());
        // Retour :  CompteBancaire{solde=300.0, decouvert=-700.0}
        try{
            compteBancaire.retrait(-120.0); // Retour : java.lang.IllegalArgumentException: Mauvais montant
        }
        catch (Exception e){
            System.out.println(e);
        }

        try{
            compteBancaire.retrait(1100.0);
            // Retour : arwoon_shlaka.AutorisationException: An Autorisation Exception has occurred ! - Message : Operation impossible : le compte serait trop debiteur
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
}
