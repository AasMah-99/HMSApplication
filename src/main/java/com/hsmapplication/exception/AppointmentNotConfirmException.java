package com.hsmapplication.exception;

public class AppointmentNotConfirmException extends Exception {
	
	public AppointmentNotConfirmException() {
	}
	public AppointmentNotConfirmException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public AppointmentNotConfirmException(String message, Throwable cause) {
		super(message, cause);
	}
	public AppointmentNotConfirmException(String message) {
		super(message);
	}
	public AppointmentNotConfirmException(Throwable cause) {
		super(cause);
	}
	
	public AppointmentNotConfirmException(Long appointmentId) {
		super("Appointment not confirmed for id ---"+ appointmentId);
	}

}
