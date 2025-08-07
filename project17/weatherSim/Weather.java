
package project17.weatherSim;
public class Weather {
    private String city;
    private double temperature;
    private String description;
    private int humidity;

    public Weather(String city, double temperature, String description, int humidity) {
        this.city = city;
        this.temperature = temperature;
        this.description = description;
        this.humidity = humidity;
    }


    public String getCity() {
        return city;
    }

    public double getTemperature() {
        return temperature;
    }

    public String getDescription() {
        return description;
    }

    public int getHumidity() {
        return humidity;
    }
}
