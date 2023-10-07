package com.classroom;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.classroom.model.Notes;
import com.classroom.service.NotesService;

@SpringBootTest
class testNotes {

	@Autowired
	private NotesService notesService;

	@Test
	void getAllNotes() {
		assertNotNull(notesService.getAllNotes());
	}

	@Test
//	@Disabled
	void addNotes() {
		assertNotNull(notesService.addNotes(new Notes(new byte[] { (byte) 0xe0 }, "testNote", "Test")));
	}

	@Test
	void getUserById() {
		assertNotNull(notesService.getUserById(1));
	}
//	@Test
//	void deleteNotes() {
//		assertNotNull(notesService.deleteNotes(8));
//	}

	@Test
	@Disabled
	void test() {
		fail("Not yet implemented");
	}

}
