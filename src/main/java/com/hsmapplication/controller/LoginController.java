package com.hsmapplication.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hsmapplication.exception.AdminNotFoundException;
import com.hsmapplication.exception.DoctorNotFoundException;
import com.hsmapplication.exception.PatientNotFoundException;
import com.hsmapplication.exception.ReceptionistNotFoundException;
import com.hsmapplication.model.User;
import com.hsmapplication.service.AdminService;
import com.hsmapplication.service.DoctorService;
import com.hsmapplication.service.PatientService;
import com.hsmapplication.service.ReceptionistService;

@RestController

public class LoginController {

	@Autowired
	PatientService patientService;

	@Autowired
	DoctorService doctorService;

	@Autowired
	AdminService adminService;

	@Autowired
	ReceptionistService receptionistService;

	private static final String status = "status";
	private static final String message = "message";

	@GetMapping()
	public ModelAndView getHomePage() {
		Map<String, Object> model = new HashMap<>();
		model.put("doctors", doctorService.getAllDoctors());
		return new ModelAndView("index", model);
	}

	@GetMapping("/registration")
	public ModelAndView getPatientForm(@ModelAttribute User user) {
		return new ModelAndView("patientregistration");
	}

	@GetMapping("/adminLogin")
	public ModelAndView getAdminLoginPage(@ModelAttribute User user) {
		return new ModelAndView("adminLoginPage");
	}

	@GetMapping("/login")
	public ModelAndView getLoginPage(@ModelAttribute User user) {
		return new ModelAndView("LoginPage");
	}

	@PostMapping("/patient/login")
	public ResponseEntity<Map<String, Object>> patientLogin(@RequestBody Map<String, Object> body) throws PatientNotFoundException {
		Map<String, Object> res = new HashMap<>();
		res.put(status, true);
		res.put(message, "data inserted successfully!");
		res.put("data", patientService.getPatient(body.get("email").toString(), body.get("password").toString()));

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@PostMapping("/doctor/login")
	public ResponseEntity<Map<String, Object>> doctorLogin(@RequestBody Map<String, Object> body) throws DoctorNotFoundException {
		Map<String, Object> res = new HashMap<>();
		res.put(status, true);
		res.put(message, "data inserted successfully!");
		res.put("data", doctorService.getDoctor(body.get("email").toString(), body.get("password").toString()));

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@PostMapping("/receptionist/login")
	public ResponseEntity<Map<String, Object>> receptionistLogin(@RequestBody Map<String, Object> body) throws ReceptionistNotFoundException {
		Map<String, Object> res = new HashMap<>();
		res.put(status, true);
		res.put(message, "data inserted successfully!");
		res.put("data",
				receptionistService.getReceptionist(body.get("email").toString(), body.get("password").toString()));

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@PostMapping("/admin/login")
	public ResponseEntity<Map<String, Object>> adminLogin(@RequestBody Map<String, Object> body) throws AdminNotFoundException {
		Map<String, Object> res = new HashMap<>();
		res.put(status, true);
		res.put(message, "data inserted successfully!");
		res.put("data", adminService.getAdmin(body.get("username").toString(), body.get("password").toString()));

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

}