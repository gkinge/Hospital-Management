package com.project.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.hms.entity.Bill;



public interface BillRepository extends JpaRepository<Bill, Integer>{

}
