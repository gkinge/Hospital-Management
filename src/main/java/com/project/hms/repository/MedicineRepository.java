package com.project.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.hms.entity.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine,Integer> {

}
