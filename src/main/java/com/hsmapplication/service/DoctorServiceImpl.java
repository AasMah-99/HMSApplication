package com.hsmapplication.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hsmapplication.exception.DoctorNotDeletedException;
import com.hsmapplication.exception.DoctorNotFoundException;
import com.hsmapplication.exception.DoctorNotUpdatedException;
import com.hsmapplication.model.Doctor;
import com.hsmapplication.repository.DoctorRepository;



@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	DoctorRepository doctorRepository;

	@Override
	public Doctor addDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	@Override
	public Doctor getDoctor(String email, String password) throws DoctorNotFoundException {
		Doctor doc = doctorRepository.getDoctorByEmailAndPass(email, password);
		if (doc != null) {
			return doc;
		}
		throw new DoctorNotFoundException("Email or password is incorrect..!");
	}

	@Override
	public List<Doctor> getAllDoctors() {
		return doctorRepository.findAll();
	}

	@Override
	public Doctor getDoctorById(Long doctorId) throws DoctorNotFoundException {
		Optional<Doctor> doctor = doctorRepository.findById(doctorId);
		if (doctor.isPresent()) {
			return doctor.get();
		}
		throw new DoctorNotFoundException("no doctor found");
	}

	@Override
	public boolean deleteDoctorById(Long doctorId) throws DoctorNotDeletedException {
		doctorRepository.deleteById(doctorId);
		if (doctorRepository.existsById(doctorId)) {
			throw new DoctorNotDeletedException("doctor not deleted");
		}
		return true;

	}

	@Override
	public boolean deleteDoctor(Doctor doctor) throws DoctorNotDeletedException {
		doctorRepository.delete(doctor);
		if (doctorRepository.existsById(doctor.getDoctorId())) {
			throw new DoctorNotDeletedException("error deleting doctor");
		}
		return true;
	}

	@Override
	public boolean updateDoctor(Doctor doctor) throws DoctorNotUpdatedException {
		if (doctorRepository.existsById(doctor.getDoctorId())) {
			Doctor doc = doctorRepository.save(doctor);
			if (doc != null) {
				return true;
			}
		}
		throw new DoctorNotUpdatedException("error updating doctor");
	}

	@Override
	public List<Doctor> getAllDoctorsByFee() {
		return doctorRepository.findAll(Sort.by(Sort.Direction.ASC, "fee"));
	}

	@Override
	public Double getTotalFeeRecieved() {
		return doctorRepository.getTotalFee();
	}

	@Override
	public List<Doctor> getActiveDoctor() throws DoctorNotFoundException {
		List<Doctor> acDoc = doctorRepository.getActiveDoctor(true);
		if (acDoc != null) {
			return acDoc;
		}
		throw new DoctorNotFoundException("Doctor not found!!");
	}

}
