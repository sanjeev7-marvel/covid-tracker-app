package com.covid.tracker.app.model;

import java.io.Serializable;

public class CovidTracker implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long positive;

	private Long negative;

	private Long death;

	private Long totalTestResults;

	public Long getPositive() {
		return positive;
	}

	public void setPositive(Long positive) {
		this.positive = positive;
	}

	public Long getNegative() {
		return negative;
	}

	public void setNegative(Long negative) {
		this.negative = negative;
	}

	public Long getTotalTestResults() {
		return totalTestResults;
	}

	public void setTotalTestResults(Long totalTestResults) {
		this.totalTestResults = totalTestResults;
	}

	public Long getDeath() {
		return death;
	}

	public void setDeath(Long death) {
		this.death = death;
	}

	public CovidTracker() {
		super();
	}

	@Override
	public String toString() {
		return "CovidTracker [positive=" + positive + ", negative=" + negative + ", death=" + death
				+ ", totalTestResults=" + totalTestResults + "]";
	}

	public CovidTracker(Long positive, Long negative, Long death, Long totalTestResults) {
		super();
		this.positive = positive;
		this.negative = negative;
		this.death = death;
		this.totalTestResults = totalTestResults;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((death == null) ? 0 : death.hashCode());
		result = prime * result + ((negative == null) ? 0 : negative.hashCode());
		result = prime * result + ((positive == null) ? 0 : positive.hashCode());
		result = prime * result + ((totalTestResults == null) ? 0 : totalTestResults.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CovidTracker other = (CovidTracker) obj;
		if (death == null) {
			if (other.death != null)
				return false;
		} else if (!death.equals(other.death))
			return false;
		if (negative == null) {
			if (other.negative != null)
				return false;
		} else if (!negative.equals(other.negative))
			return false;
		if (positive == null) {
			if (other.positive != null)
				return false;
		} else if (!positive.equals(other.positive))
			return false;
		if (totalTestResults == null) {
			if (other.totalTestResults != null)
				return false;
		} else if (!totalTestResults.equals(other.totalTestResults))
			return false;
		return true;
	}

}
