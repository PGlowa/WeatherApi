package com.assignment.weatherapp.fivedayforecast.DTO;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.ZonedDateTime;


@Getter
@Setter
public class WeatherDetails implements Serializable {
    @JsonProperty("Date")
    private ZonedDateTime date;
    @JsonProperty("Temperature")
    private Temperature temperature;

    private DayOfWeek weekday;
}
