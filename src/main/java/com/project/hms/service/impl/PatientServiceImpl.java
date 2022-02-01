package com.project.hms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.hms.entity.Patient;
import com.project.hms.repository.PatientRepository;
import com.project.hms.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{
	
	private PatientRepository patientRepository;
	

	public PatientServiceImpl(PatientRepository patientRepository) {
		super();
		this.patientRepository = patientRepository;
	}

	@Override
	public List<Patient> getAllPatient() {
		// TODO Auto-generated method stub
		return patientRepository.findAll();
	}

	@Override
	public Patient savePatient(Patient patient) {
		
		return patientRepository.save(patient);
	}

	@Override
	public Patient getPatientById(Integer id) {
		// TODO Auto-generated method stub
		return patientRepository.findById(id).get();
	}

	@Override
	public Patient updatePatient(Patient patient) {
		// TODO Auto-generated method stub
		return patientRepository.save(patient);
	}

	@Override
	public void deletePatientById(Integer id) {
		
		patientRepository.deleteById(id);
		
	}	
}
