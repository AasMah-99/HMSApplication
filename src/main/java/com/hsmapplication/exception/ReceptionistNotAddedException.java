package com.hsmapplication.exception;

public class ReceptionistNotAddedException extends Exception{

	public ReceptionistNotAddedException() {
	}
	public ReceptionistNotAddedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public ReceptionistNotAddedException(String message, Throwable cause) {
		super(message, cause);
	}
	public ReceptionistNotAddedException(String message) {
		super(message);
	}
	public ReceptionistNotAddedException(Throwable cause) {
		super(cause);
	}
	
	public ReceptionistNotAddedException(Long receptionistId) {
		super("Receptionist not added with id ---"+receptionistId);
	}

}
