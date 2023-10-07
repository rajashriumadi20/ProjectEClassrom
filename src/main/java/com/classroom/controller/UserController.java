package com.classroom.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.classroom.model.User;
import com.classroom.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/add")
	public ResponseEntity<User> saveUser(@Validated @RequestBody User user) {
		System.out.println(user);
		System.out.println("This is new Code");
		return new ResponseEntity<User>(userService.registerUser(user), HttpStatus.CREATED);
	}

	@GetMapping("/get")
	public List<User> getAllUsers() {
		System.out.println("get all  users");
		return userService.getAllUsers();
	}

	@GetMapping("/get/students")
	public List<User> getAllStudents() {
		System.out.println("get all  students");
		return userService.getAllStudents();
	}

	@GetMapping("/byid/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) {
		return new ResponseEntity<>(userService.getUserById(id).get(), HttpStatus.OK);
	}

	@GetMapping("/onebyid/{id}")
	public User getOneUserById(@PathVariable int id) {
		return (userService.getUserById(id).get());
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id, @Validated @RequestBody User updatedUser) {
		updatedUser.setId(id);
		return new ResponseEntity<>(userService.updateUser(updatedUser), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public List<User> deleteUser(@PathVariable int id) {
		return userService.deleteUser(id);
	}

	@PostMapping("/logincheck")
	public ResponseEntity<User> loginUser(@Validated @RequestBody User user) {
		System.out.println(user);
		System.out.println("This is new Code");
		return new ResponseEntity<User>(userService.loginUser(user), HttpStatus.OK);
	}

}
