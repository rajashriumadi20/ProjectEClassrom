package com.classroom;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.classroom.model.Result;
import com.classroom.service.ResultService;

@SpringBootTest
class testResult {

	@Autowired
	private ResultService resultService;

	@Test
//	@Disabled
	void addResult() {
		assertNotNull(resultService.addResult(new Result(11, 7, "delete")));
	}

	@Test
	void getAllResults() {
		assertNotNull(resultService.getAllResults());
	}

	@Test
	void getResultById() {
		assertNotNull(resultService.getResultById(4));
	}

	@Test
	@Disabled
	void getResultByStudentId() {
		assertNotNull(resultService.getResultByStudentId(3));
	}

	@Test
	@Disabled
	void deleteResult() {
		assertNotNull(resultService.deleteResult(6));
	}
}
