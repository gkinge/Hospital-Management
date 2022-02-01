package com.project.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.hms.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
