package com.assignment.weatherapp.fivedayforecast;

import com.assignment.weatherapp.fivedayforecast.DTO.DailyForecast;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FivedayforecastApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ForecastTests {

    @LocalServerPort
    private int port;


    TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    void should_return_non_empty_dailyForecast() {

        ResponseEntity<DailyForecast> fiveDayForecast = restTemplate.getForEntity(createURLWithPort("/api/v1/weather/fivedayforecast/01-236"),DailyForecast.class);

        assertEquals(HttpStatus.OK,fiveDayForecast.getStatusCode());
        assertNotNull(fiveDayForecast.getBody());
        assertFalse(fiveDayForecast.getBody().getDailyForecasts().isEmpty());
    }


    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

}
