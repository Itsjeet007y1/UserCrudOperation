package com.example.demo.exception;

/*
 * Custom Exception for duplicate users
 */
public class DuplicateUserFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DuplicateUserFoundException() {
		super("Duplicate user found Exception occured.");
	}
}
