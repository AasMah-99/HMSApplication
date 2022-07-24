package com.hsmapplication.exception;

public class ReceptionistNotFoundException extends Exception{
	
	public ReceptionistNotFoundException() {
	}
	public ReceptionistNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public ReceptionistNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	public ReceptionistNotFoundException(String message) {
		super(message);
	}
	public ReceptionistNotFoundException(Throwable cause) {
		super(cause);
	}
	
	public ReceptionistNotFoundException(Long receptionistId) {
		super("Receptionist not found with id ---"+receptionistId);
	}

}
