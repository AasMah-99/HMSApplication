package com.hsmapplication.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hsmapplication.exception.AdminNotAddedException;
import com.hsmapplication.exception.AdminNotDeletedException;
import com.hsmapplication.exception.AdminNotFoundException;
import com.hsmapplication.exception.AdminNotUpdatedException;
import com.hsmapplication.exception.AppointmentNotConfirmException;
import com.hsmapplication.exception.AppointmentNotDeletedException;
import com.hsmapplication.exception.AppointmentNotFoundException;
import com.hsmapplication.exception.DoctorNotAddedException;
import com.hsmapplication.exception.DoctorNotDeletedException;
import com.hsmapplication.exception.DoctorNotFoundException;
import com.hsmapplication.exception.DoctorNotUpdatedException;
import com.hsmapplication.exception.PatientNotAddedException;
import com.hsmapplication.exception.PatientNotDeletedException;
import com.hsmapplication.exception.PatientNotFoundException;
import com.hsmapplication.exception.PatientNotUpdatedException;
import com.hsmapplication.exception.ReceptionistNotAddedException;
import com.hsmapplication.exception.ReceptionistNotDeletedException;
import com.hsmapplication.exception.ReceptionistNotFoundException;
import com.hsmapplication.exception.ReceptionistNotUpdatedException;

@RestControllerAdvice
public class ApplicationExceptionControllerAdvice {

	private static final String status = "status";
	private static final String message = "message";

	@ExceptionHandler(AdminNotFoundException.class)
	public ResponseEntity<Map<String, Object>> adminNotFoundHandler(AdminNotFoundException anf) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, anf.getMessage());
		return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AdminNotAddedException.class)
	public ResponseEntity<Map<String, Object>> adminNotAddedHandler(AdminNotAddedException anax) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, anax.getMessage());
		return new ResponseEntity<>(res, HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(AdminNotUpdatedException.class)
	public ResponseEntity<Map<String, Object>> adminNotUpdatedHandler(AdminNotUpdatedException anux) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, anux.getMessage());
		return new ResponseEntity<>(res, HttpStatus.NOT_MODIFIED);
	}

	@ExceptionHandler(AdminNotDeletedException.class)
	public ResponseEntity<Map<String, Object>> adminNotDeletedHandler(AdminNotDeletedException andx) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, andx.getMessage());
		return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(DoctorNotFoundException.class)
	public ResponseEntity<Map<String, Object>> doctorNotFoundHandler(DoctorNotFoundException dnfx) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, dnfx.getMessage());
		return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DoctorNotAddedException.class)
	public ResponseEntity<Map<String, Object>> doctorNotAddedHandler(DoctorNotAddedException dnax) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, dnax.getMessage());
		return new ResponseEntity<>(res, HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(DoctorNotUpdatedException.class)
	public ResponseEntity<Map<String, Object>> doctorNotUpdatedHandler(DoctorNotUpdatedException dnux) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, dnux.getMessage());
		return new ResponseEntity<>(res, HttpStatus.NOT_MODIFIED);
	}

	@ExceptionHandler(DoctorNotDeletedException.class)
	public ResponseEntity<Map<String, Object>> doctorNotDeletedHandler(DoctorNotDeletedException dndx) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, dndx.getMessage());
		return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(PatientNotFoundException.class)
	public ResponseEntity<Map<String, Object>> patientNotFoundHandler(PatientNotFoundException pnfx) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, pnfx.getMessage());
		return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(PatientNotAddedException.class)
	public ResponseEntity<Map<String, Object>> patientNotAddedHandler(PatientNotAddedException pnax) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, pnax.getMessage());
		return new ResponseEntity<>(res, HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(PatientNotUpdatedException.class)
	public ResponseEntity<Map<String, Object>> patientNotUpdatedHandler(PatientNotUpdatedException pnux) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, pnux.getMessage());
		return new ResponseEntity<>(res, HttpStatus.NOT_MODIFIED);
	}

	@ExceptionHandler(PatientNotDeletedException.class)
	public ResponseEntity<Map<String, Object>> patientNotDeletedHandler(PatientNotDeletedException pndx) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, pndx.getMessage());
		return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ReceptionistNotFoundException.class)
	public ResponseEntity<Map<String, Object>> receptionistNotFoundHandler(ReceptionistNotFoundException rnfx) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, rnfx.getMessage());
		return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ReceptionistNotAddedException.class)
	public ResponseEntity<Map<String, Object>> receptionistNotAddedHandler(ReceptionistNotAddedException rnax) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, rnax.getMessage());
		return new ResponseEntity<>(res, HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(ReceptionistNotUpdatedException.class)
	public ResponseEntity<Map<String, Object>> receptionistNotUpdatedHandler(ReceptionistNotUpdatedException rnux) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, rnux.getMessage());
		return new ResponseEntity<>(res, HttpStatus.NOT_MODIFIED);
	}

	@ExceptionHandler(ReceptionistNotDeletedException.class)
	public ResponseEntity<Map<String, Object>> receptionistNotDeletedHandler(ReceptionistNotDeletedException rndx) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, rndx.getMessage());
		return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(AppointmentNotFoundException.class)
	public ResponseEntity<Map<String, Object>> appointmentNotFoundHandler(AppointmentNotFoundException apnfx) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, apnfx.getMessage());
		return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AppointmentNotDeletedException.class)
	public ResponseEntity<Map<String, Object>> appointmentNotDeletedHanldler(AppointmentNotDeletedException andx) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, andx.getMessage());
		return new ResponseEntity<>(res, HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(AppointmentNotConfirmException.class)
	public ResponseEntity<Map<String, Object>> appointmentNotConfirmHanldler(AppointmentNotConfirmException ancx) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, false);
		res.put(message, ancx.getMessage());
		return new ResponseEntity<>(res, HttpStatus.NOT_ACCEPTABLE);
	}

}
