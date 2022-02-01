package com.project.hms.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.hms.entity.Patient;
import com.project.hms.service.PatientService;

@Controller
public class PatientController {
	
	private PatientService patientService;

	public PatientController(PatientService patientService) {
		super();
		this.patientService = patientService;
	}

	@GetMapping("/patients")
	public String ListPatient(Model model) {
		model.addAttribute("patients", patientService.getAllPatient());
		return "patients";
	}
	
	@GetMapping("/patients/new")
	public String createPatientForm(Model model) {
		
		Patient patient = new Patient();
		model.addAttribute("patient", patient);
		return "create_patient";
	}
	
	@PostMapping("/patients")
	public String savePatient(@Valid @ModelAttribute("patient") Patient patient, BindingResult result) {
		
		if(result.hasErrors()) {
			return "create_patient";
		}
		patientService.savePatient(patient);
		return "redirect:/patients";
		
	}
	
	@GetMapping("/patients/edit/{id}")
	public String editPatientForm(@PathVariable Integer id, Model model) {
		model.addAttribute("patient", patientService.getPatientById(id));
		return "edit_patient";
		
	}
	
	@PostMapping("/patients/{id}")
	public String updatePatient(@PathVariable Integer id, @ModelAttribute("patient") Patient patient, Model model) {
		
		Patient existingPatient = patientService.getPatientById(id);
		existingPatient.setId(id);
		existingPatient.setName(patient.getName());
		existingPatient.setMobile(patient.getMobile());
		existingPatient.setDocName(patient.getDocName());
		existingPatient.setDiagnosis(patient.getDiagnosis());
		existingPatient.setEmail(patient.getEmail());
		
		patientService.updatePatient(existingPatient);
		return "redirect:/patients";
		
	}
	
	@GetMapping("/patients/{id}")
	public String deletePatient(@PathVariable Integer id) {
		
		patientService.deletePatientById(id);
		return "redirect:/patients";
		
		
	}
	

}
