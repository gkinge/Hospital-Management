package com.project.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.hms.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

}
