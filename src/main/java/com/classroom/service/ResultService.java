package com.classroom.service;

import java.util.List;
import java.util.Optional;

import com.classroom.model.Result;

public interface ResultService {
	public Result addResult(Result result);

	public List<Result> getAllResults();

	public Optional<Result> getResultById(int id);

	public List<Result> getResultByStudentId(int id);

	public String deleteResult(int id);
}
