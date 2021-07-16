package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

/*
 * User service's interface and abstract methods
 */
public interface IUserService {

	// Abstract methods
	public User createUser(User user);

	public List<User> readUser();

	public String deleteUser(String id);

	public boolean isUserExist(String id);
}
