package com.classroom.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.classroom.model.Notes;
import com.classroom.service.NotesService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/notes")
@CrossOrigin("*")
public class NotesController {
	@Autowired
	private NotesService noteservice;

	List<String> files = new ArrayList<String>();

	@PostMapping("/savefile")
	public ResponseEntity<?> handleFileUpload(@RequestParam("noteFile") MultipartFile noteFile,
			@RequestParam("noteTitle") String noteTitle) throws IOException {
		Notes note = new Notes();
		note.setTitle(noteTitle);
		note.setNote(noteFile.getBytes());
		return new ResponseEntity<Notes>(noteservice.addNotes(note), HttpStatus.CREATED);
	}
	
	@GetMapping("/get")
	public List<Notes> getAllNotes() {
//		System.out.println("get all  notes");
		return noteservice.getAllNotes();
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Notes> updateUser(@PathVariable int id, @Validated @RequestBody Notes notes) {
		notes.setId(id);
		return new ResponseEntity<Notes>(noteservice.updateUser(notes), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteNotes(@PathVariable int id) {
		noteservice.deleteNotes(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(path = "/get/{id}")
	public ResponseEntity<Resource> download(@PathVariable int id) throws IOException {

		Notes notes = noteservice.getUserById(id).get();

		ByteArrayResource resource = new ByteArrayResource(notes.getNote());

		return ResponseEntity.ok().headers(this.headers(notes.getTitle())).contentLength(resource.contentLength())
				.contentType(MediaType.parseMediaType("application/pdf")).body(resource);
	}

	private HttpHeaders headers(String name) {

		HttpHeaders header = new HttpHeaders();
		header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + name + ".pdf");
		header.add("Cache-Control", "no-cache, no-store, must-revalidate");
		header.add("Pragma", "no-cache");
		header.add("Expires", "0");
		return header;
	}

}