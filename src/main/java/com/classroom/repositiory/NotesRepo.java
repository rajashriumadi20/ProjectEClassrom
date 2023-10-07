package com.classroom.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;
import com.classroom.model.Notes;

public interface NotesRepo extends JpaRepository<Notes,Integer> {
	
	

}
