package com.assignment.weatherapp.fivedayforecast.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class Location implements Serializable {
    @JsonProperty("Key")
    String key;
    @JsonProperty("englishName")
    String EnglishName;
}
