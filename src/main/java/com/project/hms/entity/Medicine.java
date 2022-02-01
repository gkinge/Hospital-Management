package com.project.hms.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table (name="medicines")
public class Medicine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private  Integer id;
	
	@Column(name="Patient_Id")
	private Integer patient_id;
	
	@Column (name="date",nullable = false)
	private Date date;
	@Column (name="problem")
	private String problem;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "patient_medicine", 
      joinColumns = 
        { @JoinColumn(name = "patient_id", referencedColumnName = "id") },
      inverseJoinColumns = 
        { @JoinColumn(name = "medicine_id", referencedColumnName = "patient_id") })
    private Patient patient;
	
	public Medicine(Integer patient_id, Date date, String problem) {
		super();
		this.patient_id = patient_id;
		this.date = date;
		this.problem = problem;
	}
	public Medicine() {
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(Integer patient_id) {
		this.patient_id = patient_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	
	
	
	
	
	


}