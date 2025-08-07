package project17.weatherSim;

public class WeatherReportGenerator {
    public static void printReport(Weather weather) {
        System.out.println("📍 Weather Report for " + weather.getCity());
        System.out.println("----------------------------------");
        System.out.println("🌡️ Temperature: " + weather.getTemperature() + "°C");
        System.out.println("💧 Humidity: " + weather.getHumidity() + "%");
        System.out.println("🌥️ Condition: " + weather.getDescription());
        System.out.println("----------------------------------");
    }
}
