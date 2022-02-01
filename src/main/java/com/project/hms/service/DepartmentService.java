package com.project.hms.service;

import java.util.List;

import com.project.hms.entity.Department;

public interface DepartmentService {
	
	List<Department> getAllDepartment();
	
	Department saveDepartment(Department department);
		
	Department updateDepartment(Department department);

	Department getDepartmentById(Integer id);

	void deleteDepartmentById(Integer id);
	

}
