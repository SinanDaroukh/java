public class Main {

    public static void main(String[] args) {
        Weather weather = null;

        if (args.length != 1) {
            System.err.println("Usage : main.java cityname");
            throw new IllegalArgumentException();
        }
        try {
            WeatherFetcher weatherFetcher = new WeatherFetcher();
            weather = weatherFetcher.getWeatherAt(args[0]);

        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(weather);
    }
}
