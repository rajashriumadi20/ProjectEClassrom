package com.classroom.service;

import com.classroom.model.Question;
import com.classroom.model.Quiz;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface QuizService {

    public Quiz addQuiz(Quiz quiz);

    public Quiz updateQuiz(Quiz quiz);

    public Set<Quiz> getQuizzes();

    public Quiz getQuiz(int quizId);

    public void deleteQuiz(int quizId);

    public List<Quiz> getActiveQuizzes();


}
