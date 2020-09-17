package com.assignment.weatherapp.fivedayforecast.controllers;


import com.assignment.weatherapp.fivedayforecast.DTO.DailyForecast;
import com.assignment.weatherapp.fivedayforecast.services.ForecastService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/weather")
@RequiredArgsConstructor
public class ForecastController {


    private final  ForecastService forecastService;

    @GetMapping("/fivedayforecast/{postCode}")
    public ResponseEntity<DailyForecast> getFiveDayForecast(@PathVariable("postCode") String postCode){
      return ResponseEntity.status(HttpStatus.OK).body(forecastService.getFiveDayForecast(postCode));

    }

}
