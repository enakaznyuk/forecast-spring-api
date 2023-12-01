package com.example.demo.controller;

import com.example.demo.domain.Forecast;
import com.example.demo.dto.RapidForecastDto;
import com.example.demo.service.AsyncService;
import com.example.demo.service.ForecastService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
public class AsyncController {

    @Autowired
    private ForecastService forecastService;

    @Autowired
    private AsyncService asyncService;

    @Autowired
    private ModelMapper modelMapper;

    private static final Logger LOGGER = LogManager.getLogger(AsyncController.class);

    @Scheduled(cron = "@daily")
    public void fillingTheDatabase() throws InterruptedException, JsonProcessingException {

        RapidForecastDto rapidForecastDto = asyncService.getInformationAboutWeather();
        saveToDataBase(rapidForecastDto);
        LOGGER.info("Save object to DataBase");
    }

    public void saveToDataBase(RapidForecastDto rapidForecastDto) {

        Forecast forecastAfterDto = modelMapper.map(rapidForecastDto, Forecast.class);
        forecastService.addNewInfo(forecastAfterDto);
    }
}
