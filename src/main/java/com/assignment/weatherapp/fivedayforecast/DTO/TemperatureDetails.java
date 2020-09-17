package com.assignment.weatherapp.fivedayforecast.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@RequiredArgsConstructor
@Getter
@Setter
public class TemperatureDetails implements Serializable {
   @JsonProperty("Value")
   private Float value;
   @JsonProperty("Unit")
   private String unit;
   @JsonProperty("UnitType")
   private Integer unitType;
}
