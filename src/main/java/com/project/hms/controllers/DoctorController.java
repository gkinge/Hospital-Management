package com.project.hms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.hms.entity.Doctor;
import com.project.hms.service.DoctorService;

@Controller
public class DoctorController {
	private DoctorService doctorService;

	public DoctorController(DoctorService doctorService) {
		super();
		this.doctorService = doctorService;
	}
	
	// handler method to handle list students and return mode and view
	@GetMapping("/doctors")
	public String listDoctors(Model model) {
		model.addAttribute("doctors", doctorService.getAllDoctors());
		return "doctors";
	}
	
	@GetMapping("/doctors/new")
	public String createDoctorForm(Model model) {
		
		// create student object to hold student form data
		Doctor doctor = new Doctor();
		model.addAttribute("doctor", doctor);
		return "create_doctor";
		
	}
	
	@PostMapping("/doctors")
	public String saveDoctor(@ModelAttribute("doctor") Doctor doctor) {
		doctorService.saveDoctor(doctor);
		return "redirect:/doctors";
	}
	
	@GetMapping("/doctors/edit/{id}")
	public String editDoctorForm(@PathVariable Integer id, Model model) {
		model.addAttribute("doctor", doctorService.getDoctorById(id));
		return "edit_doctor";
	}

	@PostMapping("/doctors/{id}")
	public String updateDoctor(@PathVariable Integer id,
			@ModelAttribute("doctor") Doctor doctor,
			Model model) {
		
		// get student from database by id
		Doctor existingDoctor = doctorService.getDoctorById(id);
		existingDoctor.setId(id);
		existingDoctor.setName(doctor.getName());
		existingDoctor.setSpecialization(doctor.getSpecialization());
		existingDoctor.setMobile(doctor.getMobile());
		existingDoctor.setAddress(doctor.getAddress());
		existingDoctor.setEmail(doctor.getEmail());
		
		// save updated student object
		doctorService.updateDoctor(existingDoctor);
		return "redirect:/doctors";		
	}
	
	// handler method to handle delete student request
	
	@GetMapping("/doctors/{id}")
	public String deleteDoctor(@PathVariable Integer id) {
		doctorService.deleteDoctorById(id);
		return "redirect:/doctors";
	}
}
