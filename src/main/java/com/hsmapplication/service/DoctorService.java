package com.hsmapplication.service;

import java.util.List;

import com.hsmapplication.exception.DoctorNotDeletedException;
import com.hsmapplication.exception.DoctorNotFoundException;
import com.hsmapplication.exception.DoctorNotUpdatedException;
import com.hsmapplication.model.Doctor;



public interface DoctorService {

	public Doctor addDoctor(Doctor doctor);

	public List<Doctor> getAllDoctors();

	public Double getTotalFeeRecieved();

	public List<Doctor> getAllDoctorsByFee();

	public Doctor getDoctorById(Long doctorId) throws DoctorNotFoundException;

	public boolean deleteDoctorById(Long doctorId) throws DoctorNotDeletedException;

	public boolean deleteDoctor(Doctor doctor) throws DoctorNotDeletedException;

	public boolean updateDoctor(Doctor doctor) throws DoctorNotUpdatedException;

	public Doctor getDoctor(String email, String password) throws DoctorNotFoundException;

	public List<Doctor> getActiveDoctor() throws DoctorNotFoundException;

}
