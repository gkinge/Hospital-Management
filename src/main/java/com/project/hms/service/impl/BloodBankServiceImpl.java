package com.project.hms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.hms.entity.BloodBank;
import com.project.hms.repository.BloodBankRepository;
import com.project.hms.service.BloodBankService;

@Service
public class BloodBankServiceImpl implements BloodBankService {
	
	private BloodBankRepository bloodbankRepository;
	
	public BloodBankServiceImpl(BloodBankRepository bloodbankRepository) {
		super();
		this.bloodbankRepository = bloodbankRepository;
	}

	//1.LIST
	@Override
	public List<BloodBank> getAllBloodBank() {
		return bloodbankRepository.findAll();
	}

	//2.SAVE
	@Override
	public BloodBank saveBloodBank(BloodBank bloodbank) {
		return bloodbankRepository.save(bloodbank);
	}

	//3.GET BY ID
	@Override
	public BloodBank getBloodBankById(Integer id) {
		return bloodbankRepository.findById(id).get();
	}

	//4.UPDATE
	@Override
	public BloodBank updateBloodBank(BloodBank bloodbank) {
		return bloodbankRepository.save(bloodbank);
	}

	//5.DELETE
	@Override
	public void deleteBloodBankById(Integer id) {
		bloodbankRepository.deleteById(id);	
	}
}
