package com.project.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.hms.entity.Pharmacy;

public interface PharmacyRepo extends JpaRepository<Pharmacy, Integer> {

}

