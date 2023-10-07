package com.classroom.repositiory;

import com.classroom.model.Question;
import com.classroom.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Set<Question> findByQuiz(Quiz quiz);
    
}
