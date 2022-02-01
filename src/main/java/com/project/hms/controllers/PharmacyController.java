package com.project.hms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.hms.entity.Pharmacy;
import com.project.hms.service.PharmacyService;

@Controller
public class PharmacyController {
	
	private PharmacyService pharmacyService;

	public PharmacyController(PharmacyService pharmacyService) {
		super();
		this.pharmacyService = pharmacyService;
	}
	
	//Handler Method to Handle List Pharmacy and Return <Model & View>
	
	@GetMapping("/pharm")
	public String ListPharmacy(Model model) {
		model.addAttribute("pharm", pharmacyService.getAllPharmacy());
		return "pharm";
	}
	
	@GetMapping("/pharm/new")
	public String createPharmacyForm(Model model) {
		
		// Create Pharmacy Object
		Pharmacy pharm = new Pharmacy();
		model.addAttribute("pharm",pharm);
		return "create_pharm";
	}
	
	@PostMapping("/pharm")
	public String saveStudent(@ModelAttribute("pharm") Pharmacy pharm) {
		pharmacyService.savePharmacy(pharm);
		return "redirect:/pharm";
	}
	
	@GetMapping("/pharm/edit/{id}")
	public String editPharmacyForm(@PathVariable Integer id, Model model ) {
		model.addAttribute("pharm",pharmacyService.getPharmacyById(id));
		return "edit_pharm";
	}
	
	@PostMapping("/pharm/{id}")
	public String updatePharmacy(@PathVariable Integer id, @ModelAttribute("pharm") Pharmacy pharm, Model model) {
		//Get Medicine from DB by Id
		Pharmacy existingPharm = pharmacyService.getPharmacyById(id);
		existingPharm.setId(id);
		existingPharm.setMedName(pharm.getMedName());
		existingPharm.setMedCost(pharm.getMedCost());
		existingPharm.setMedUse(pharm.getMedUse());
		existingPharm.setMedInStock(pharm.getMedInStock());
		existingPharm.setMedSideEffects(pharm.getMedSideEffects());
		
		//Saving Updated Pharmacy objects
		pharmacyService.updatePharmacy(existingPharm);
		return "redirect:/pharm";
	}
	
	//Delete Entity
	@GetMapping("/pharm/{id}")
	public String deletePharmacy(@PathVariable Integer id) {
		pharmacyService.deletePharmacyById(id);
		return "redirect:/pharm";
	}
}
