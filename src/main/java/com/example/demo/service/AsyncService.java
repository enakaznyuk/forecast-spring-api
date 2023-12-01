package com.example.demo.service;

import com.example.demo.controller.AsyncController;
import com.example.demo.dto.RapidForecastDto;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.antlr.v4.runtime.misc.NotNull;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reactor.util.annotation.NonNull;

@Service
public class AsyncService {

    private static final Logger LOGGER = LogManager.getLogger(AsyncService.class);

    private final RestTemplate restTemplate;

    public AsyncService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Async("threadPoolTaskExecutor")
    public RapidForecastDto getInformationAboutWeather() throws InterruptedException, JsonProcessingException {
        LOGGER.info("Looking up ");
        String url = "https://weatherapi-com.p.rapidapi.com/current.json?q=Minsk";

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", "27d4872e5fmsh88d6ca904f8ed2ep102404jsn06d11cc380e9");
        headers.set("X-RapidAPI-Host", "weatherapi-com.p.rapidapi.com");
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<RapidForecastDto> results = restTemplate.exchange(url, HttpMethod.GET, requestEntity, RapidForecastDto.class);
        return results.getBody();
    }


}
