package com.centime.application.exception;

public class DuplicateUserException extends Exception {

	private static final long serialVersionUID = 1L;

	public DuplicateUserException() {
		super();
	}

	public DuplicateUserException(String message, Throwable cause) {
		super(message, cause);
	}

	public DuplicateUserException(String message) {
		super(message);
	}
}
