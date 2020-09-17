package com.assignment.weatherapp.fivedayforecast.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
@Getter
@Setter
public class DailyForecast implements Serializable {
   @JsonProperty("DailyForecasts")
   private List<WeatherDetails> dailyForecasts;
}
