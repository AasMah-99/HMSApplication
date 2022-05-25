package com.hsmapplication.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hsmapplication.exception.AppointmentNotFoundException;
import com.hsmapplication.exception.PatientNotAddedException;
import com.hsmapplication.model.Appointments;
import com.hsmapplication.model.User;
import com.hsmapplication.service.AppointmentService;
import com.hsmapplication.service.DoctorService;
import com.hsmapplication.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	PatientService patientService;

	@Autowired
	AppointmentService appointmentService;

	@Autowired
	DoctorService doctorService;

	private static final String status = "status";
	private static final String message = "message";

	@GetMapping()
	public ModelAndView getPatientDashboard(@ModelAttribute User patient) {
		Map<String, Object> model = new HashMap<>();
		model.put("topDoctors", doctorService.getAllDoctorsByFee());
		return new ModelAndView("patientDashboard", model);
	}

	@GetMapping("/patientReview")
	public ModelAndView getPatientReview(@ModelAttribute User patient) {
		Map<String, Object> model = new HashMap<>();
		model.put("doctors", doctorService.getAllDoctors());
		return new ModelAndView("patientReview", model);
	}

	@GetMapping("/patientTotalAppointment")
	public ModelAndView getPatientTotalAppointment(@ModelAttribute User patient) {
		return new ModelAndView("patientTotalAppointment");
	}

	@GetMapping("/patientBookAppointment")
	public ModelAndView getPatientBookAppointment(@ModelAttribute User patient) {
		Map<String, Object> model = new HashMap<>();
		model.put("doctors", doctorService.getAllDoctors());
		return new ModelAndView("patientBookAppointment", model);
	}

	@PostMapping("/savePatient")
	public ResponseEntity<Map<String, Object>> addpatient(@RequestBody User user) throws PatientNotAddedException {
		Map<String, Object> res = new HashMap<>();
		res.put(status, true);
		res.put(message, "data inserted successfully!");
		res.put("data", patientService.addPatient(user));
		return new ResponseEntity<>(res, HttpStatus.CREATED);

	}

	@GetMapping("/getRecentAppointments/{patientId}")
	public ResponseEntity<Map<String, Object>> getPatientRecentAppointments(@PathVariable Long patientId)
			throws AppointmentNotFoundException {
		Map<String, Object> res = new HashMap<>();
		res.put(status, true);
		res.put(message, "data found!");
		res.put("data", patientService.getRecentAppointments(patientId));
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@GetMapping("/appointments/{patientId}")
	public ResponseEntity<Map<String, Object>> getPatientAppointments(@PathVariable Long patientId)
			throws AppointmentNotFoundException {
		Map<String, Object> res = new HashMap<>();
		res.put(status, true);
		res.put(message, "data found!");
		res.put("data", patientService.getPatientAppointments(patientId));
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@PostMapping("/bookAppointments")
	public ResponseEntity<Map<String, Object>> addAppointments(@RequestBody Appointments appointments) {
		Map<String, Object> res = new HashMap<>();
		res.put(status, true);
		res.put(message, "Appointment booked successfully!");
		res.put("data", appointmentService.addAppointments(appointments));
		return new ResponseEntity<>(res, HttpStatus.CREATED);
	}

	@GetMapping("/recentappointments/{patientId}")
	public ResponseEntity<Appointments> getRecentAppointments(@PathVariable Long patientId)
			throws AppointmentNotFoundException {
		Map<String, Object> res = new HashMap<>();
		res.put(status, true);
		res.put(message, "Recent Appointments!");
		res.put("data", patientService.getRecentAppointments(patientId));
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
