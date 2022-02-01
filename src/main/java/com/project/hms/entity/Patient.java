package com.project.hms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "Patient", schema ="public")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Patient_Id")
	private Integer id;
	
	@Column(name = "Patient_Name")
	@NotEmpty(message = "Name Can't Be Empty")
	private String name;
	
	@Column(name = "Patient_MobileNo")
	//@NotEmpty(message = "Mobile Can't Be Empty")
	private long mobile;
	
	@Column(name = "DoctorsName")
	private String DocName;
	
	@Column(name = "Diagnosis")
	private String diagnosis;
	
	
	@Email
	@Column(name = "email")
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message="Email address is invalid")
	private String email;
	
	@OneToOne(mappedBy = "patient")
    private Medicine medicine;
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
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

	public String getDocName() {
		return DocName;
	}

	public void setDocName(String docName) {
		DocName = docName;
	}
	public Patient() {
		
	}
	
	public Patient( String name, long mobile, String docName, String diagnosis, String email) {
		super();
		this.name = name;
		this.mobile = mobile;
		DocName = docName;
		this.diagnosis = diagnosis;
		this.email = email;
	}
}
