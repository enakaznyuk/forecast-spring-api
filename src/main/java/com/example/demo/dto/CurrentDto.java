package com.example.demo.dto;

import com.fasterxml.jackson.annotation.*;


@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentDto {

    @JsonProperty("wind_kph")
    private String wind;

    @JsonProperty("pressure_mb")
    private String pressure;

    @JsonProperty("precip_mm")
    private String precip;

    @JsonProperty("temp_c")
    private String temperature;

    @JsonProperty("condition")
    ConditionDto condition;

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

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getCondition() {
        return condition.getWeatherState();
    }

    public void setCondition(ConditionDto conditionDto) {
        this.condition = conditionDto;
    }

    @Override
    public String toString() {
        return "CurrentDto{" +
                "windKph='" + wind + '\'' +
                ", pressureMb='" + pressure + '\'' +
                ", precipMm='" + precip + '\'' +
                ", tempC='" + temperature + '\'' +
                ", condition=" + condition +
                '}';
    }

    static class ConditionDto {

        @JsonProperty("text")
        private String weatherState;

        public String getWeatherState() {
            return weatherState;
        }

        public void setWeatherState(String weatherState) {
            this.weatherState = weatherState;
        }

        @Override
        public String toString() {
            return "ConditionDto{" +
                    "state='" + weatherState + '\'' +
                    '}';
        }
    }
}


