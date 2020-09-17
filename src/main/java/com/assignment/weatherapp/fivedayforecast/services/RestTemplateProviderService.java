package com.assignment.weatherapp.fivedayforecast.services;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Getter
public class RestTemplateProviderService {
   private final RestTemplate restTemplate = new RestTemplate();


}
