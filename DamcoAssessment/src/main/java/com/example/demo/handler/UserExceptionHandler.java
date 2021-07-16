package com.example.demo.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.DuplicateUserFoundException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.ResponseDefObject;
import com.example.demo.utility.Util;

@RestControllerAdvice
public class UserExceptionHandler {

	/*
	 * Exception for user not found
	 */
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<ResponseDefObject<String>> userNotFoundException(UserNotFoundException exception) {
		return new ResponseEntity<ResponseDefObject<String>>(
				new ResponseDefObject<String>(HttpStatus.EXPECTATION_FAILED.value(), Util.ERROR,
						exception.getMessage()),
				HttpStatus.EXPECTATION_FAILED);
	}

	/*
	 * Exception for duplicate users
	 */
	@ExceptionHandler(value = DuplicateUserFoundException.class)
	public ResponseEntity<ResponseDefObject<String>> duplicateUserFoundException(
			DuplicateUserFoundException exception) {
		return new ResponseEntity<ResponseDefObject<String>>(
				new ResponseDefObject<String>(HttpStatus.CONFLICT.value(), Util.ERROR, exception.getMessage()),
				HttpStatus.CONFLICT);
	}
}
