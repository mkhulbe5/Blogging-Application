package com.mohit.blog.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mohit.blog.entities.User;
import com.mohit.blog.payload.UserDTO;
import com.mohit.blog.repositories.UserRepo;
import com.mohit.blog.services.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	
	@Override
	public UserDTO createUser(UserDTO userdto) {
		// TODO Auto-generated method stub
		
		User user = this.dtoToUser(userdto);
		User savedUser = this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDTO updateUser(UserDTO user, Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO getUserById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDTO> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		
	}
	
	private User dtoToUser(UserDTO userDto) {
		User user = new User();
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		return user;
	}
	
	private UserDTO userToDto(User user) {
		UserDTO userDto = new UserDTO();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		userDto.setPassword(user.getPassword());
		userDto.setAbout(user.getAbout());
		return userDto;
	}

}
