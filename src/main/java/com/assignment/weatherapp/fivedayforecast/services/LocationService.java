package com.assignment.weatherapp.fivedayforecast.services;

import com.assignment.weatherapp.fivedayforecast.DTO.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class LocationService {

    @Value("${api.url}")
    String apiURL;

    @Value("${api.key}")
    String apiKey;

    private final RestTemplateProviderService restTemplateProviderService;
    private final MetricsService metricsService;

    final String locationUrl ="locations/v1/search?apikey={apikey}&q={q}";

    public Location getLocation(String postCode)  {
        RestTemplate restTemplate = restTemplateProviderService.getRestTemplate();
        String requestUrl = apiURL + this.locationUrl;
        Location[] locationInfo;
        try{
            metricsService.getRequestCounter().incrementAndGet();
            locationInfo = restTemplate.getForObject(requestUrl,Location[].class,apiKey,postCode);
        } catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

        Optional<Location> optionalLocationInfo = Optional.ofNullable(locationInfo).flatMap(list -> Arrays.stream(list).findFirst());

        return optionalLocationInfo.orElseThrow(() ->new RuntimeException("Location Not Found"));



    }

}
