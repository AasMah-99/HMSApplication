package com.hsmapplication.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hsmapplication.exception.AppointmentNotDeletedException;
import com.hsmapplication.exception.AppointmentNotFoundException;
import com.hsmapplication.exception.DoctorNotFoundException;
import com.hsmapplication.exception.PatientNotAddedException;
import com.hsmapplication.exception.PatientNotFoundException;
import com.hsmapplication.model.Appointments;
import com.hsmapplication.model.Doctor;
import com.hsmapplication.model.User;
import com.hsmapplication.service.AppointmentService;
import com.hsmapplication.service.DoctorService;
import com.hsmapplication.service.PatientService;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
	private static final String status = "status";
	private static final String message = "message";

	@Autowired
	PatientService patientService;

	@Autowired
	DoctorService doctorService;

	@Autowired
	AppointmentService appointmentService;

	@PostMapping("/saveAppointments")
	public ResponseEntity<Map<String, Object>> addAppointments(@RequestBody Map<String, Object> body)
			throws PatientNotAddedException, ParseException, PatientNotFoundException, DoctorNotFoundException {

		DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Appointments newAppointment = new Appointments();
		newAppointment.setCreatedDate(simpleDateFormat.parse(body.get("createdDate").toString()));
		newAppointment.setUpdatedDate(simpleDateFormat.parse(body.get("updatedDate").toString()));
		newAppointment.setProblem(body.get("problem").toString());
		newAppointment.setStatus(body.get(status).toString());
		newAppointment.setAppointmentTime(LocalDate.parse(body.get("appointmentTime").toString()));
		newAppointment.setPatientName(body.get("patientName").toString());
		newAppointment.setPatientGender(body.get("patientGender").toString());
		newAppointment.setPatientDOB(simpleDateFormat.parse(body.get("patientDOB").toString()));

		Doctor doc = doctorService.getDoctorById(Long.valueOf((Integer) body.get("doctorId")));
		User user = patientService.getPatientById(Long.valueOf((Integer) body.get("userId")));

		newAppointment.setUser(user);
		newAppointment.setDoctor(doc);

		patientService.addPatient(user);
		doctorService.addDoctor(doc);

		Map<String, Object> res = new HashMap<>();
		res.put(status, true);
		res.put(message, "Appointment booked successfully!");
		res.put("data", appointmentService.addAppointments(newAppointment));
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@DeleteMapping("/appointmentdel/{appointmentId}")
	public ResponseEntity<Map<String, Object>> deleteAppointmentById(@PathVariable Long appointmentId)
			throws AppointmentNotDeletedException {
		Map<String, Object> res = new HashMap<>();
		res.put(status, true);
		res.put(message, "Appointment deleted successfully!");
		res.put("data", appointmentService.deleteAppointmentsById(appointmentId));
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@DeleteMapping("/appointmentdelete")
	public ResponseEntity<Void> deleteAppointment(Appointments appointments) throws AppointmentNotDeletedException {
		Map<String, Object> res = new HashMap<>();
		res.put(status, true);
		res.put(message, "Appointment deleted successfully!");
		res.put("data", appointmentService.deleteAppointment(appointments));
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PutMapping("/appointmentUpdate")
	public ResponseEntity<Map<String, Object>> updateAppointments(@RequestBody Map<String, Object> body)
			throws AppointmentNotFoundException, ParseException, PatientNotFoundException, PatientNotAddedException,
			DoctorNotFoundException {

		DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Appointments newAppointment = new Appointments();
		newAppointment.setAppointmentId(((Number) body.get("appointmentId")).longValue());
		newAppointment.setCreatedDate(simpleDateFormat.parse(body.get("createdDate").toString()));
		newAppointment.setUpdatedDate(simpleDateFormat.parse(body.get("updatedDate").toString()));
		newAppointment.setProblem(body.get("problem").toString());
		newAppointment.setStatus(body.get(status).toString());
		newAppointment.setAppointmentTime(LocalDate.parse(body.get("appointmentTime").toString()));
		newAppointment.setPatientName(body.get("patientName").toString());
		newAppointment.setPatientGender(body.get("patientGender").toString());
		newAppointment.setPatientDOB(simpleDateFormat.parse(body.get("patientDOB").toString()));

		Doctor doc = doctorService.getDoctorById(Long.valueOf((Integer) body.get("doctorId")));
		User user = patientService.getPatientById(Long.valueOf((Integer) body.get("userId")));

		newAppointment.setUser(user);
		newAppointment.setDoctor(doc);

		patientService.addPatient(user);
		doctorService.addDoctor(doc);

		Map<String, Object> res = new HashMap<>();
		res.put(status, true);
		res.put(message, "Appointment updated successfully!");
		res.put("data", appointmentService.updateAppointments(newAppointment));
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@GetMapping("/appointments/{appointmentId}")
	public ResponseEntity<Map<String, Object>> getAppointmentsById(@PathVariable Long appointmentId)
			throws AppointmentNotFoundException {
		Map<String, Object> res = new HashMap<>();
		res.put(status, true);
		res.put(message, "Appointments with Id!");
		res.put("data", appointmentService.getAppointmentsById(appointmentId));
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@GetMapping("/doctorId/{doctorId}")
	public ResponseEntity<Map<String, Object>> getAllAppointmentsByDocId(@PathVariable Long doctorId) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, true);
		res.put(message, "Appointments with Doctor Id!");
		res.put("data", appointmentService.getAllAppointmentsByDocId(doctorId));
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@GetMapping("/doctorName/{doctorName}")
	public ResponseEntity<Map<String, Object>> getAllAppointmentsByDocName(@PathVariable String name)
			throws AppointmentNotFoundException {
		Map<String, Object> res = new HashMap<>();
		res.put(status, true);
		res.put(message, "Appointments with Doctor Name!");
		res.put("data", appointmentService.getAllAppointmentsByDocName(name));
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

}
