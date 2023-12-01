package com.example.demo.repository;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface ForecastCurrent {

     String getCity();
     LocalDate getLocalTime();
     BigDecimal getTemperature();
     String getWeatherState();
     BigDecimal getWind();
     BigDecimal getPressure();
     BigDecimal getPrecip();
}
