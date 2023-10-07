package com.classroom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.classroom.model.Result;
import com.classroom.service.ResultService;

@RestController
@RequestMapping("/result")
@CrossOrigin(origins = "http://localhost:4200")
public class ResultController {
	@Autowired
	private ResultService resultService;

	@PostMapping("/add")
	public ResponseEntity<Result> saveUser(@RequestBody Result result) {
		System.out.println(result);
		return new ResponseEntity<Result>(resultService.addResult(result), HttpStatus.CREATED);
	}

	@GetMapping("/get")
	public List<Result> getAllResults() {
		return resultService.getAllResults();
	}

	@GetMapping("/bystudid/{id}")
	public ResponseEntity<List<Result>> getUserById(@PathVariable int id) {
		return new ResponseEntity<>(resultService.getResultByStudentId(id), HttpStatus.OK);
	}
}
