package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.IUserService;

/*
 * user service interface's implementation class for CRUD operations
 */
@Service // Generic annotation for service layer
public class UserService implements IUserService {

	@Autowired
	UserRepository userRepository; // Auto Injecting repository object in user service class

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> readUser() {
		return userRepository.findAll();
	}

	@Override
	public String deleteUser(String id) {
		int userId = userRepository.deleteByUserId(id);
		return "User with id: " + userId + " deleted successfully.";
	}

	@Override
	public boolean isUserExist(String id) {
		return userRepository.existsById(id);
	}
}
