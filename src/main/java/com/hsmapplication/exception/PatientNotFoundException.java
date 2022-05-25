package com.hsmapplication.exception;

public class PatientNotFoundException extends Exception {
	
	public PatientNotFoundException() {
	}
	public PatientNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public PatientNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	public PatientNotFoundException(String message) {
		super(message);
	}
	public PatientNotFoundException(Throwable cause) {
		super(cause);
	}
	
	public PatientNotFoundException(Long userId) {
		super("Patient not found with id ---"+ userId);
	}
}