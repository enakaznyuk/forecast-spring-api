package com.example.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Entity
public class Forecast {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "city can't be null")
    private String city;

    @NotNull(message = "date can't be null")
    private LocalDate localTime;
    private BigDecimal temperature;
    private String weatherState;
    private BigDecimal wind;
    private BigDecimal pressure;
    private BigDecimal precip;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getLocalTime() {
        return localTime;
    }

    public void setLocalTime(LocalDate localTime) {
        this.localTime = localTime;
    }

    //внутри него должна быть валидация
    public void setLocalTimeFromString(String stringLocalTime) {
        this.localTime = LocalDate.parse(stringLocalTime, DateTimeFormatter.ofPattern("yyyy-MM-dd H:mm"));
        ;
    }

    public BigDecimal getTemperature() {
        return temperature;
    }

    public void setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
    }

    public String getWeatherState() {
        return weatherState;
    }

    public void setWeatherState(String weatherState) {
        this.weatherState = weatherState;
    }

    public BigDecimal getWind() {
        return wind;
    }

    public void setWind(BigDecimal wind) {
        this.wind = wind.multiply(BigDecimal.valueOf(1000));
    }

    public BigDecimal getPressure() {
        return pressure;
    }

    public void setPressure(BigDecimal pressure) {
        this.pressure = pressure;
    }

    public BigDecimal getPrecip() {
        return precip;
    }

    public void setPrecip(BigDecimal precip) {
        this.precip = precip;
    }

    @Override
    public String toString() {
        return "ForecastNew{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", localTime=" + localTime +
                ", temperature=" + temperature +
                ", weatherState='" + weatherState + '\'' +
                ", wind=" + wind +
                ", pressure=" + pressure +
                ", precip=" + precip +
                '}';
    }
}
