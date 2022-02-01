package com.project.hms.service;

import java.util.List;

import com.project.hms.entity.BloodBank;


public interface BloodBankService {
	List<BloodBank> getAllBloodBank();
	
	BloodBank saveBloodBank(BloodBank bloodbank);
		
	BloodBank updateBloodBank(BloodBank bloodbank);

	BloodBank getBloodBankById(Integer id);

	void deleteBloodBankById(Integer id);
	
}
