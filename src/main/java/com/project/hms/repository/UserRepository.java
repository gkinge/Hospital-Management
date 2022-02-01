package com.project.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.hms.entity.User;



@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
	
	User findByEmail(String email);
}
