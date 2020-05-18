package com.covid.tracker.app.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CovidExceptionControllerAdvice {

	@ExceptionHandler(DataNotFoundException.class)
	public ErrorMessage handleDataNotFoundException(DataNotFoundException exception) {
		return new ErrorMessage(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), exception.getLocalizedMessage());
	}

	@ExceptionHandler(Exception.class)
	public ErrorMessage handleException(DataNotFoundException exception) {
		return new ErrorMessage(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
				exception.getLocalizedMessage());
	}

}