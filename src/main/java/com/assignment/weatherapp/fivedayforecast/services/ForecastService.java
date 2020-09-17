package com.assignment.weatherapp.fivedayforecast.services;

import com.assignment.weatherapp.fivedayforecast.DTO.DailyForecast;
import com.assignment.weatherapp.fivedayforecast.DTO.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@RequiredArgsConstructor
public class ForecastService {

    private final LocationService locationService;
    private final  RestTemplateProviderService restTemplateProviderService;
    private final MetricsService metricsService;

    @Value("${api.url}")
    String apiURL;

    @Value("${api.key}")
    String apiKey;

    final String forecastUrl = "forecasts/v1/daily/5day/{locationKey}?apikey={apiKey}&metric={metric}";

    public DailyForecast getFiveDayForecast(String postCode) {
        RestTemplate restTemplate = restTemplateProviderService.getRestTemplate();

        Location location = locationService.getLocation(postCode);
        Boolean metricSystem = true;
        DailyForecast fiveDayForecast;
        String requestUrl = apiURL + this.forecastUrl;
        try {
            metricsService.getRequestCounter().incrementAndGet();
            fiveDayForecast = restTemplate.getForObject(requestUrl, DailyForecast.class, location.getKey(), apiKey,metricSystem);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        this.setWeekdays(fiveDayForecast);

        return fiveDayForecast;

    }

    public void setWeekdays(DailyForecast fiveDayForecast) {
        if (fiveDayForecast != null && !fiveDayForecast.getDailyForecasts().isEmpty()) {
            fiveDayForecast.getDailyForecasts().forEach(weather -> {
                weather.setWeekday(weather.getDate().getDayOfWeek());
            });
        } else {
            throw new RuntimeException("No weather data available for this location");
        }
    }
}
