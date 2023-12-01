package com.example.demo.service;

import com.example.demo.domain.Forecast;
import com.example.demo.dto.ForecastAvgOutDto;
import com.example.demo.dto.ForecastOutDto;
import com.example.demo.repository.ForecastAverage;
import com.example.demo.repository.ForecastRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class ForecastService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ForecastRepository forecastRepository;

    public void addNewInfo(Forecast n) {
        forecastRepository.save(n);
    }

    public Iterable<Forecast> findAll() {

        return forecastRepository.findAll();
    }

    public List<ForecastOutDto> findAllForecast() {

        Iterable<Forecast> forecasts = findAll();
        List<Forecast> forecastList = StreamSupport.stream(forecasts.spliterator(), false).toList();
        return forecastList.stream().map(v -> modelMapper.map(v, ForecastOutDto.class)).toList();
    }

    public Optional<Forecast> findById(Integer id) {

        return forecastRepository.findById(id);
    }

    public ForecastOutDto findByIdForecast(Integer id) {

        Optional<Forecast> forecast = findById(id);
        return forecast.map(value -> modelMapper.map(value, ForecastOutDto.class)).orElse(null);
    }

    public void deleteAll() {

        forecastRepository.deleteAll();
    }

    public Optional<Forecast> getMostActualInformation() {

        return forecastRepository.getMostValueInformation();
    }

    public ForecastOutDto getMostActualForecast() {

        Optional<Forecast> forecast = getMostActualInformation();
        return forecast.map(value -> modelMapper.map(value, ForecastOutDto.class)).orElse(null);
    }

    public ForecastAvgOutDto getAvgPeriod(LocalDate localDateStart, LocalDate localDateFinish) {

        ForecastAverage forecastAverage = forecastRepository.getAvgByDateBetween(localDateStart, localDateFinish);
        return Objects.nonNull(forecastAverage.getTemperature()) ? modelMapper.map(forecastAverage, ForecastAvgOutDto.class) : null;
    }
}
