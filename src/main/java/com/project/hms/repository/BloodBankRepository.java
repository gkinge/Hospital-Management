package com.project.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.hms.entity.BloodBank;

@Repository
public interface BloodBankRepository extends JpaRepository<BloodBank ,Integer>{

}
