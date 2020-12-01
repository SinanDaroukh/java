import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherFetcher {

    public Weather getWeatherAt(String cityName) throws Exception {
        String line, json;
        final String API_KEY = "fdec5664d19caf22895d3aaf207d3d43";
        HttpURLConnection urlConnection = null ;

        try {
            URL url = new URL ("http://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=" + API_KEY + "&units=metric");
            urlConnection = (HttpURLConnection) url.openConnection ();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            InputStreamReader inReader = new InputStreamReader(in);
            BufferedReader inBReader = new BufferedReader(inReader);
            StringBuilder builder = new StringBuilder();
            while ((line = inBReader.readLine()) != null){
                builder.append(line);
            }
            json = builder.toString();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Weather weather = gson.fromJson(json, Weather.class);
            return weather;
        } catch (Exception e) {
            throw e;
        } finally {
            if ( urlConnection != null ){
                urlConnection . disconnect ();
            }
        }
    }

}
