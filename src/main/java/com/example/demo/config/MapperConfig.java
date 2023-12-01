package com.example.demo.config;

import com.example.demo.domain.Forecast;
import com.example.demo.dto.ForecastAvgOutDto;
import com.example.demo.dto.RapidForecastDto;
import com.example.demo.repository.ForecastAverage;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper getMapper() {

        ModelMapper modelMapper = new ModelMapper();

        modelMapper.typeMap(RapidForecastDto.class, Forecast.class).addMappings(mapper -> {
            mapper.map(src -> src.getLocation().getCity(),
                    Forecast::setCity);
            mapper.map(src -> src.getCurrent().getCondition(),
                    Forecast::setWeatherState);
            mapper.map(src -> src.getLocation().getLocalTime(),
                    Forecast::setLocalTimeFromString);
            mapper.map(src -> src.getCurrent().getWind(),
                    Forecast::setWind);
            mapper.map(src -> src.getCurrent().getPressure(),
                    Forecast::setPressure);
            mapper.map(src -> src.getCurrent().getPrecip(),
                    Forecast::setPrecip);
            mapper.map(src -> src.getCurrent().getTemperature(),
                    Forecast::setTemperature);
        });
        modelMapper.typeMap(ForecastAverage.class, ForecastAvgOutDto.class).implicitMappings();
        return modelMapper;
    }
}
