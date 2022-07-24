package com.hsmapplication.exception;

public class AdminNotFoundException extends Exception {
	
	public AdminNotFoundException() {
	}

	public AdminNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AdminNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public AdminNotFoundException(String message) {
		super(message);
	}

	public AdminNotFoundException(Throwable cause) {
		super(cause);
	}

	public AdminNotFoundException(Long adminId) {
		super("Admin not found with id ---" + adminId);
	}

}
