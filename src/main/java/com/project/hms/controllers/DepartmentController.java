package com.project.hms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.hms.entity.Department;
import com.project.hms.service.DepartmentService;

@Controller
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;

//	public DepartmentController(DepartmentService DepartmentService) {
//		super();
//		this.DepartmentService = DepartmentService;
//	}
	
	@GetMapping(path="/dept")
	@ResponseBody
	public String getCustomerDetails() {
	return "Welcome to Hospital";
	}
	
	@GetMapping("/departments")
	public String ListDepartment(Model model) {
		model.addAttribute("departments", departmentService.getAllDepartment());
		return "departments";
	}
	
	@GetMapping("/departments/new")
	public String createDepartmentForm(Model model) {
		
		Department department = new Department();
		model.addAttribute("department", department);
		return "create_department";
	}
	
	@PostMapping("/departments")
	public String saveDepartment(@ModelAttribute("department") Department department) {
		
		departmentService.saveDepartment(department);
		return "redirect:/departments";
		
	}
	
	@GetMapping("/departments/edit/{id}")
	public String editDepartmentForm(@PathVariable Integer id, Model model) {
		model.addAttribute("department", departmentService.getDepartmentById(id));
		return "edit_department";
		
	}
	
	@PostMapping("/departments/{id}")
	public String updateDepartment(@PathVariable Integer id, @ModelAttribute("department") Department department, Model model) {
		
		Department existingDepartment = departmentService.getDepartmentById(id);
		existingDepartment.setId(id);
		existingDepartment.setName(department.getName());
		existingDepartment.setType(department.getType());
		existingDepartment.setLocation(department.getLocation());
		
		departmentService.updateDepartment(existingDepartment);
		return "redirect:/departments";
		
	}
	
	@GetMapping("/departments/{id}")
	public String deleteDepartment(@PathVariable Integer id) {
		
		departmentService.deleteDepartmentById(id);
		return "redirect:/departments";
		
		
	}

}