public class Main {

    public static void main(String[] args) throws Exception {
        Weather weather = null;

        if (args.length != 1) {
            System.err.println("Usage : main.java cityname");
            throw new IllegalArgumentException();
        }
        try {
            WeatherFetcher weatherFetcher = new WeatherFetcher();
            weather = weatherFetcher.getWeatherAt(args[0]);

        } catch (Exception e){


        }
        System.out.println(weather);
    }
}
