package com.classroom;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.classroom.service.QuestionService;

@SpringBootTest
class testQuestion {

	@Autowired
	private QuestionService questionService;

	@Test
	void getQuestions() {
		assertNotNull(questionService.getQuestions());
	}

	@Test
	void getQuestion() {
		assertNotNull(questionService.getQuestion(1));
	}

	@Test
	void get() {
		assertNotNull(questionService.get(6));
	}

	@Test
	@Disabled
	void test() {
		fail("Not yet implemented");
	}

}
