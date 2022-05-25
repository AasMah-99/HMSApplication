package com.hsmapplication.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hsmapplication.exception.DoctorNotDeletedException;
import com.hsmapplication.exception.DoctorNotFoundException;
import com.hsmapplication.exception.DoctorNotUpdatedException;
import com.hsmapplication.model.Doctor;
import com.hsmapplication.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	private static final String status = "status";
	private static final String message = "message";

	@GetMapping()
	public ModelAndView getDoctorDashboard() {
		return new ModelAndView("doctorDashboard");
	}

	@GetMapping("/doctorAppointmentList")
	public ModelAndView getDoctorAppointmentList() {
		return new ModelAndView("doctorAppointmentList");
	}

	@GetMapping("/doctorPatientList")
	public ModelAndView getDoctorPatientList() {
		return new ModelAndView("doctorPatientList");
	}

	@GetMapping("/doctorProfile")
	public ModelAndView getDoctorProfile() {
		return new ModelAndView("doctorProfile");
	}

	@GetMapping("/getDoctor")
	public ResponseEntity<Map<String, Object>> getDoctor(@RequestBody Map<String, Object> body)
			throws DoctorNotFoundException {
		Map<String, Object> res = new HashMap<>();
		res.put(status, true);
		res.put(message, "data found!");
		res.put("data", doctorService.getDoctor(body.get("email").toString(), body.get("password").toString()));
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@PostMapping("/changeStatus/{doctorId}")
	public ResponseEntity<Map<String, Object>> changeDoctorStatus(@PathVariable Long doctorId)
			throws DoctorNotUpdatedException, DoctorNotFoundException {

		Doctor doc = doctorService.getDoctorById(doctorId);
		doc.setStatus(false);

		Map<String, Object> res = new HashMap<>();
		res.put(status, true);
		res.put(message, "data found!");
		res.put("data", doctorService.updateDoctor(doc));
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@GetMapping("/getDoctor/{docId}")
	public ResponseEntity<Map<String, Object>> getDoctorById(@PathVariable Long docId) throws DoctorNotFoundException {
		Map<String, Object> res = new HashMap<>();
		res.put(status, true);
		res.put(message, "data found!");
		res.put("data", doctorService.getDoctorById(docId));
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@DeleteMapping("/{docId}")
	public ResponseEntity<Map<String, Object>> deleteDoctorById(@PathVariable Long docId)
			throws DoctorNotDeletedException {
		Map<String, Object> res = new HashMap<>();
		res.put(status, true);
		res.put(message, "data found!");
		res.put("data", doctorService.deleteDoctorById(docId));
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

}
