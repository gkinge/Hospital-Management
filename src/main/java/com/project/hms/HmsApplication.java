package com.project.hms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class HmsApplication{

	public static void main(String[] args) {
		SpringApplication.run(HmsApplication.class, args);
	}

	
	/*
	@Override
	public void run(String... args) throws Exception{
		
		Pharmacy pharm1 = new Pharmacy("Paracetemol","Headach",10,"Sleep", 2300);
		pharmacyRepo.save(pharm1);
		
		Pharmacy pharm2 = new Pharmacy("Enzoflam","Toothache",30,"Sleep", 2300);
		pharmacyRepo.save(pharm2);
		
	}
	*/
}
