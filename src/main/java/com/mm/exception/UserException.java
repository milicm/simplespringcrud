package com.mm.exception;

public class UserException extends RuntimeException {

	private static final long serialVersionUID = 1187626170554416710L;

	public UserException() {
		super();
	}

	public UserException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserException(String message) {
		super(message);
	}

}
