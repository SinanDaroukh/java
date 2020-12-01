import junit.framework.TestCase;

public class WeatherFetcherTest extends TestCase {

    public void testGoodCity() {
        WeatherFetcher weatherFetcher = new WeatherFetcher();
        Weather weather = null;
        try {
            weather = weatherFetcher.getWeatherAt("Clermont-Ferrand");
        } catch (Exception e) {
            fail("Call of callAPI() should have not failed, because a good city name was passed");
        }

        assertNotNull(weather);
        assertEquals("Arrondissement de Clermont-Ferrand", weather.getName());
    }

    public void testDummyCity() {
        WeatherFetcher weatherFetcher = new WeatherFetcher();
        try {
            weatherFetcher.getWeatherAt("dummytown");
            fail("Call of callAPI() should have failed, as bad city has been given");
        } catch (Exception e) {
            assertEquals(1,1);
        }
    }


}