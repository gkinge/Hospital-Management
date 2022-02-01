package com.project.hms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Bill")
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "patient_id", nullable = false)
	private int patient_id;
	@Column(name = "doctor_charge", nullable = false)
	private int doctor_charge;
	@Column(name = "room_charge", nullable = false)
	private int room_charge;
	@Column(name = "no_of_days", nullable = false)
	private int no_of_days;
	@Column(name = "total")
	private int total;

	public Bill() {

	}

	public Bill(int patient_id, int doctor_charge, int room_charge, int no_of_days, int total) {
		super();
		this.patient_id = patient_id;
		this.doctor_charge = doctor_charge;
		this.room_charge = room_charge;
		this.no_of_days = no_of_days;
		this.total = total;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public int getDoctor_charge() {
		return doctor_charge;
	}

	public void setDoctor_charge(int doctor_charge) {
		this.doctor_charge = doctor_charge;
	}

	public int getRoom_charge() {
		return room_charge;
	}

	public void setRoom_charge(int room_charge) {
		this.room_charge = room_charge;
	}

	public int getNo_of_days() {
		return no_of_days;
	}

	public void setNo_of_days(int no_of_days) {
		this.no_of_days = no_of_days;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	//public void setId(Integer id2) {
		// TODO Auto-generated method stub
		
	//}
}
