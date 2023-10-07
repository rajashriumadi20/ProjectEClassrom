package com.classroom.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.classroom.global.exceptions.ResourceNotFoundException;
import com.classroom.model.Notes;
import com.classroom.repositiory.NotesRepo;
import com.classroom.service.NotesService;

@Service
public class NotesServiceImpl implements NotesService {

	@Autowired
	private NotesRepo notesrepo;

	@Override
	public Notes addNotes(Notes note) {
		// TODO Auto-generated method stub
		return notesrepo.save(note);
	}

	@Override
	public List<Notes> getAllNotes() {
		// TODO Auto-generated method stub
		return notesrepo.findAll();
	}

	@Override
	public void deleteNotes(int id) {
		// TODO Auto-generated method stub
		notesrepo.deleteById(id);
	}

	@Override
	public Notes updateUser(Notes updatedNotes) {
		// TODO Auto-generated method stub
		getUserById(updatedNotes.getId());
		return notesrepo.save(updatedNotes);
	}

	@Override
	public Optional<Notes> getUserById(int id) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(
				notesrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person", "Id", id)));
	}

}
