package com.classroom.service;

import java.util.List;
import java.util.Optional;

import com.classroom.model.Notes;

public interface NotesService {

	public Notes addNotes(Notes note);

	public List<Notes> getAllNotes();

	// Object updateUser(Notes updatedNotes);

	public void deleteNotes(int id);

	public Notes updateUser(Notes updatedNotes);

	public Optional<Notes> getUserById(int id);
}
