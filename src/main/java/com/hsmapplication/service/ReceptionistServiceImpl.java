package com.hsmapplication.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsmapplication.exception.ReceptionistNotAddedException;
import com.hsmapplication.exception.ReceptionistNotDeletedException;
import com.hsmapplication.exception.ReceptionistNotFoundException;
import com.hsmapplication.exception.ReceptionistNotUpdatedException;
import com.hsmapplication.model.Receptionist;
import com.hsmapplication.repository.ReceptionistRepository;


@Service
@Transactional
public class ReceptionistServiceImpl implements ReceptionistService {

	@Autowired
	ReceptionistRepository receptionistRepository;

	@Override
	public Receptionist addReceptionist(Receptionist receptionist) throws ReceptionistNotAddedException {
		Receptionist recp = receptionistRepository.save(receptionist);
		if (receptionistRepository.existsById(recp.getReceptionistId())) {
			return recp;
		}
		throw new ReceptionistNotAddedException("recptionist not added..");
	}

	@Override
	public Receptionist getReceptionist(String email, String password) throws ReceptionistNotFoundException {
		Receptionist recptn = receptionistRepository.getReceptionistByEmailAndPass(email, password);
		if (recptn != null) {
			return recptn;
		}
		throw new ReceptionistNotFoundException("Email or Password is incorrect...!");
	}

	@Override
	public Receptionist getReceptionistById(Long receptionistId) throws ReceptionistNotFoundException {
		Optional<Receptionist> receptionist = receptionistRepository.findById(receptionistId);
		if (receptionist.isPresent()) {
			return receptionist.get();
		}
		throw new ReceptionistNotFoundException("Receptionist not found");
	}

	@Override
	public boolean deleteReceptionistById(Long receptionistId) throws ReceptionistNotDeletedException {
		receptionistRepository.deleteById(receptionistId);
		if (receptionistRepository.existsById(receptionistId)) {
			throw new ReceptionistNotDeletedException("error deleting receptionist");
		}
		return true;
	}

	@Override
	public boolean deleteReceptionist(Receptionist receptionist) throws ReceptionistNotDeletedException {
		receptionistRepository.delete(receptionist);
		if (receptionistRepository.existsById(receptionist.getReceptionistId())) {
			throw new ReceptionistNotDeletedException("error deleting recptionist");
		}
		return true;
	}

	@Override
	public boolean updateReceptionist(Receptionist receptionist) throws ReceptionistNotUpdatedException {
		if (receptionistRepository.existsById(receptionist.getReceptionistId())) {
			Receptionist rec = receptionistRepository.save(receptionist);
			if (rec != null) {
				return true;
			}
		}
		throw new ReceptionistNotUpdatedException("error updating receptionist");
	}

}
