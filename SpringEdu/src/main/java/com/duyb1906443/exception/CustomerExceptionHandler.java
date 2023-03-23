package com.duyb1906443.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomerExceptionHandler {
	
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
	public ErrorResponse handlerException(RuntimeException exception, WebRequest request) {
		return new ErrorResponse(HttpStatus.NOT_ACCEPTABLE, exception.getMessage());
	}
	
}
