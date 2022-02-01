package com.project.hms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.hms.entity.Nurse;
import com.project.hms.service.NurseService;

@Controller
public class NurseController {
	
	private NurseService nurseService;

	public NurseController(NurseService nurseService) {
		super();
		this.nurseService = nurseService;
	}

	@GetMapping("/nurses")
	public String ListNurse(Model model) {
		model.addAttribute("nurses", nurseService.getAllNurse());
		return "nurses";
	}
	
	@GetMapping("/nurses/new")
	public String createNurseForm(Model model) {
		
		Nurse nurse = new Nurse();
		model.addAttribute("nurse", nurse);
		return "Create_nurse";
	}
	
	@PostMapping("/nurses")
	public String saveNurse(@ModelAttribute("nurse") Nurse nurse) {
		
		nurseService.saveNurse(nurse);
		return "redirect:/nurses";
		
	}
	
	@GetMapping("/nurses/edit/{id}")
	public String editNurseForm(@PathVariable Integer id, Model model) {
		model.addAttribute("nurse", nurseService.getNurseById(id));
		return "edit_nurse";
		
	}
	
	@PostMapping("/nurses/{id}")
	public String updateNurse(@PathVariable Integer id, @ModelAttribute("nurse") Nurse nurse, Model model) {
		
		Nurse existingNurse = nurseService.getNurseById(id);
		existingNurse.setId(id);
		existingNurse.setName(nurse.getName());
		existingNurse.setMobile(nurse.getMobile());
		existingNurse.setEmail(nurse.getEmail());
		existingNurse.setShift(nurse.getShift());
		
		nurseService.updateNurse(existingNurse);
		return "redirect:/nurses";
		
	}
	
	@GetMapping("/nurses/{id}")
	public String deleteNurse(@PathVariable Integer id) {
		
		nurseService.deleteNurseById(id);
		return "redirect:/nurses";
		
		
	}

}
