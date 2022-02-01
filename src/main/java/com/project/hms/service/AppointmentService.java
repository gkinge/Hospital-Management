package com.project.hms.service;

import java.util.List;

import com.project.hms.entity.Appointment;

public interface AppointmentService {
	
	List<Appointment> getAllAppointments();
	
	Appointment saveAppointment(Appointment appointment);
	
	Appointment getAppointmentById(Integer id);
	
	Appointment updateAppointment(Appointment appointment);
	
	void deleteAppointmentById(Integer id);
}
