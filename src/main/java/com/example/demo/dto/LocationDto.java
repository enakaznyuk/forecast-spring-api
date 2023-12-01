package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationDto {

    @JsonProperty("name")
    private String city;

    @JsonProperty("localtime")
    private String localTime;

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

    @Override
    public String toString() {
        return "LocationDto{" +
                "name='" + city + '\'' +
                ", localtime='" + localTime + '\'' +
                '}';
    }
}
