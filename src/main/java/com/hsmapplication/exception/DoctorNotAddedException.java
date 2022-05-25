package com.hsmapplication.exception;

public class DoctorNotAddedException extends Exception{

	public DoctorNotAddedException() {
	}
	public DoctorNotAddedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public DoctorNotAddedException(String message, Throwable cause) {
		super(message, cause);
	}
	public DoctorNotAddedException(String message) {
		super(message);
	}
	public DoctorNotAddedException(Throwable cause) {
		super(cause);
	}
	
	public DoctorNotAddedException(Long doctorId) {
		super("Doctor not added with id ---"+doctorId);
	}
}