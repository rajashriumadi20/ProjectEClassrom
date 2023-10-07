package com.classroom.service;

import java.util.List;
import java.util.Optional;

import com.classroom.model.User;

public interface UserService {
	public User registerUser(User user);

	public List<User> getAllUsers();
	public Optional<User> getUserById(int id);
	public User updateUser(User updatedUser);
	public  List<User> deleteUser(int id);
	public User loginUser(User user);
	public List<User> getAllStudents();
	public List<User> getAllTeachers();


}
