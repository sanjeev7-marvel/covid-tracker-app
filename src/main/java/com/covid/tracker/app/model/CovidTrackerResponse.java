package com.covid.tracker.app.model;

public class CovidTrackerResponse {

	private CovidTracker country;

	private CovidTracker state;

	public CovidTracker getCountry() {
		return country;
	}

	public void setCountry(CovidTracker country) {
		this.country = country;
	}

	public CovidTracker getState() {
		return state;
	}

	public void setState(CovidTracker state) {
		this.state = state;
	}

	public CovidTrackerResponse() {
		super();
	}

}
