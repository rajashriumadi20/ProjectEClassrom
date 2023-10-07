package com.classroom.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Attendence")
public class Attendence {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private int rollNo;
	private boolean present;
	private Date date;
	//private String Teacher;
	public Attendence() {

	}

	public Attendence(int rollNo, boolean present, Date date) {
		super();
		this.rollNo = rollNo;
		this.present = present;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public boolean isPresent() {
		return present;
	}

	public void setPresent(boolean present) {
		this.present = present;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
