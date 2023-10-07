package com.classroom.repositiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.classroom.model.User;

public interface UserRepo extends JpaRepository<User,Integer>{
	User findByUsernameAndPassword(String username,String password );
	List<User> findByRole(String role);

}
