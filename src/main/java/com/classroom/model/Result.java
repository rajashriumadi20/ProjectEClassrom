package com.classroom.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Result")
public class Result {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rid;
	private int marks;
	private int maxmarks;
	private int studentId;
	private String subject;
	private String name;

	public Result() {

	}

	public Result(int marks, int studentId, String subject) {
		super();
		this.marks = marks;
		this.studentId = studentId;
		this.subject = subject;
	}

	public int getMaxmarks() {
		return maxmarks;
	}

	public void setMaxmarks(int maxmarks) {
		this.maxmarks = maxmarks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Result [rid=" + rid + ", marks=" + marks + ", maxmarks=" + maxmarks + ", studentId=" + studentId
				+ ", subject=" + subject + ", name=" + name + "]";
	}

}
