package com.example.demo.rest;

import com.example.demo.dto.ForecastAvgOutDto;
import com.example.demo.dto.ForecastOutDto;
import com.example.demo.service.ForecastService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Validated
@RestController
@RequestMapping(path = "/demo/forecast")
public class ForecastController {

    private static final Logger LOGGER = LogManager.getLogger(ForecastController.class);

    @Autowired
    private ForecastService forecastService;

    @GetMapping
    public @ResponseBody List<ForecastOutDto> getAllForecast() {

        return forecastService.findAllForecast();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody ForecastOutDto getForecastById(@PathVariable @Valid @Min(0) Integer id) {

        ForecastOutDto forecastOutDto = forecastService.findByIdForecast(id);
        if (Objects.isNull(forecastOutDto)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Forecast not found"
            );
        }
        return forecastOutDto;
    }

    @DeleteMapping
    public void deleteAllDataBase() {
        forecastService.deleteAll();
    }

    @GetMapping(path = "/current")
    public @ResponseBody ForecastOutDto getActualInformation() {
        ForecastOutDto forecastOutDto = forecastService.getMostActualForecast();
        if (Objects.isNull(forecastOutDto)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Forecast not found"
            );
        }
        return forecastOutDto;
    }

    @GetMapping(path = "/avg")
    public @ResponseBody ForecastAvgOutDto getAvgPeriodInformation(@RequestParam LocalDate localDateStart
            , @RequestParam LocalDate localDateFinish) {
        ForecastAvgOutDto forecastAvgOutDto = forecastService.getAvgPeriod(localDateStart, localDateFinish);
        if (Objects.isNull(forecastAvgOutDto)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Forecast not found"
            );
        }
        return forecastAvgOutDto;
    }
}
