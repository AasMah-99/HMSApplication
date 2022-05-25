package com.hsmapplication.exception;

public class DoctorNotUpdatedException extends Exception {

	public DoctorNotUpdatedException() {
	}
	public DoctorNotUpdatedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public DoctorNotUpdatedException(String message, Throwable cause) {
		super(message, cause);
	}
	public DoctorNotUpdatedException(String message) {
		super(message);
	}
	public DoctorNotUpdatedException(Throwable cause) {
		super(cause);
	}
	
	public DoctorNotUpdatedException(Long doctorId) {
		super("Doctor not updated with id ---"+doctorId);
	}

}
