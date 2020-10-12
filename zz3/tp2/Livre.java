import java.lang.StringBuilder;
import java.util.Comparator;

public class Livre {
  private String titre;
  private float prix;
  private String dateDeSortie;
  private String categorie;
  private int noteDesLecteurs;

  public static class CompareTitre implements Comparator<Livre> {

    public int compare(Livre a, Livre b) {
      return a.titre.compareTo(b.titre);
    }
  }

  public static class CompareDateDeSortie implements Comparator<Livre> {

    public int compare(Livre a, Livre b) {
      return a.dateDeSortie.compareTo(b.dateDeSortie);
    }
  }

  public Livre(
    String titre,
    float prix,
    String dateDeSortie,
    String categorie,
    int noteDesLecteurs
  ) {
    this.titre = titre;
    this.prix = prix;
    this.dateDeSortie = dateDeSortie;
    this.categorie = categorie;
    this.noteDesLecteurs = noteDesLecteurs;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder(titre);
    builder.append(' ');
    builder.append(prix);
    builder.append(' ');
    builder.append(dateDeSortie);
    builder.append(' ');
    builder.append(categorie);
    builder.append(' ');
    builder.append(noteDesLecteurs);
    return builder.toString();
  }
}
