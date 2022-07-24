package com.hsmapplication.exception;

public class PatientNotUpdatedException extends Exception {
	
	public PatientNotUpdatedException() {
	}
	public PatientNotUpdatedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public PatientNotUpdatedException(String message, Throwable cause) {
		super(message, cause);
	}
	public PatientNotUpdatedException(String message) {
		super(message);
	}
	public PatientNotUpdatedException(Throwable cause) {
		super(cause);
	}
	
	public PatientNotUpdatedException(Long userId) {
		super("Patient not updated with id ---"+ userId);
	}
}
