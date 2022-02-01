package com.project.hms.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.project.hms.entity.User;

import com.project.hms.web.dto.*;



public interface UserService extends UserDetailsService{
	
	User save(UserRegistrationDto registrationDto);
	
}
