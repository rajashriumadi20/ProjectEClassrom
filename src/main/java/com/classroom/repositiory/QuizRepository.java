package com.classroom.repositiory;

import com.classroom.model.Question;
import com.classroom.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
    
import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {

    public List<Quiz> findByActive(Boolean b);

}
