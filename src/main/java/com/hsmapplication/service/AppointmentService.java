package com.hsmapplication.service;

import java.util.List;

import com.hsmapplication.exception.AppointmentNotDeletedException;
import com.hsmapplication.exception.AppointmentNotFoundException;
import com.hsmapplication.model.Appointments;



public interface AppointmentService {

	public Appointments addAppointments(Appointments appointments);

	public Appointments getAppointmentsById(Long appointmentId) throws AppointmentNotFoundException;

	public List<Appointments> getAllAppointments();

	public boolean deleteAppointmentsById(Long appointmentId) throws AppointmentNotDeletedException;

	public boolean deleteAppointment(Appointments appointments) throws AppointmentNotDeletedException;

	public boolean updateAppointments(Appointments appointments) throws AppointmentNotFoundException;

	public List<Appointments> getAllAppointmentsByDocId(Long doctorId);

	public List<Appointments> getAllAppointmentsByDocName(String name) throws AppointmentNotFoundException;

}
