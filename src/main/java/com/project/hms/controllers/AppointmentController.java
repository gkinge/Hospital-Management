package com.project.hms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.hms.entity.Appointment;
import com.project.hms.service.AppointmentService;

@Controller
public class AppointmentController {
	
	private AppointmentService appointmentService;

	public AppointmentController(AppointmentService appointmentService) {
		super();
		this.appointmentService = appointmentService;
	}
	
	// handler method to handle list students and return mode and view
	@GetMapping("/appointments")
	public String listAppointments(Model model) {
		model.addAttribute("appointments", appointmentService.getAllAppointments());
		return "appointments";
	}
	
	@GetMapping("/appointments/new")
	public String createAppointmentForm(Model model) {
		
		// create student object to hold student form data
		Appointment appointment = new Appointment();
		model.addAttribute("appointment", appointment);
		return "create_appointment";
		
	}
	
	@PostMapping("/appointments")
	public String saveAppointment(@ModelAttribute("appointment") Appointment appointment) {
		appointmentService.saveAppointment(appointment);
		return "redirect:/appointments";
	}
	
	@GetMapping("/appointments/edit/{id}")
	public String editAppointmentForm(@PathVariable Integer id, Model model) {
		model.addAttribute("appointment", appointmentService.getAppointmentById(id));
		return "edit_appointment";
	}

	@PostMapping("/appointments/{id}")
	public String updateAppointment(@PathVariable Integer id,
			@ModelAttribute("appointment") Appointment appointment,
			Model model) {
		
		// get student from database by id
		Appointment existingAppointment = appointmentService.getAppointmentById(id);
		existingAppointment.setId(id);
		existingAppointment.setName(appointment.getName());
		existingAppointment.setReason(appointment.getReason());
		existingAppointment.setMobile(appointment.getMobile());
		existingAppointment.setAddress(appointment.getAddress());
		existingAppointment.setEmail(appointment.getEmail());
		
		// save updated student object
		appointmentService.updateAppointment(existingAppointment);
		return "redirect:/appointments";		
	}
	
	// handler method to handle delete student request
	
	@GetMapping("/appointments/{id}")
	public String deleteAppointment(@PathVariable Integer id) {
		appointmentService.deleteAppointmentById(id);
		return "redirect:/appointments";
	}
	
}
