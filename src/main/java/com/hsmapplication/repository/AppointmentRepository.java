package com.hsmapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hsmapplication.model.Appointments;

public interface AppointmentRepository extends JpaRepository<Appointments, Long> {

	@Query("From Appointments a WHERE a.doctor.doctorId = :aDoctorId")
	List<Appointments> getAllAppointmentsByDocId(@Param("aDoctorId") Long doctorId);

	@Query("From Appointments a WHERE a.doctor.name =:pName")
	List<Appointments> getAppointmentByDocName(@Param("pName") String name);

}
