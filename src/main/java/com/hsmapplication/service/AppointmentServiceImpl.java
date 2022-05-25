package com.hsmapplication.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsmapplication.exception.AppointmentNotDeletedException;
import com.hsmapplication.exception.AppointmentNotFoundException;
import com.hsmapplication.model.Appointments;
import com.hsmapplication.repository.AppointmentRepository;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	AppointmentRepository appointmentRepository;

	@Override
	public Appointments addAppointments(Appointments appointments) {
		return appointmentRepository.save(appointments);
	}

	@Override
	public Appointments getAppointmentsById(Long appointmentId) throws AppointmentNotFoundException {
		Optional<Appointments> appointments = appointmentRepository.findById(appointmentId);
		if (appointments.isPresent()) {
			return appointments.get();
		}
		throw new AppointmentNotFoundException("Appointment Id is invalid!!");
	}

	@Override
	public boolean updateAppointments(Appointments appointments) throws AppointmentNotFoundException {
		if (appointmentRepository.existsById(appointments.getAppointmentId())) {
			Appointments apt = appointmentRepository.save(appointments);
			if (apt != null) {
				return true;
			}
		}
		throw new AppointmentNotFoundException("Appointment Not Found!!");
	}

	@Override
	public List<Appointments> getAllAppointmentsByDocId(Long doctorId) {
		return appointmentRepository.getAllAppointmentsByDocId(doctorId);
	}

	@Override
	public List<Appointments> getAllAppointments() {
		return appointmentRepository.findAll();
	}

	@Override
	public boolean deleteAppointmentsById(Long appointmentId) throws AppointmentNotDeletedException {
		appointmentRepository.deleteById(appointmentId);
		if (appointmentRepository.existsById(appointmentId)) {
			throw new AppointmentNotDeletedException("Appointment not deleted!!");
		}
		return true;
	}

	@Override
	public boolean deleteAppointment(Appointments appointments) throws AppointmentNotDeletedException {
		appointmentRepository.delete(appointments);
		if (appointmentRepository.existsById(appointments.getAppointmentId())) {
			throw new AppointmentNotDeletedException("Appointment Not deleted!!");
		}
		return true;
	}

	@Override
	public List<Appointments> getAllAppointmentsByDocName(String name) throws AppointmentNotFoundException {
		List<Appointments> ap = appointmentRepository.getAppointmentByDocName(name);
		if (ap != null) {
			return ap;
		}
		throw new AppointmentNotFoundException("Invalid Doctor Name!!");
	}

}
