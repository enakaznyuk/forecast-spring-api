package com.example.demo;

import com.example.demo.domain.Forecast;
import com.example.demo.dto.ForecastOutDto;
import com.example.demo.dto.RapidForecastDto;
import com.example.demo.service.AsyncService;
import com.example.demo.service.ForecastService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private AsyncService asyncService;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ForecastService forecastService;

	@Test
	void shouldMappingFromRapidForecastDtoToForecastWorkCorrect() throws InterruptedException, JsonProcessingException {

		RapidForecastDto rapidForecastDto = asyncService.getInformationAboutWeather();
		Forecast forecast = modelMapper.map(rapidForecastDto, Forecast.class);
		String rapidForecastDtoDate = rapidForecastDto.getLocation().getLocalTime();
		LocalDate expectedLocalDate =  LocalDate.parse(rapidForecastDtoDate, DateTimeFormatter.ofPattern("yyyy-MM-dd H:mm"));
		String precip = rapidForecastDto.getCurrent().getPrecip();
		BigDecimal expectedPrecip = new BigDecimal(precip);
		expectedPrecip = expectedPrecip.multiply(BigDecimal.valueOf(1000));

		Assertions.assertEquals(forecast.getCity(), rapidForecastDto.getLocation().getCity());
		Assertions.assertEquals(forecast.getLocalTime(), expectedLocalDate);
		Assertions.assertEquals(forecast.getWeatherState(), rapidForecastDto.getCurrent().getCondition());
		Assertions.assertEquals(forecast.getPrecip(), expectedPrecip);
	}

	@Test
	public void shouldApiReturnNoNull() throws InterruptedException, JsonProcessingException {
		Assertions.assertNotNull(asyncService.getInformationAboutWeather());
	}

	@Test
	public void shouldMappingFromForecastToForecastDtoWorkCorrect(){

		Optional<Forecast> forecastOptional = forecastService.getMostActualInformation();
		ForecastOutDto forecastOutDto = forecastService.getMostActualForecast();
		Forecast expectedForecast;
		if(forecastOptional.isPresent())
			expectedForecast = forecastOptional.get();
		else throw new NullPointerException();

		String date = expectedForecast.getLocalTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String precip = String.valueOf(expectedForecast.getPrecip());

		Assertions.assertEquals(forecastOutDto.getCity(), expectedForecast.getCity());
		Assertions.assertEquals(forecastOutDto.getWeatherState(), expectedForecast.getWeatherState());
		Assertions.assertEquals(forecastOutDto.getLocalTime(), date);
		Assertions.assertEquals(forecastOutDto.getPrecip(), precip);
	}

}
