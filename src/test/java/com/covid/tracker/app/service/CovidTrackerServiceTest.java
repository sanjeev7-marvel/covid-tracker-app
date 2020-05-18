package com.covid.tracker.app.service;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import com.covid.tracker.app.model.CovidTrackerResponse;

@RunWith(MockitoJUnitRunner.class)
public class CovidTrackerServiceTest {

	private CovidTrackerService covidTrackerService = new CovidTrackerService();

	@Test
	public void trackByStateCodeTest_country() throws IOException {
		RestTemplate restTemplate = Mockito.mock(RestTemplate.class);

		ReflectionTestUtils.setField(covidTrackerService, "restTemplate", restTemplate);
		ReflectionTestUtils.setField(covidTrackerService, "trackByCountryUrl",
				"https://covidtracking.com/api/v1/us/current.json");
		ReflectionTestUtils.setField(covidTrackerService, "trackByStatesUrl",
				"https://covidtracking.com/api/v1/states/{0}/current.json");

		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("country-output.json").getFile());
		String countryOutput = new String(Files.readAllBytes(file.toPath()));

		file = new File(classLoader.getResource("state-output.json").getFile());
		String stateOutput = new String(Files.readAllBytes(file.toPath()));

		Mockito.when(restTemplate.getForObject(Mockito.anyString(), Mockito.any())).thenReturn(countryOutput);

		CovidTrackerResponse response = covidTrackerService.trackByStateCode("MI");
		assertNotNull(response);

	}

};