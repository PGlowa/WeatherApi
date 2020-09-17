package com.assignment.weatherapp.fivedayforecast.services;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
@Getter
@Setter
public class MetricsService {
    private AtomicInteger requestCounter = new AtomicInteger(0);
}
