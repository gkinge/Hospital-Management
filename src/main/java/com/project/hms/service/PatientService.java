package com.project.hms.service;

import java.util.List;

import com.project.hms.entity.Patient;

public interface PatientService {
	List<Patient> getAllPatient();
	
	Patient savePatient(Patient patient);
		
	Patient updatePatient(Patient patient);

	Patient getPatientById(Integer id);

	void deletePatientById(Integer id);
}

