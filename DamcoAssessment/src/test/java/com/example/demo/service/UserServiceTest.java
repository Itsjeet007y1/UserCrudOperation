package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.User;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class UserServiceTest {

	@Autowired
	private IUserService userService;
	
	@Test
	@Order(1)
	public void testCreateUser() throws Exception {
		User userToSave = new User("1", "Jitendra", "Kumar", new Date(), "title1");
		userService.createUser(userToSave);
		assertNotNull(userService.isUserExist("1"));
	}

	@Test
	@Order(2)
	public void testGetUsers() throws Exception {
		List<User> listUser = userService.readUser();
		assertThat(listUser).size().isGreaterThan(0);
	}

	@Test
	@Order(3)
	public void testUpdateUser() throws Exception {
		User savedUser = userService.findUserByUserId("1");
		savedUser.setFirstName("Davinder");
		userService.createUser(savedUser);
		assertNotEquals("Jitendra", userService.findUserByUserId("1").getFirstName());
	}

	@Test
	@Order(4)
	public void testDeleteUser() throws Exception {
		userService.deleteUser("1");
		assertThat(userService.isUserExist("1")).isFalse();
	}
}
