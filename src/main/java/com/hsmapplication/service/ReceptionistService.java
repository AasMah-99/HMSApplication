package com.hsmapplication.service;

import com.hsmapplication.exception.ReceptionistNotAddedException;
import com.hsmapplication.exception.ReceptionistNotDeletedException;
import com.hsmapplication.exception.ReceptionistNotFoundException;
import com.hsmapplication.exception.ReceptionistNotUpdatedException;
import com.hsmapplication.model.Receptionist;

public interface ReceptionistService {

	public Receptionist addReceptionist(Receptionist receptionist) throws ReceptionistNotAddedException;

	public Receptionist getReceptionist(String email, String password) throws ReceptionistNotFoundException;

	public Receptionist getReceptionistById(Long receptionistId) throws ReceptionistNotFoundException;

	public boolean deleteReceptionistById(Long receptionistId) throws ReceptionistNotDeletedException;

	public boolean deleteReceptionist(Receptionist receptionist) throws ReceptionistNotDeletedException;

	public boolean updateReceptionist(Receptionist receptionist) throws ReceptionistNotUpdatedException;

}
