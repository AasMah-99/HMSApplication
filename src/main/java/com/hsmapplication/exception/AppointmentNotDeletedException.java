package com.hsmapplication.exception;

public class AppointmentNotDeletedException extends Exception {

	public AppointmentNotDeletedException() {
	}

	public AppointmentNotDeletedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AppointmentNotDeletedException(String message, Throwable cause) {
		super(message, cause);
	}

	public AppointmentNotDeletedException(String message) {
		super(message);
	}

	public AppointmentNotDeletedException(Throwable cause) {
		super(cause);
	}

	public AppointmentNotDeletedException(Long appointmentId) {
		super("Appointment not deleted for id ---" + appointmentId);
	}

}
