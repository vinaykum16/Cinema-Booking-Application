package com.MovieBooking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
	
import com.MovieBooking.response.ApiMassageResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiMassageResponse> movieNotFoundExceptionHandler(ResourceNotFoundException ex){
		
		String message = ex.getMessage();
		ApiMassageResponse apiMessage = new ApiMassageResponse(message);
		return new ResponseEntity<ApiMassageResponse>(apiMessage, HttpStatus.NOT_FOUND);

	}

}
