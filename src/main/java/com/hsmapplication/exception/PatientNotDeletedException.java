package com.hsmapplication.exception;

public class PatientNotDeletedException extends Exception{
	
	public PatientNotDeletedException() {
	}
	public PatientNotDeletedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public PatientNotDeletedException(String message, Throwable cause) {
		super(message, cause);
	}
	public PatientNotDeletedException(String message) {
		super(message);
	}
	public PatientNotDeletedException(Throwable cause) {
		super(cause);
	}
	
	public PatientNotDeletedException(Long userId) {
		super("Patient not deleted with id ---"+ userId);
	}
}
