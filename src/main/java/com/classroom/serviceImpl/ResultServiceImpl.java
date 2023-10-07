package com.classroom.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.classroom.global.exceptions.ResourceNotFoundException;
import com.classroom.model.Result;
import com.classroom.repositiory.ResultRepo;
import com.classroom.service.ResultService;
import com.classroom.service.UserService;

@Service
public class ResultServiceImpl implements ResultService {

	@Autowired
	private ResultRepo resultrepo;

	@Autowired
	private UserService userService;

	@Override
	public List<Result> getAllResults() {
		// TODO Auto-generated method stub
		return resultrepo.findAll();
	}

	@Override
	public Result addResult(Result result) {
		// TODO Auto-generated method stub
		return resultrepo.save(result);
	}

	@Override
	public Optional<Result> getResultById(int id) {
		return Optional.ofNullable(
				resultrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person", "Id", id)));
	}

	@Override
	public List<Result> getResultByStudentId(int id) {
		if (!userService.getUserById(id).isEmpty()) {
			return resultrepo.findByStudentId(id);
		}
		return null;
	}

	@Override
	public String deleteResult(int id) {
		resultrepo.delete(getResultById(id).get());
		return "Deleted";
	}

}
