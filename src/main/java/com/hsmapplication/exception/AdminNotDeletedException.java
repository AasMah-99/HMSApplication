package com.hsmapplication.exception;

public class AdminNotDeletedException extends Exception{
	
	public AdminNotDeletedException() {
	}
	public AdminNotDeletedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public AdminNotDeletedException(String message, Throwable cause) {
		super(message, cause);
	}
	public AdminNotDeletedException(String message) {
		super(message);
	}
	public AdminNotDeletedException(Throwable cause) {
		super(cause);
	}
	
	public AdminNotDeletedException(Long adminId) {
		super("Admin not deleted with id ---"+adminId);
	}


}
