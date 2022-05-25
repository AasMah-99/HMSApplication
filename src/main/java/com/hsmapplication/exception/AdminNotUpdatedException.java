package com.hsmapplication.exception;

public class AdminNotUpdatedException extends Exception{
	
	public AdminNotUpdatedException() {
	}
	public AdminNotUpdatedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public AdminNotUpdatedException(String message, Throwable cause) {
		super(message, cause);
	}
	public AdminNotUpdatedException(String message) {
		super(message);
	}
	public AdminNotUpdatedException(Throwable cause) {
		super(cause);
	}
	
	public AdminNotUpdatedException(Long adminId) {
		super("Admin not updated with id ---"+adminId);
	}

}
