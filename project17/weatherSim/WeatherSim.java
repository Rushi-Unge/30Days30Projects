package project17.weatherSim;

import java.util.Scanner;

public class WeatherSim {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a city name: ");
        String city = scanner.nextLine();

        try {
            Weather weather = WeatherDataFetcher.fetchWeather(city);
            WeatherReportGenerator.printReport(weather);
        } catch (Exception e) {
            System.out.println("❌ Failed to fetch weather data: " + e.getMessage());
        }
    }
}
