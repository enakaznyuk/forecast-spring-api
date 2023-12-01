package com.example.demo.dto;

public class ForecastAvgOutDto {

    private String temperature;
    private String wind;
    private String pressure;
    private String precip;

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
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
        return "ForecastAvgOutDto{" +
                "temperature='" + temperature + '\'' +
                ", wind='" + wind + '\'' +
                ", pressure='" + pressure + '\'' +
                ", precip='" + precip + '\'' +
                '}';
    }
}
