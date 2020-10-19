import java.util.Comparator;
import java.util.Objects;

public class MetroStop {
    private Integer id;
    private Double longitude; // Est-Ouest
    private Double latitude; // Nord-Sud
    private String nom;
    private String arrondissement;
    private String type;

    public static class CompareID implements Comparator<MetroStop> {
        public int compare(MetroStop a, MetroStop b) { return a.id.compareTo(b.id); }
    }

    public static class CompareArrStation implements Comparator<MetroStop> {
        public int compare(MetroStop a, MetroStop b){ int var = a.arrondissement.compareTo(b.arrondissement); return (var == 0) ? a.nom.compareTo(b.nom) : var; }
    }

    public MetroStop(String [] parts) {
        this.id = Integer.parseInt(parts[0]);
        this.longitude = Double.parseDouble(parts[1]);
        this.latitude = Double.parseDouble(parts[2]);
        this.nom = parts[3];
        this.arrondissement = parts[4];
        this.type = parts[5];
    }

    public MetroStop(Integer id, Double longitude, Double latitude, String nom, String arrondissement, String type) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.nom = nom;
        this.arrondissement = arrondissement;
        this.type = type;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getArrondissement() {
        return arrondissement;
    }

    public void setArrondissement(String arrondissement) {
        this.arrondissement = arrondissement;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "MetroStop{" +
                "id=" + id +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", nom='" + nom + '\'' +
                ", arrondissement='" + arrondissement + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MetroStop metroStop = (MetroStop) o;
        return id.equals(metroStop.id) &&
                longitude.equals(metroStop.longitude) &&
                latitude.equals(metroStop.latitude) &&
                nom.equals(metroStop.nom) &&
                arrondissement.equals(metroStop.arrondissement) &&
                type.equals(metroStop.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, longitude, latitude, nom, arrondissement, type);
    }
}
