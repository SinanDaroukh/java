import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;

public class Parser {

    private Reader reader;
    private BufferedReader br;

    public Parser(){
        try {
            this.reader = new FileReader("ratp_arret.csv");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        br = new BufferedReader(this.reader);
    }

    public Parser(Reader reader){
        this.reader = reader;
        br = new BufferedReader(this.reader);
    }

    public void parse(List<MetroStop> list) throws Exception {
        String line;
        while ((line = br.readLine()) != null){
            String[] parts = line.split("#");
            if ( parts[5].equals("metro") ){
                MetroStop metro = new MetroStop(parts);
                list.add(metro);
            }
        }
        br.close();
    }
}
