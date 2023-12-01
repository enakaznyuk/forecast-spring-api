package com.example.demo.repository;

import java.math.BigDecimal;

public interface ForecastAverage {

    BigDecimal getTemperature();

    BigDecimal getWind();

    BigDecimal getPressure();

    BigDecimal getPrecip();
}
