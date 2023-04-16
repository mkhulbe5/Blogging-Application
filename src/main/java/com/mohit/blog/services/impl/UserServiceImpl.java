package com.mohit.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.mohit.blog.exceptions.*;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohit.blog.entities.User;
import com.mohit.blog.payload.UserDTO;
import com.mohit.blog.repositories.UserRepo;
import com.mohit.blog.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDTO createUser(UserDTO userdto) {
		// TODO Auto-generated method stub
		
		User user = this.dtoToUser(userdto);
		User savedUser = this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDTO updateUser(UserDTO userDto, Integer userId) {
		// TODO Auto-generated method stub
		User user= this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
		
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		User updatedUser = this.userRepo.save(user);
		UserDTO userdto1 =  this.userToDto(updatedUser); 
		return userdto1;
	}

	@Override
	public UserDTO getUserById(Integer userId) {
		// TODO Auto-generated method stub
		User user= this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
		return this.userToDto(user);
	}

	@Override
	public List<UserDTO> getAllUsers() {
		// TODO Auto-generated metho
		List<User> users =  this.userRepo.findAll();
		 List<UserDTO> userDtos =  users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		return userDtos; 
	}

	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		User user= this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
		this.userRepo.delete(user);
		
	}
	
	private User dtoToUser(UserDTO userDto) {
		User user = this.modelMapper.map(userDto,User.class);
		return user;
	}
	
	private UserDTO userToDto(User user) {
		UserDTO userDto = this.modelMapper.map(user, UserDTO.class);
		return userDto;
	}

}
