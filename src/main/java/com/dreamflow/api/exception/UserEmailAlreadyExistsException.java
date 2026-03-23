package com.dreamflow.api.exception;

public class UserEmailAlreadyExistsException extends RuntimeException{
	public UserEmailAlreadyExistsException(String message) {
		super(message);
	}
}
