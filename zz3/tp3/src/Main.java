import java.util.Scanner;

enum Menu {
    Afficher,
    AfficherParID,
    AfficherParArrStation,
    Quitter,
}

public class Main {

    public static void main(String[] args) {
        Parser parser = new Parser();
        Scanner scanner;
        try {
            parser.parse(MetroManager.listMetro);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        while (true) {
            afficherMenu();
            try {
                scanner = new Scanner(System.in);
                int i = Integer.parseInt(scanner.nextLine());
                Menu menu = Menu.values()[i - 1];
                switch (menu) {
                    case Afficher:
                        MetroManager.afficherListeMetro(MetroManager.listMetro);
                        break;
                    case AfficherParID:
                        MetroManager.trierParID(MetroManager.listMetro);
                        MetroManager.afficherListeMetro(MetroManager.listMetro);
                        break;
                    case AfficherParArrStation:
                        MetroManager.trierParArrStation(MetroManager.listMetro);
                        MetroManager.afficherListeMetro(MetroManager.listMetro);
                        break;
                    case Quitter:
                        return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private static void afficherMenu() {
        System.out.println("1) Afficher :");
        System.out.println("2) Afficher les métros triés par id :");
        System.out.println("3) Afficher les métros triés par arrondissement puis par nom :");
        System.out.println("4) Quitter :");
    }
}
