package com.covid.tracker.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.covid.tracker.app.model.CovidTrackerResponse;
import com.covid.tracker.app.service.CovidTrackerService;

@RestController
@RequestMapping("/covidtracker")
public class CovidTrackerController {

	private static final Logger log = LoggerFactory.getLogger(CovidTrackerController.class);

	@Autowired
	private CovidTrackerService covidTrackerService;

	@GetMapping("/state/{code}")
	@ResponseBody
	public CovidTrackerResponse trackByStateCode(@PathVariable("code") final String stateCode) {
		log.info(" ## CovidTrackerController :: trackByStateCode :: state code :: {} ", stateCode);
		return covidTrackerService.trackByStateCode(stateCode);
	}
};