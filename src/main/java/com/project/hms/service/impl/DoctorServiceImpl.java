package com.project.hms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.hms.entity.Doctor;
import com.project.hms.repository.DoctorRepository;
import com.project.hms.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{

		private DoctorRepository doctorRepository;
		
		public DoctorServiceImpl(DoctorRepository doctorRepository) {
			super();
			this.doctorRepository = doctorRepository;
		}

		//1.LIST
		@Override
		public List<Doctor> getAllDoctors() {
			return doctorRepository.findAll();
		}

		//2.SAVE
		@Override
		public Doctor saveDoctor(Doctor doctor) {
			return doctorRepository.save(doctor);
		}

		//3.GET BY ID
		@Override
		public Doctor getDoctorById(Integer id) {
			return doctorRepository.findById(id).get();
		}

		//4.UPDATE
		@Override
		public Doctor updateDoctor(Doctor doctor) {
			return doctorRepository.save(doctor);
		}

		//5.DELETE
		@Override
		public void deleteDoctorById(Integer id) {
			doctorRepository.deleteById(id);	
		}

}
