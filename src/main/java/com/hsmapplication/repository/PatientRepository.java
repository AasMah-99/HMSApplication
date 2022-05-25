package com.hsmapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hsmapplication.model.Appointments;
import com.hsmapplication.model.User;


public interface PatientRepository extends JpaRepository<User, Long> {

	@Query("From User p WHERE p.email =:pEmail AND p.password =:pPass")
	User getPatientByEmailAndPassword(@Param("pEmail") String email, @Param("pPass") String password);

	@Query("From Appointments a WHERE a.user.userId = :aUserId")
	List<Appointments> getPatientAppointments(@Param("aUserId") Long userId);

	@Query(value = "From Appointments a WHERE a.user.userId=:aUserId ORDER BY appointmentTime LIMIT 5", nativeQuery = true)
	List<Appointments> getRecentAppointments(@Param("aUserId") Long userId);

}
