package com.project.hms.service;

import java.util.List;

import com.project.hms.entity.Nurse;

public interface NurseService {
	
	List<Nurse> getAllNurse();
	
	Nurse saveNurse(Nurse nurse);
		
	Nurse updateNurse(Nurse nurse);

	Nurse getNurseById(Integer id);

	void deleteNurseById(Integer id);
	
}
