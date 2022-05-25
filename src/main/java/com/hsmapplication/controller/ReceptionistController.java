package com.hsmapplication.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hsmapplication.exception.DoctorNotFoundException;
import com.hsmapplication.service.AppointmentService;
import com.hsmapplication.service.DoctorService;
import com.hsmapplication.service.PatientService;

@RestController
@RequestMapping("/receptionist")
public class ReceptionistController {

	@Autowired
	PatientService patientService;

	@Autowired
	DoctorService doctorService;

	@Autowired
	AppointmentService appointmentService;

	@GetMapping()
	public ModelAndView getReceptionistDashboard() {
		Map<String, Object> model = new HashMap<>();
		model.put("users", patientService.getAllPatients());
		model.put("doctors", doctorService.getAllDoctors());
		model.put("appointments", appointmentService.getAllAppointments());
		model.put("totalFee", doctorService.getTotalFeeRecieved());
		return new ModelAndView("receptionistDashboard", model);
	}

	@GetMapping("/deleteAppointment")
	public ModelAndView getReceptionistDeleteAppointment() {
		Map<String, Object> model = new HashMap<>();
		model.put("appointments", appointmentService.getAllAppointments());
		return new ModelAndView("deleteAppointment", model);
	}

	@GetMapping("/updateAppointment")
	public ModelAndView getReceptionistUpdateAppointment() throws DoctorNotFoundException {
		Map<String, Object> model = new HashMap<>();
		model.put("appointments", appointmentService.getAllAppointments());
		model.put("doctors", doctorService.getActiveDoctor());
		return new ModelAndView("updateAppointment", model);
	}

	@GetMapping("/updateSpecialization")
	public ModelAndView getReceptionistUpdateSpecialization() throws DoctorNotFoundException {
		Map<String, Object> model = new HashMap<>();
		model.put("appointments", appointmentService.getAllAppointments());
		model.put("doctors", doctorService.getActiveDoctor());
		return new ModelAndView("updateSpecialization", model);
	}

	@GetMapping("/patientPrescription")
	public ModelAndView getReceptionistPatientPrescription() {
		return new ModelAndView("patientPrescription");
	}

	@GetMapping("/receptionistPrintReceipt")
	public ModelAndView getReceptionistPrintReceipt() {
		Map<String, Object> model = new HashMap<>();
		model.put("appointments", appointmentService.getAllAppointments());
		return new ModelAndView("receptionistPrintReceipt", model);
	}

	@GetMapping("/appointmentPerDoctor")
	public ModelAndView getReceptionistPppointmentPerDoctor() {
		Map<String, Object> model = new HashMap<>();
		model.put("appointments", appointmentService.getAllAppointments());
		return new ModelAndView("appointmentPerDoctor", model);
	}

}
