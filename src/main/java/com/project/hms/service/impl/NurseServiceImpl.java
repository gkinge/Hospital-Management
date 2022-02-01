package com.project.hms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.hms.entity.Nurse;
import com.project.hms.repository.NurseRepository;
import com.project.hms.service.NurseService;

@Service
public class NurseServiceImpl implements NurseService {
	
	private NurseRepository nurseRepository;
	

	public NurseServiceImpl(NurseRepository nurseRepository) {
		super();
		this.nurseRepository = nurseRepository;
	}

	@Override
	public List<Nurse> getAllNurse() {
		// TODO Auto-generated method stub
		return nurseRepository.findAll();
	}

	@Override
	public Nurse saveNurse(Nurse nurse) {
		
		return nurseRepository.save(nurse);
	}

	@Override
	public Nurse getNurseById(Integer id) {
		// TODO Auto-generated method stub
		return nurseRepository.findById(id).get();
	}

	@Override
	public Nurse updateNurse(Nurse nurse) {
		// TODO Auto-generated method stub
		return nurseRepository.save(nurse);
	}

	@Override
	public void deleteNurseById(Integer id) {
		
		nurseRepository.deleteById(id);
		
	}	

}
