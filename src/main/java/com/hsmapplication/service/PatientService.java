package com.hsmapplication.service;

import java.util.List;

import com.hsmapplication.exception.AppointmentNotFoundException;
import com.hsmapplication.exception.PatientNotAddedException;
import com.hsmapplication.exception.PatientNotDeletedException;
import com.hsmapplication.exception.PatientNotFoundException;
import com.hsmapplication.exception.PatientNotUpdatedException;
import com.hsmapplication.model.Appointments;
import com.hsmapplication.model.User;



public interface PatientService {

	public User getPatient(String email, String password) throws PatientNotFoundException;

	public List<Appointments> getPatientAppointments(Long patientId) throws AppointmentNotFoundException;

	public List<Appointments> getRecentAppointments(Long patientId) throws AppointmentNotFoundException;

	public User addPatient(User user) throws PatientNotAddedException;

	public List<User> getAllPatients();

	public User getPatientById(Long userId) throws PatientNotFoundException;

	public boolean deleteUserById(Long userId) throws PatientNotFoundException, PatientNotDeletedException;

	public boolean deletePatient(User patient) throws PatientNotDeletedException;

	public boolean updateUser(User user) throws PatientNotUpdatedException;

}
