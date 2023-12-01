package com.example.demo.dto;

public class RapidForecastDto {

    LocationDto location;
    CurrentDto current;

    public LocationDto getLocation() {
        return location;
    }

    public void setLocation(LocationDto location) {
        this.location = location;
    }

    public CurrentDto getCurrent() {
        return current;
    }

    public void setCurrent(CurrentDto current) {
        this.current = current;
    }

    @Override
    public String toString() {
        return "RapidForecastDto{" +
                "location=" + location +
                ", current=" + current +
                '}';
    }
}
