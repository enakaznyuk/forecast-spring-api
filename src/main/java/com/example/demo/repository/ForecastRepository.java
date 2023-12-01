package com.example.demo.repository;

import com.example.demo.domain.Forecast;
import com.example.demo.dto.ForecastOutDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public interface ForecastRepository extends CrudRepository<Forecast, Integer> {

    //переделать запрос на лимит 1
    @Query(value = "SELECT * FROM forecast where local_time = (select MAX(local_time) from forecast) limit 1", nativeQuery = true)
    Optional<Forecast> getMostValueInformation();


    @Query(value = "select avg(f.temperature) as temperature, avg(f.wind) as wind, avg(f.pressure) as pressure, avg(f.precip) as precip from Forecast f where localTime between :from and :to")
    ForecastAverage getAvgByDateBetween(LocalDate from, LocalDate to);
}