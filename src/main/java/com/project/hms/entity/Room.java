package com.project.hms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Room")
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "r_type", nullable = false)
	//@NotEmpty(message = "Field can't be empty!")
	private String r_type;
	@Column(name = "price", nullable = false)
	private String price;
	
	public Room() {

	}

	public Room(Integer id, String r_type, String price) {
		super();
		this.id = id;
		this.r_type = r_type;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getR_type() {
		return r_type;
	}

	public void setR_type(String r_type) {
		this.r_type = r_type;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
}
