import junit.framework.TestCase;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class ParserTest extends TestCase {

        public String mockedFile = "1975#2.33871281165883#48.8844176451841#Abbesses#PARIS-18EME#metro\n1981#2.32674567371924#48.828398514348#Alésia#PARIS-14EME#metro";

        public List<MetroStop> metroStopList = new ArrayList<>();

        public ParserTest() {
            MetroStop m1 = new MetroStop(1975,2.33871281165883,48.8844176451841,"Abbesses","PARIS-18EME","metro");
            MetroStop m2 = new MetroStop(1981,2.32674567371924,48.828398514348,"Alésia","PARIS-14EME","metro");

            metroStopList.add(m1);
            metroStopList.add(m2);
        }

        public void testParse() {
            List<MetroStop> list = new ArrayList<>();
            Reader reader = new StringReader(mockedFile);
            Parser p = new Parser(reader);
            try {
                p.parse(list);
            } catch (Exception e) { e.printStackTrace(); }

            assertEquals(metroStopList, list);
        }

        public void testEmptyParse(){
            List<MetroStop> list = new ArrayList<>();
            Reader reader = new StringReader("");
            Parser p = new Parser(reader);
            try {
                p.parse(list);
            } catch (Exception e) { e.printStackTrace(); }
            assertTrue(list.isEmpty());
        }
}