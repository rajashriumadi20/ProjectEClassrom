package com.classroom.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notes")
public class Notes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(columnDefinition = "LONGBLOB")

	private byte[] note;
	@Column(name = "title")
	private String title;
	private String fileName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Notes() {

	}

	public Notes(byte[] note, String title, String fileName) {
		super();
		this.note = note;
		this.title = title;
		this.fileName = fileName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getNote() {
		return note;
	}

	public void setNote(byte[] note) {
		this.note = note;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Notes [id=" + id + ", note=" + Arrays.toString(note) + ", title=" + title + "]";
	}

}