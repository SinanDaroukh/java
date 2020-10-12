import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

enum Menu {
  Ajouter,
  Afficher,
  AfficherLivres,
  AfficherMagazine,
  TrierParDateDeSortie,
  TrierParTitre,
  Quitter,
}

public class Main {
  private static List<Livre> list = new ArrayList<Livre>();

  private static Scanner scanner;

  public static void main(String[] argv) {
    ajouter(
      new Livre(
        "Lucky-Luke - Un cowboy dans le coton",
        10.95f,
        "23/10/2020",
        "BD",
        5
      )
    );
    ajouter(
      new Livre("Lucky-Luke - Un cowboy à Paris", 10.95f, "02/11/2018", "BD", 5)
    );
    ajouter(
      new Livre("Kid Lucky - Kid ou Double", 10.95f, "29/11/2019", "BD", 5)
    );
    ajouter(
      new Livre(
        "Effective Modern C++ by Scott Meyers",
        24.95f,
        "11/11/2014",
        "Informatique",
        5
      )
    );
    ajouter(
      new Livre(
        "Java pour les nuls - Barry A. Burd",
        24.95f,
        "02/10/2014",
        "Informatique",
        5
      )
    );

    ajouter(new Magazine("Playboy", 9.5f, "04/05/2020", "+18", 4, "Mensuel"));
    ajouter(
      new Magazine(
        "Geek",
        9.5f,
        "05/05/2020",
        "Informatique",
        3,
        "Hebdomadaire"
      )
    );
    while (true) {
      afficherMenu();
      try {
        scanner = new Scanner(System.in);
        int i = Integer.parseInt(scanner.nextLine());
        Menu menu = Menu.values()[i - 1];
        switch (menu) {
          case Ajouter:
            saisieAjouter();
            break;
          case Afficher:
            afficher();
            break;
          case AfficherLivres:
            afficherLivreOnly();
            break;
          case AfficherMagazine:
            afficherMagazineOnly();
            break;
          case TrierParDateDeSortie:
            trierParDDS();
            break;
          case TrierParTitre:
            trierParTitre();
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
    System.out.println("1) Ajouter :");
    System.out.println("2) Afficher tout les documents :");
    System.out.println("3) Afficher les livres :");
    System.out.println("4) Afficher les magazines :");
    System.out.println("5) Trier par date de sortie :");
    System.out.println("6) Trier par titre :");
  }

  private static void saisieAjouter() {
    System.out.println("1) Ajouter un livre :");
    System.out.println("2) Ajouter un magazine :");
    int option = Integer.parseInt(scanner.nextLine());
    System.out.println("Titre :");
    String titre = scanner.nextLine();
    System.out.println("Prix :");
    Float prix = Float.parseFloat(scanner.nextLine());
    System.out.println("Date de sortie : Format : (DD/MM/YYYY)");
    String dds = scanner.nextLine();
    System.out.println("Categorie :");
    String cat = scanner.nextLine();
    System.out.println("Note des lecteurs :");
    int note = Integer.parseInt(scanner.nextLine());
    if (option == 2) {
      System.out.println("Periodicite :");
      String periodicite = scanner.nextLine();
      ajouter(new Magazine(titre, prix, dds, cat, note, periodicite));
    } else {
      ajouter(new Livre(titre, prix, dds, cat, note));
    }
  }

  private static void ajouter(Livre bouquin) {
    list.add(bouquin);
  }

  private static void afficher() {
    list.forEach(System.out::println);
  }

  private static void afficherLivreOnly() {
    for (Livre bouquin : list) {
      if (!(bouquin instanceof Magazine)) {
        System.out.println(bouquin);
      }
    }
  }

  private static void afficherMagazineOnly() {
    for (Livre bouquin : list) {
      if (bouquin instanceof Magazine) {
        System.out.println(bouquin);
      }
    }
  }

  private static void trierParTitre() {
    Collections.sort(list, new Livre.CompareTitre());
  }

  private static void trierParDDS() {
    Collections.sort(list, new Livre.CompareDateDeSortie());
  }
}
