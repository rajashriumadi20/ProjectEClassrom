package com.classroom.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.classroom.model.Question;
import com.classroom.model.Quiz;
import com.classroom.service.QuestionService;
import com.classroom.service.QuizService;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	private QuestionService questionService;

	@Autowired
	private QuizService quizService;

	// add question
	@PostMapping("/")
	public ResponseEntity<Question> add(@RequestBody Question question) {
		return ResponseEntity.ok(this.questionService.addQuestion(question));
	}

	@PostMapping("/add/{quizId}")
	public ResponseEntity<Question> addQuestionToQuiz(@PathVariable("quizId") int quizId,
			@RequestBody Question question) {// get quiz by id
		Quiz quiz = quizService.getQuiz(quizId);
		if (quiz == null) {
			return ResponseEntity.notFound().build(); // Returning 404 if quiz not found
		}
		// assign question with quiz
		question.setQuiz(quiz);
		Question addedQuestion = questionService.addQuestion(question);// this adds question

		// Return added question
		return ResponseEntity.ok(addedQuestion);
	}

	// update the question
	@PutMapping("/")
	public ResponseEntity<Question> update(@RequestBody Question question) {
		return ResponseEntity.ok(this.questionService.updateQuestion(question));
	}

	@GetMapping("/getallquestions")
	public Set<Question> getAllQuestions() {
		return questionService.getQuestions();
	}

	// get all question of any quid
	@GetMapping("/quiz/{qid}")
	public ResponseEntity<List<Question>> getQuestionsOfQuiz(@PathVariable("qid") int qid) {

		Quiz quiz = this.quizService.getQuiz(qid);

		Set<Question> questions = questionService.getQuestionsOfQuiz(quiz);

//		System.out.println("lsit sizr" + questions.size());

		List<Question> list = new ArrayList<Question>(questions);

		if (list.size() > Integer.parseInt(quiz.getNumberOfQuestions())) {
			list = list.subList(0, Integer.parseInt(quiz.getNumberOfQuestions() + 1));
		}
		Collections.shuffle(list);
		return ResponseEntity.ok(list);
	}

	@GetMapping("/quiz/all/{qid}")
	public ResponseEntity<?> getQuestionsOfQuizAdmin(@PathVariable("qid") int qid) {
		Quiz quiz = new Quiz();
		quiz.setqId(qid);
		Set<Question> questionsOfQuiz = this.questionService.getQuestionsOfQuiz(quiz);
		return ResponseEntity.ok(questionsOfQuiz);

	}

	// get single question
	@GetMapping("/{quesId}")
	public Question get(@PathVariable("quesId") int quesId) {
		return this.questionService.getQuestion(quesId);
	}

	// delete question
	@DeleteMapping("/{quesId}")
	public void delete(@PathVariable("quesId") int quesId) {
		this.questionService.deleteQuestion(quesId);
	}

	// eval quiz
	@PostMapping("/eval-quiz")
	public ResponseEntity<?> evalQuiz(@RequestBody List<Question> questions) {
		System.out.println(questions);
		double marksGot = 0;
		int correctAnswers = 0;
		int attempted = 0;
		for (Question q : questions) {
			// single questions
			Question question = this.questionService.get(q.getQuesId());
			if (question.getAnswer().equals(q.getGivenAnswer())) {
				// correct
				correctAnswers++;

				double marksSingle = Double.parseDouble(questions.get(0).getQuiz().getMaxMarks()) / questions.size();
				// this.questions[0].quiz.maxMarks / this.questions.length;
				marksGot += marksSingle;

			}

			if (q.getGivenAnswer() != null) {
				attempted++;
			}

		}
		;

		Map<String, Object> map = Map.of("marksGot", marksGot, "correctAnswers", correctAnswers, "attempted",
				attempted);
		return ResponseEntity.ok(map);

	}

}
