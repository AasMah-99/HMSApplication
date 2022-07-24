package com.hsmapplication.exception;

public class  PatientNotAddedException extends Exception {
	
	public PatientNotAddedException() {
	}
	public PatientNotAddedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public PatientNotAddedException(String message, Throwable cause) {
		super(message, cause);
	}
	public PatientNotAddedException(String message) {
		super(message);
	}
	public PatientNotAddedException(Throwable cause) {
		super(cause);
	}
	
	public PatientNotAddedException(Long userId) {
		super("Patient not added with id ---"+ userId);
	}

}
