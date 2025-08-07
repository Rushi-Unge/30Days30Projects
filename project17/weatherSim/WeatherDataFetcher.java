package project17.weatherSim;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.*;

public class WeatherDataFetcher {
    private static final String API_KEY = "97937ba315f03c96d708dc5e87131959";

    public static Weather fetchWeather(String city) throws Exception {
        String endpoint = "https://api.openweathermap.org/data/2.5/weather?q=" +
                city + "&appid=" + API_KEY + "&units=metric";
        URL url = new URL(endpoint);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(conn.getInputStream())
        );
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        JsonObject json = JsonParser.parseString(response.toString()).getAsJsonObject();
        double temp = json.getAsJsonObject("main").get("temp").getAsDouble();
        int humidity = json.getAsJsonObject("main").get("humidity").getAsInt();
        String description = json.getAsJsonArray("weather")
                                 .get(0).getAsJsonObject().get("description").getAsString();

        return new Weather(city, temp, description, humidity);
    }
}
