package com.hsmapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hsmapplication.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

	@Query("From Admin a WHERE a.userName =:aAdminuser AND a.password =:aPass")
	Admin getAdminByEmailAndPass(@Param("aAdminuser") String userName, @Param("aPass") String pass);

}
