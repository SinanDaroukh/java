import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MetroManager {

    public static List<MetroStop> listMetro = new ArrayList<>();

    public MetroManager() {
    }

    public static void afficherListeMetro(List<MetroStop> list){
        for (MetroStop metro : list){
           System.out.println(metro);
        }
    }

    public static void trierParID(List<MetroStop> list){ Collections.sort(list, new MetroStop.CompareID());}

    public static void trierParArrStation(List<MetroStop> list){ Collections.sort(list, new MetroStop.CompareArrStation());}
}
