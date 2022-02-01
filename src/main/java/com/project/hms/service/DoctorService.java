package com.project.hms.service;

import java.util.List;

import com.project.hms.entity.Doctor;

public interface DoctorService {
	List<Doctor> getAllDoctors();
	
	Doctor saveDoctor(Doctor doctor);
	
	Doctor getDoctorById(Integer id);
	
	Doctor updateDoctor(Doctor doctor);
	
	void deleteDoctorById(Integer id);
}
