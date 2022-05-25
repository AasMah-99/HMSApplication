package com.hsmapplication.exception;

public class ReceptionistNotDeletedException extends Exception{
	
	public ReceptionistNotDeletedException() {
	}
	public ReceptionistNotDeletedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public ReceptionistNotDeletedException(String message, Throwable cause) {
		super(message, cause);
	}
	public ReceptionistNotDeletedException(String message) {
		super(message);
	}
	public ReceptionistNotDeletedException(Throwable cause) {
		super(cause);
	}
	
	public ReceptionistNotDeletedException(Long receptionistId) {
		super("Receptionist not deleted with id ---"+receptionistId);
	}

}
