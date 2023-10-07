package com.classroom.repositiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.classroom.model.Result;

public interface ResultRepo extends JpaRepository<Result, Integer> {
	public List<Result> findByStudentId(int studentId);

}
