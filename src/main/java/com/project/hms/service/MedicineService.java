package com.project.hms.service;

import java.util.List;

import com.project.hms.entity.Medicine;

public interface MedicineService {
	List<Medicine> getAllMedicines();
	
	
	Medicine saveMedicine(Medicine medicine);
	
	Medicine getMedicineById(Integer id);
	
	Medicine updateMedicine(Medicine medicine );


	void deleteMedicineById(Integer id);
	


}