public class Magazine extends Livre {
  private String periodicite;

  public Magazine(
    String titre,
    float prix,
    String dateDeSortie,
    String categorie,
    int noteDesLecteurs,
    String periodicite
  ) {
    super(titre, prix, dateDeSortie, categorie, noteDesLecteurs);
    this.periodicite = periodicite;
  }

  @Override
  public String toString() {
    return super.toString() + ' ' + periodicite;
  }
}
