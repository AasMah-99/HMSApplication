package com.hsmapplication.exception;

public class ReceptionistNotUpdatedException extends Exception {
	
	public ReceptionistNotUpdatedException() {
	}
	public ReceptionistNotUpdatedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public ReceptionistNotUpdatedException(String message, Throwable cause) {
		super(message, cause);
	}
	public ReceptionistNotUpdatedException(String message) {
		super(message);
	}
	public ReceptionistNotUpdatedException(Throwable cause) {
		super(cause);
	}
	
	public ReceptionistNotUpdatedException(Long receptionistId) {
		super("Receptionist not updated with id ---"+receptionistId);
	}

}
