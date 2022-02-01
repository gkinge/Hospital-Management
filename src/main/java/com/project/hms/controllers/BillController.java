package com.project.hms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.hms.entity.Bill;
import com.project.hms.service.BillService;



@Controller
public class BillController {

	private BillService billService;

	public BillController(BillService billService) {
		super();
		this.billService = billService;
	}

	// handler method to handle list room and return mode and view
	@GetMapping("/bills")
	public String listBills(Model model) {
		model.addAttribute("bill", billService.getAllBills());
		return "bill";
	}

	@GetMapping("/bills/new")
	public String createBillForm(Model model) {

		// create student object to hold student form data
		Bill bill = new Bill();
		model.addAttribute("bill", bill);
		return "create_bill";

	}

	@PostMapping("/bills")
	public String saveBill(@ModelAttribute("bill") Bill bill) {
		billService.saveBill(bill);
		return "redirect:/bills";
	}

	@GetMapping("/bills/edit/{id}")
	public String editBillForm(@PathVariable Integer id, Model model) {
		model.addAttribute("bill", billService.getBillById(id));
		return "edit_bill";
	}

	@PostMapping("/bills/{id}")
	public String updateBill(@PathVariable Integer id, @ModelAttribute("bill") Bill bill, Model model) {

		// get room from database by id
		Bill existingBill = billService.getBillById(id);
	    existingBill.setId(id);
		existingBill.setPatient_id(bill.getPatient_id());
		existingBill.setDoctor_charge(bill.getDoctor_charge());
		existingBill.setRoom_charge(bill.getRoom_charge());
		existingBill.setNo_of_days(bill.getNo_of_days());
		existingBill.setTotal(bill.getTotal());

		// save updated student object
		billService.updateBill(existingBill);
		return "redirect:/bills";
	}

	// handler method to handle delete student request

	@GetMapping("/bills/{id}")
	public String deleteBills(@PathVariable Integer id) {
		billService.deleteBillById(id);
		return "redirect:/bills";
	}

}
