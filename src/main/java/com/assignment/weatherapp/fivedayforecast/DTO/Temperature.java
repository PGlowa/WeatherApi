package com.assignment.weatherapp.fivedayforecast.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Temperature implements Serializable {
   @JsonProperty("Maximum")
   private TemperatureDetails maximum;
   @JsonProperty("Minimum")
   private TemperatureDetails minimum;
}
