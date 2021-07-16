package com.example.demo.exception;

/*
 * Custom exception if user not found
 */
public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserNotFoundException() {
		super("User does not exit exception occured.");
	}
}
