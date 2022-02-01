package com.project.hms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.hms.entity.BloodBank;
import com.project.hms.service.BloodBankService;

@Controller
public class BloodBankController {
	
	private BloodBankService bloodbankService;

	public BloodBankController(com.project.hms.service.BloodBankService bloodbankService) {
		super();
		this.bloodbankService = bloodbankService;
	}
	//Handler Method to Handle List Blood Bank and Return <Model & View>
	
	@GetMapping("/bloodbanks")
	public String ListBloodBank(Model model) {
		model.addAttribute("bloodbank", bloodbankService.getAllBloodBank());
		return "bloodbank";
	}
	
	@GetMapping("/bloodbanks/new")
	public String createBloodBankForm(Model model) {
		
		// Create blood bank Object
		BloodBank bloodbank = new BloodBank();
		model.addAttribute("bloodbank", bloodbank);
		return "create_bloodbank";
	}
	
	@PostMapping("/bloodbanks")
	public String saveBloodBank(@ModelAttribute("bloodbank") BloodBank bloodbank) {
		bloodbankService.saveBloodBank(bloodbank);
		return "redirect:/bloodbanks";
	}
	
	@GetMapping("/bloodbanks/edit/{id}")
	public String editBloodBankForm(@PathVariable Integer id, Model model ) {
		model.addAttribute("bloodbank",bloodbankService.getBloodBankById(id));
		return "edit_bloodbank";
	}
	
	@PostMapping("/bloodbanks/{id}")
	public String updateBloodBank(@PathVariable Integer id, @ModelAttribute("blood") BloodBank bloodbank, Model model) {
		//Get Medicine from DB by Id
		BloodBank existingEntry = bloodbankService.getBloodBankById(id);
		existingEntry.setId(id);
		existingEntry.setType(bloodbank.getType());
		existingEntry.setBloodInStock(bloodbank.getBloodInStock());
			
		//Saving Updated Pharmacy objects
		bloodbankService.updateBloodBank(existingEntry);
		return "redirect:/bloodbanks";
	}
	
	//Delete Entity
	@GetMapping("/bloodbanks/{id}")
	public String deleteBloodBank(@PathVariable Integer id) {
		bloodbankService.deleteBloodBankById(id);
		return "redirect:/bloodbanks";
	}
}
