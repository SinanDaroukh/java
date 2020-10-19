import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class MetroManagerTest extends TestCase {

    public List<MetroStop> metroStopList = new ArrayList<>();

    MetroStop m1 = new MetroStop(1651,2.3679661373898,48.7959447270881,"Villejuif-Paul Vaillant Couturier (Hôpital Paul Brousse)","PARIS","metro");
    MetroStop m2 = new MetroStop(1938,2.42923849792977,48.8453342425325,"Bérault","VINCENNES","metro");
    MetroStop m3 = new MetroStop(1962,2.43950970545674,48.8445363116503,"Château de Vincennes","PARIS","metro");

    public MetroManagerTest() {
        metroStopList.add(m2);
        metroStopList.add(m1);
        metroStopList.add(m3);
    }

    public void testTrierParID() {
        List<MetroStop> a = new ArrayList<>();
        a.add(m1); a.add(m2); a.add(m3);
        MetroManager.trierParID(metroStopList);
        assertEquals(metroStopList, a);
    }

    public void testTrierParArrStation() {
        List<MetroStop> a = new ArrayList<>();
        a.add(m3); a.add(m1); a.add(m2);
        MetroManager.trierParArrStation(metroStopList);
        assertEquals(metroStopList, a);
    }
}