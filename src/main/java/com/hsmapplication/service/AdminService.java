package com.hsmapplication.service;

import com.hsmapplication.exception.AdminNotAddedException;
import com.hsmapplication.exception.AdminNotDeletedException;
import com.hsmapplication.exception.AdminNotFoundException;
import com.hsmapplication.exception.AdminNotUpdatedException;
import com.hsmapplication.model.Admin;

public interface AdminService {

	public Admin getAdmin(String username, String password) throws AdminNotFoundException;

	public Admin addAdmin(Admin admin) throws AdminNotAddedException;

	public Admin getAdminById(Long adminId) throws AdminNotFoundException;

	public boolean deleteAdminById(Long adminId) throws AdminNotDeletedException;

	public boolean deleteAdmin(Admin admin) throws AdminNotDeletedException;

	public boolean updateAdmin(Admin admin) throws AdminNotUpdatedException;

}
