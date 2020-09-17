package com.assignment.weatherapp.fivedayforecast.controllers;

import com.assignment.weatherapp.fivedayforecast.services.MetricsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/api/v1/metrics")
@RequiredArgsConstructor
public class MetricsController {

   private final MetricsService metricsService;

    @GetMapping("/requests")
    public AtomicInteger getApiRequestsCount(){
        return metricsService.getRequestCounter();
    }


}
