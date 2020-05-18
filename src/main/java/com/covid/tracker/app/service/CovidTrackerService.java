package com.covid.tracker.app.service;

import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.covid.tracker.app.exception.DataNotFoundException;
import com.covid.tracker.app.model.CovidTracker;
import com.covid.tracker.app.model.CovidTrackerResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

@Service
public class CovidTrackerService {

	private static final Logger log = LoggerFactory.getLogger(CovidTrackerService.class);

	@Value("${covid.track.country.url}")
	private String trackByCountryUrl;

	@Value("${covid.track.states.url}")
	private String trackByStatesUrl;

	@Autowired
	private RestTemplate restTemplate;

	private Gson gson = new Gson();

	public CovidTrackerResponse trackByStateCode(String stateCode) {
		log.info(" ## CovidTrackerService :: trackByStateCode :: {} ", stateCode);
		CovidTrackerResponse response = new CovidTrackerResponse();
		try {
			response.setCountry(getCovidTrackerData(trackByCountryUrl, true));
			response.setState(getCovidTrackerData(MessageFormat.format(trackByStatesUrl, stateCode), false));
			return response;
		} catch (Exception exception) {
			log.info(
					" ## Exception occurred at CovidTrackerService :: trackByStateCode :: stateCode :: {} , exception {} ",
					stateCode, exception.getMessage());
			throw exception;
		}
	}

	private CovidTracker getCovidTrackerData(final String url, boolean isArray) {
		try {
			log.info(" ##CovidTrackerService :: url :: {} ", url);
			ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
			if (responseEntity != null && (responseEntity.getStatusCodeValue() == HttpStatus.ACCEPTED.value()
					|| responseEntity.getStatusCodeValue() == HttpStatus.OK.value())) {
				if (isArray) {
					JsonArray jsonArray = JsonParser.parseString(responseEntity.getBody()).getAsJsonArray();
					return gson.fromJson(jsonArray.get(0), CovidTracker.class);
				}
				return gson.fromJson(responseEntity.getBody(), CovidTracker.class);
			} else {
				throw new DataNotFoundException(" Unable to retrieve covid tracker data ");
			}
		} catch (Exception exception) {
			log.info(
					" ## Exception occurred at CovidTrackerService :: getCovidTrackerData :: url :: {} , exception {} ",
					url, exception.getMessage());
			throw exception;

		}
	}
}