package com.mohit.blog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mohit.blog.entities.User;
import com.mohit.blog.payload.UserDTO;

public interface UserService {

	UserDTO createUser(UserDTO user);
	UserDTO updateUser(UserDTO user,Integer userId);
	UserDTO getUserById(Integer userId);
	List<UserDTO> getAllUsers();
	
	void deleteUser(Integer userId);
	
}
