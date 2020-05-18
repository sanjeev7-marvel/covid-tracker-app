package com.covid.tracker.app.exception;

import java.time.LocalDateTime;

public class ErrorMessage {

	private LocalDateTime timeStamp;

	private int status;

	private String message;

	public ErrorMessage(LocalDateTime timeStamp, int status, String message) {
		super();
		this.timeStamp = timeStamp;
		this.status = status;
		this.message = message;
	}

	public ErrorMessage() {
		super();
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
