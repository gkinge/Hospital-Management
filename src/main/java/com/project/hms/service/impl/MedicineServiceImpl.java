package com.project.hms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.hms.entity.Medicine;
import com.project.hms.repository.MedicineRepository;
import com.project.hms.service.MedicineService;

@Service
public class MedicineServiceImpl implements MedicineService {
	private MedicineRepository medicineRepository;

	public MedicineServiceImpl(MedicineRepository medicineRepository) {
		super();
		this.medicineRepository = medicineRepository;
	}

	@Override
	public List<Medicine> getAllMedicines() {
		return medicineRepository.findAll() ;
	}

	@Override
	public Medicine saveMedicine(Medicine medicine) {
		
		return medicineRepository.save(medicine);
	}

	@Override
	public Medicine getMedicineById(Integer id) {
		
		return medicineRepository.findById(id).get();
	}

	@Override
	public Medicine updateMedicine(Medicine medicine) {
		
		return medicineRepository.save(medicine);
	}

	@Override
	public void deleteMedicineById(Integer id) {
		
		medicineRepository.deleteById(id);
	}

	

}
