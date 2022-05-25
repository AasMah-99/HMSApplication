package com.hsmapplication.exception;

public class DoctorNotDeletedException extends Exception {
	
	public DoctorNotDeletedException() {
	}
	public DoctorNotDeletedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public DoctorNotDeletedException(String message, Throwable cause) {
		super(message, cause);
	}
	public DoctorNotDeletedException(String message) {
		super(message);
	}
	public DoctorNotDeletedException(Throwable cause) {
		super(cause);
	}
	
	public DoctorNotDeletedException(Long doctorId) {
		super("Doctor not deleted with id ---"+doctorId);
	}
}
