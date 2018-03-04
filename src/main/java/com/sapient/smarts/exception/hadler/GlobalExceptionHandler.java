package com.sapient.smarts.exception.hadler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
/**
 * Default Global Exception Handler skelton class, Please provide custom implemetation.
 * 
 * @author vbha12
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler  {


	
	@ExceptionHandler({ Exception.class })
	@ResponseBody
	public ResponseEntity<?> handleAnyException(Exception e) {
		
		return null;
		
	}

	
	protected <T> ResponseEntity<T> response(T body, HttpStatus status) {
		return new ResponseEntity<>(body, new HttpHeaders(), status);
	}

}