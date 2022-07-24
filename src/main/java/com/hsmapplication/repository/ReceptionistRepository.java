package com.hsmapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hsmapplication.model.Receptionist;


public interface ReceptionistRepository extends JpaRepository<Receptionist, Long> {

	@Query("FROM Receptionist r where r.email=:rEmail AND r.password=:rPass")
	Receptionist getReceptionistByEmailAndPass(@Param("rEmail") String email, @Param("rPass") String pass);

}
