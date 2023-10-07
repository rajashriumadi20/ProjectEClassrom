package com.classroom.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.classroom.global.exceptions.ResourceNotFoundException;
import com.classroom.model.User;
import com.classroom.repositiory.UserRepo;
import com.classroom.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;

	@Override
	public Optional<User> getUserById(int id) {
		return Optional
				.ofNullable(userRepo.findById(id).orElseThrow(() ->
				new ResourceNotFoundException("Person", "Id", id)));
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public User registerUser(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	@Override
	public User updateUser(User updatedUser) {
		getUserById(updatedUser.getId());
		return userRepo.save(updatedUser);
	}

	@Override
	public List<User> deleteUser(int id) {
		User user = getUserById(id).get();
		userRepo.delete(user);
		return userRepo.findAll();		

	}
	@Override
	public User loginUser(User user) {
		// TODO Auto-generated method stub
		System.out.println("inside login serviceimpl");
		return userRepo.findByUsernameAndPassword(user.getUsername(),user.getPassword());
	}

	@Override
	public List<User> getAllStudents() {
		// TODO Auto-generated method stub
		return userRepo.findByRole("student");
	}

	@Override
	public List<User> getAllTeachers() {
		// TODO Auto-generated method stub
		return userRepo.findByRole("teacher");
	}
}
