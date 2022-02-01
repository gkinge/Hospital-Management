package com.project.hms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hms.entity.Pharmacy;
import com.project.hms.repository.PharmacyRepo;
import com.project.hms.service.PharmacyService;

@Service
public class PharmacyServiceImpl implements PharmacyService {
	
	@Autowired
	private PharmacyRepo pharmacyRepo;
	/*
	public PharmacyServiceImpl(PharmacyRepo pharmacyRepo) {
		super();
		this.pharmacyRepo = pharmacyRepo;
	}
	*/

	@Override
	public List<Pharmacy> getAllPharmacy(){
		return pharmacyRepo.findAll();
	}
	
	@Override
	public Pharmacy savePharmacy(Pharmacy pharm) {
		return pharmacyRepo.save(pharm);
	}
	
	@Override
	public Pharmacy getPharmacyById(Integer id) {
		return pharmacyRepo.findById(id).get();
	}
	
	@Override
	public Pharmacy updatePharmacy(Pharmacy pharm) {
		return pharmacyRepo.save(pharm);
	}
	
	@Override
	public void deletePharmacyById(Integer id) {
		pharmacyRepo.deleteById(id);	
	}
	
	
}
