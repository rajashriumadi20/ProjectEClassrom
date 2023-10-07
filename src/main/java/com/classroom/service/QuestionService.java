package com.classroom.service;

import com.classroom.model.Question;
import com.classroom.model.Quiz;

import java.util.Set;

public interface QuestionService {

    public Question addQuestion(Question question);

    public Question updateQuestion(Question question);

    public Set<Question> getQuestions();

    public Question getQuestion(int questionId);

    public Set<Question> getQuestionsOfQuiz(Quiz quiz);

    public void deleteQuestion(int quesId);

    public Question get(int questionsId);

}
