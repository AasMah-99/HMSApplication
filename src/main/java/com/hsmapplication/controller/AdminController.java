package com.hsmapplication.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hsmapplication.exception.ReceptionistNotAddedException;
import com.hsmapplication.model.Doctor;
import com.hsmapplication.model.Receptionist;
import com.hsmapplication.service.DoctorService;
import com.hsmapplication.service.ReceptionistService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private DoctorService doctorService;

	@Autowired
	private ReceptionistService receptionistService;

	@GetMapping()
	public ModelAndView adminHome() {
		return new ModelAndView("admin");
	}

	@GetMapping("/register")
	public ModelAndView adminRegisterationForms() {
		return new ModelAndView("adminRegistration");
	}

	@PostMapping("/saveDoctor")
	public ResponseEntity<Map<String, Object>> addDoctor(@RequestBody Doctor doctor) {
		Map<String, Object> res = new HashMap<>();
		res.put("status", true);
		res.put("message", "data inserted successfully!");
		res.put("data", doctorService.addDoctor(doctor));
		return new ResponseEntity<>(res, HttpStatus.CREATED);
	}

	@PostMapping("/saveReceptionist")
	public ResponseEntity<Map<String, Object>> addReceptionist(@RequestBody Receptionist receptionist)
			throws ReceptionistNotAddedException {
		Map<String, Object> res = new HashMap<>();
		res.put("status", true);
		res.put("message", "data inserted successfully!");
		res.put("data", receptionistService.addReceptionist(receptionist));
		return new ResponseEntity<>(res, HttpStatus.CREATED);
	}
}
