package com.project.hms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.hms.entity.Medicine;
import com.project.hms.service.MedicineService;
import com.project.hms.service.PatientService;

@Controller
public class MedicineController {
	private PatientService patientService;
	private MedicineService medicineService;

	public MedicineController(MedicineService medicineService) {
		super();
		this.medicineService = medicineService;
	}
	
	//
	@GetMapping("/medicines")
	public String listMedicines(Model model) {
		model.addAttribute("medicine",medicineService.getAllMedicines());
		return "medicine";
	}
	@GetMapping("/medicines/new")
	public String createMedicineForm(Model model) {
		
		Medicine medicine = new Medicine();
		model.addAttribute("medicine",medicine);
		return"create_medicine";
		
	}
	@PostMapping("/medicines")
	public String saveMedicine(@ModelAttribute("medicine")Medicine medicine) {
		medicineService.saveMedicine(medicine);
		return"redirect:/medicines";
	}
	@GetMapping("/medicines/edit/{id}")

	public String editMedicineForm(@PathVariable Integer id,Model model) {
		model.addAttribute("medicine",medicineService.getMedicineById(id));
		return "edit_medicine";
	}
	@PostMapping("/medicines/{id}")
public String updateMedicine(@PathVariable Integer id,
		@ModelAttribute("medicine") Medicine medicine,Model model){
			//get med from db
			
			
		Medicine existingMedicine = medicineService.getMedicineById(id);
		existingMedicine.setId(id);
		existingMedicine.setDate(medicine.getDate());
		existingMedicine.setProblem(medicine.getProblem());
		
		
		// save updated student object
		medicineService.updateMedicine(existingMedicine);
		return "redirect:/medicines";		
	}
	
	// handler method to handle delete student request
	
	@GetMapping("/medicines/{id}")
	public String deleteMedicine(@PathVariable Integer id) {
		medicineService.deleteMedicineById(id);
		return "redirect:/medicines";
	}
	
	
}

