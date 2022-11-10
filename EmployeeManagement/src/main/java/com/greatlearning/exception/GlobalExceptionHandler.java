package com.greatlearning.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(IllegalArgumentException.class)
	public String handleInvalidEmployeeId(IllegalArgumentException e) {
		return "invalid Book id passed";
	}
}
