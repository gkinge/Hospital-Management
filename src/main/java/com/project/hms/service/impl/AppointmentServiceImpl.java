package com.project.hms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.hms.entity.Appointment;
import com.project.hms.repository.AppointmentRepository;
import com.project.hms.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService{

	private AppointmentRepository appointmentRepository;
	
	public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
		super();
		this.appointmentRepository = appointmentRepository;
	}

	//1.LIST
	@Override
	public List<Appointment> getAllAppointments() {
		return appointmentRepository.findAll();
	}

	//2.SAVE
	@Override
	public Appointment saveAppointment(Appointment appointment) {
		return appointmentRepository.save(appointment);
	}

	//3.GET BY ID
	@Override
	public Appointment getAppointmentById(Integer id) {
		return appointmentRepository.findById(id).get();
	}

	//4.UPDATE
	@Override
	public Appointment updateAppointment(Appointment appointment) {
		return appointmentRepository.save(appointment);
	}

	//5.DELETE
	@Override
	public void deleteAppointmentById(Integer id) {
		appointmentRepository.deleteById(id);	
	}

}
