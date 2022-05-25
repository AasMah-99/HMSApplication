package com.hsmapplication.exception;

public class AppointmentNotFoundException extends Exception{
	
	public AppointmentNotFoundException() {
	}
	public AppointmentNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public AppointmentNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	public AppointmentNotFoundException(String message) {
		super(message);
	}
	public AppointmentNotFoundException(Throwable cause) {
		super(cause);
	}
	
	public AppointmentNotFoundException(Long appointmentId) {
		super("Appointment not found with id ---"+appointmentId);
	}

}
