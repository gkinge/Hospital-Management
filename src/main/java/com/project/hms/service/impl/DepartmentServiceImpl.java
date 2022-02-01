package com.project.hms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hms.entity.Department;
import com.project.hms.repository.DepartmentRepository;
import com.project.hms.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	

//	public DepartmentServiceImpl(DepartmentRepository DepartmentRepository) {
//		super();
//		this.DepartmentRepository = DepartmentRepository;
//	}

	@Override
	public List<Department> getAllDepartment() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
	}

	@Override
	public Department saveDepartment(Department department) {
		
		return departmentRepository.save(department);
	}

	@Override
	public Department getDepartmentById(Integer id) {
		// TODO Auto-generated method stub
		return departmentRepository.findById(id).get();
	}

	@Override
	public Department updateDepartment(Department department) {
		// TODO Auto-generated method stub
		return departmentRepository.save(department);
	}

	@Override
	public void deleteDepartmentById(Integer id) {
		
		departmentRepository.deleteById(id);
		
	}	


}
