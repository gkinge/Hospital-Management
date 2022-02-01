package com.project.hms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Nurse", schema = "public")
public class Nurse {
	
	@Id
	@Column(name = "Nurse_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "Nurse_Name")
	private String name;
	
	@Column(name = "Nurse_Mobile")
	private long mobile;
	
	@Column(name = "Nurse_Email")
	private String email;
	
	@Column(name = "Nurse_Shift")
	private String shift;

	public Nurse() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public Nurse(String name, long mobile, String email, String shift) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.shift = shift;
	}
	
	

}