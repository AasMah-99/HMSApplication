package com.hsmapplication.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsmapplication.exception.AdminNotAddedException;
import com.hsmapplication.exception.AdminNotDeletedException;
import com.hsmapplication.exception.AdminNotFoundException;
import com.hsmapplication.exception.AdminNotUpdatedException;
import com.hsmapplication.model.Admin;
import com.hsmapplication.repository.AdminRepository;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository;

	@Override
	public Admin getAdmin(String username, String password) throws AdminNotFoundException {
		Admin ad = adminRepository.getAdminByEmailAndPass(username, password);
		if (ad != null) {
			return ad;
		}
		throw new AdminNotFoundException("Username or password is incorrect..!");
	}

	@Override
	public Admin addAdmin(Admin admin) throws AdminNotAddedException {
		Admin ad = adminRepository.save(admin);
		if (adminRepository.existsById(ad.getAdminId())) {
			return ad;
		}
		throw new AdminNotAddedException("admin not added..!");
	}

	@Override
	public Admin getAdminById(Long adminId) throws AdminNotFoundException {
		Optional<Admin> admin = adminRepository.findById(adminId);
		if (admin.isPresent()) {
			return admin.get();
		}
		throw new AdminNotFoundException("admin not found");
	}

	@Override
	public boolean deleteAdminById(Long adminId) throws AdminNotDeletedException {
		adminRepository.deleteById(adminId);
		if (adminRepository.existsById(adminId)) {
			throw new AdminNotDeletedException("error deleting admin");
		}
		return true;
	}

	@Override
	public boolean deleteAdmin(Admin admin) throws AdminNotDeletedException {
		adminRepository.delete(admin);
		if (adminRepository.existsById(admin.getAdminId())) {
			throw new AdminNotDeletedException("error deleting admin");
		}
		return true;
	}

	@Override
	public boolean updateAdmin(Admin admin) throws AdminNotUpdatedException {
		if (adminRepository.existsById(admin.getAdminId())) {
			Admin adm = adminRepository.save(admin);
			if (adm != null) {
				return true;
			}
		}
		throw new AdminNotUpdatedException("error updating admin");
	}

}
