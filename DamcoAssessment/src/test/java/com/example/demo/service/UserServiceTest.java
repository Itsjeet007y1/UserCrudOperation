package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.model.User;

@WebMvcTest
public class UserServiceTest {

	@MockBean
	private IUserService userService;

	@Test
	public void testGetUsers() throws Exception {

		List<User> listUser = new ArrayList<>();

		listUser.add(new User("1", "Jitendra", "Kumar", new Date(), "Title1"));
		listUser.add(new User("2", "Aman", "Kumar", new Date(), "Title2"));
		listUser.add(new User("3", "Amit", "Kumar", new Date(), "Title3"));
		listUser.add(new User("4", "Suresh", "Kumar", new Date(), "Title4"));

		Mockito.when(userService.readUser()).thenReturn(listUser);

		List<User> expected = userService.readUser();

		assertThat(listUser).isSameAs(expected);
	}

	@Test
	public void testCreateUser() throws Exception {
		User user = new User("1", "Jitendra", "Kumar", new Date(), "title1");
		User savedUser = new User("1", "Jitendra", "Kumar", new Date(), "title1");

		Mockito.when(userService.createUser(user)).thenReturn(savedUser);

		User actual = userService.createUser(user);

		assertThat(actual).isSameAs(savedUser);
	}

	@Test
	public void testUpdateUser() throws Exception {
		User existingUser = new User("1", "Jitendra", "Kumar", new Date(), "title1");
		User savedUser = new User("1", "Jackson", "Kumar", new Date(), "title1");

		Mockito.when(userService.createUser(existingUser)).thenReturn(savedUser);

		User actual = userService.createUser(existingUser);

		assertThat(actual).isSameAs(savedUser);
	}

	@Test
	public void testDeleteUser() throws Exception {
		String id = "1";

		Mockito.when(userService.deleteUser(id)).thenReturn("User with id: " + id + " deleted successfully.");
		String deletedRecord = userService.deleteUser(id);
		String expected = "User with id: " + id + " deleted successfully.";

		assertEquals(deletedRecord, expected);
	}
}
