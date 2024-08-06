package com.PlayMarker.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	 @ExceptionHandler(Exception.class)
	    public ResponseEntity<String> handleAllExceptions(Exception ex) {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	 
	 @ExceptionHandler(GroundFilledException.class)
	 public ResponseEntity<String> groundFilledException(GroundFilledException ex){ 
		 return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	 }


}
