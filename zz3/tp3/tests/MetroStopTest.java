import junit.framework.TestCase;

public class MetroStopTest extends TestCase {
    MetroStop metro1 = new MetroStop(1649,2.36697471484243, 48.7870020157205,"Villejuif-Louis Aragon","VILLEJUIF","metro");

    public void testGetId() {
        Integer x = 1649;
        assertEquals(x, metro1.getId());
    }

    public void testGetLongitude() {
        Double x = 2.36697471484243;
        assertEquals(x, metro1.getLongitude());
    }

    public void testGetLatitude() {
        Double x = 48.7870020157205;
        assertEquals(x, metro1.getLatitude());
    }

    public void testGetNom() {
        String x = "Villejuif-Louis Aragon";
        assertEquals(x, metro1.getNom());
    }

    public void testGetArrondissement() {
        String x = "VILLEJUIF";
        assertEquals(x, metro1.getArrondissement());
    }

    public void testGetType() {
        String x = "metro";
        assertEquals(x, metro1.getType());
    }

    public void testSetId() {
        Integer x = 1650;
        metro1.setId(x);
        assertEquals(x, metro1.getId());
    }

    public void testSetLongitude() {
        Double x = 2.36394352657996;
        metro1.setLongitude(x);
        assertEquals(x, metro1.getLongitude());
    }

    public void testSetLatitude() {
        Double x = 48.8041740664156;
        metro1.setLatitude(x);
        assertEquals(x, metro1.getLatitude());
    }

    public void testSetNom() {
        String x = "Chardon-Lagache";
        metro1.setNom(x);
        assertEquals(x, metro1.getNom());
    }

    public void testSetArrondissement() {
        String x = "PARIS-16EME";
        metro1.setArrondissement(x);
        assertEquals(x, metro1.getArrondissement());
    }

    public void testSetType() {
        String x = "bus";
        metro1.setType(x);
        assertEquals(x, metro1.getType());
    }

    public void testTestToString() {
        String x = "MetroStop{id=1649, longitude=2.36697471484243, latitude=48.7870020157205, nom='Villejuif-Louis Aragon', arrondissement='VILLEJUIF', type='metro'}";
        assertEquals(x, metro1.toString());
    }
}