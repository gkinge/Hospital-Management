package com.project.hms.service;

import java.util.List;

import com.project.hms.entity.Pharmacy;

public interface PharmacyService {
	List<Pharmacy> getAllPharmacy();
	
	Pharmacy savePharmacy(Pharmacy pharm);
	
	Pharmacy getPharmacyById(Integer id);
	
	Pharmacy updatePharmacy(Pharmacy pharm);

	void deletePharmacyById(Integer id);

}
