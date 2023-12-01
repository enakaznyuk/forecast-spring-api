package com.example.demo;

import com.example.demo.domain.Forecast;
import com.example.demo.dto.RapidForecastDto;
import com.example.demo.repository.ForecastRepository;
import com.example.demo.rest.ForecastController;
import com.example.demo.service.AsyncService;
import com.example.demo.service.ForecastService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;
import org.powermock.api.mockito.PowerMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.BeforeMethod;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private AsyncService asyncService;

	@Autowired
	private ModelMapper modelMapper;

	@Test
	void shouldMappingWorkCorrect() throws InterruptedException, JsonProcessingException {

		RapidForecastDto rapidForecastDto = asyncService.getInformationAboutWeather();
		Forecast forecast = modelMapper.map(rapidForecastDto, Forecast.class);

		//поменять местами
		Assertions.assertEquals(forecast.getCity(), rapidForecastDto.getLocation().getCity());

		String str = rapidForecastDto.getLocation().getLocalTime();
		LocalDate excpectedLocalDate =  LocalDate.parse(str, DateTimeFormatter.ofPattern("yyyy-MM-dd H:mm"));

		Assertions.assertEquals(forecast.getLocalTime(), excpectedLocalDate);


		/*Assertions.assertEquals(rapidForecastDto.getCurrent().getCondition(), forecast.getWeatherState());
		Assertions.assertEquals(rapidForecastDto.getCurrent().getPrecip(), forecast.getPrecip());
		Assertions.assertEquals(rapidForecastDto.getCurrent().getPressure(), forecast.getPressure());
		Assertions.assertEquals(rapidForecastDto.getCurrent().getTemperature(), forecast.getTemperature());
		Assertions.assertEquals(rapidForecastDto.getCurrent().getWind(), forecast.getWind());*/
	}

	@Test
	public void shouldApiReturnNoNull() throws InterruptedException, JsonProcessingException {
		Assertions.assertNotNull(asyncService.getInformationAboutWeather());
	}

	//можно сделать чтобы например findall возвращал null(замокать)
	@Test
	public void voidasdf(){

	}

}
