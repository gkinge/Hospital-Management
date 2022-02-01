package com.project.hms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pharmacy", schema = "public")
public class Pharmacy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "med_name", nullable = false)
	private String medName;
	
	@Column(name = "med_use")
	private String medUse;
	
	@Column(name = "med_cost")
	private Integer medCost;
	
	@Column(name = "med_sideEffects")
	private String medSideEffects;
	
	@Column(name = "med_inStock")
	private Integer medInStock;
	
	public Pharmacy() {
		
	}

	public Pharmacy(String medName, String medUse, Integer medCost, String medSideEffects, Integer medInStock) {
		super();
		this.medName = medName;
		this.medUse = medUse;
		this.medCost = medCost;
		this.medSideEffects = medSideEffects;
		this.medInStock = medInStock;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMedName() {
		return medName;
	}

	public void setMedName(String medName) {
		this.medName = medName;
	}

	public String getMedUse() {
		return medUse;
	}

	public void setMedUse(String medUse) {
		this.medUse = medUse;
	}

	public Integer getMedCost() {
		return medCost;
	}

	public void setMedCost(Integer medCost) {
		this.medCost = medCost;
	}

	public String getMedSideEffects() {
		return medSideEffects;
	}

	public void setMedSideEffects(String medSideEffects) {
		this.medSideEffects = medSideEffects;
	}

	public Integer getMedInStock() {
		return medInStock;
	}

	public void setMedInStock(Integer medInStock) {
		this.medInStock = medInStock;
	}
	
	
}
