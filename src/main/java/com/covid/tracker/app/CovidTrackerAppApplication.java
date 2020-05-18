package com.covid.tracker.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class CovidTrackerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CovidTrackerAppApplication.class, args);
	}

}
