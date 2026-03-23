package com.dreamflow.api.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dreamflow.api.exception.*;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex){
		ErrorResponse error = new ErrorResponse(ex.getMessage());
		return new ResponseEntity<> (error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserEmailAlreadyExistsException.class)
	public ResponseEntity<ErrorResponse> handleUserEmailAlreadyExistsException(UserEmailAlreadyExistsException ex){
		return new ResponseEntity<>(new ErrorResponse(ex.getMessage()),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserNameAlreadyExistsException.class)
	public ResponseEntity<ErrorResponse> handleUserNameAlreadyExistsException(UserNameAlreadyExistsException ex){
		return new ResponseEntity<>(new ErrorResponse(ex.getMessage()), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(GeneralException.class)
	public ResponseEntity<ErrorResponse> handleGeneralResponse(GeneralException ex){
		return ResponseEntity.status(400).body(new ErrorResponse(ex.getMessage()));
	}
	
}
