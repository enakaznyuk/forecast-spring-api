package com.example.demo.dto;

public class ForecastOutDto {

    private String city;
    private String localTime;
    private String temperature;
    private String weatherState;
    private String wind;
    private String pressure;
    private String precip;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocalTime() {
        return localTime;
    }

    public void setLocalTime(String localTime) {
        this.localTime = localTime;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWeatherState() {
        return weatherState;
    }

    public void setWeatherState(String weatherState) {
        this.weatherState = weatherState;
    }


    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getPrecip() {
        return precip;
    }

    public void setPrecip(String precip) {
        this.precip = precip;
    }

    @Override
    public String toString() {
        return "ForecastOutDto{" +
                "city='" + city + '\'' +
                ", localTime='" + localTime + '\'' +
                ", temperature='" + temperature + '\'' +
                ", weatherState='" + weatherState + '\'' +
                ", wind='" + wind + '\'' +
                ", pressure='" + pressure + '\'' +
                ", precip='" + precip + '\'' +
                '}';
    }
}
