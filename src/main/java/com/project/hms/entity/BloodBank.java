package com.project.hms.entity;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bloodbank", schema = "public")
public class BloodBank {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "blood_in_stock")
	private Integer bloodInStock;
	
	@Column(name = "expiry")
	private Date expiry;

	
	public BloodBank() {
	}

	public BloodBank(String type, Integer bloodInStock, Date expiry) {
		super();
		this.type = type;
		this.bloodInStock = bloodInStock;
		this.expiry = expiry;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getBloodInStock() {
		return bloodInStock;
	}

	public void setBloodInStock(Integer bloodInStock) {
		this.bloodInStock = bloodInStock;
	}

	public Date getExpiry() {
		return expiry;
	}

	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}
		
}
