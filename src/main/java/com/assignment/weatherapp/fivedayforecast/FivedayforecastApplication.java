package com.assignment.weatherapp.fivedayforecast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.assignment.weatherapp"})
public class FivedayforecastApplication {

    public static void main(String[] args) {
        SpringApplication.run(FivedayforecastApplication.class, args);
    }

}
