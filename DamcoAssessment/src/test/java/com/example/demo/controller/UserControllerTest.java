package com.example.demo.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.example.demo.model.ResponseDefObject;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.impl.UserService;
import com.example.demo.utility.Util;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private UserService userService;

	@MockBean
	private UserRepository userRepository;

	@Test
	public void testGetUsers() throws Exception {

		List<User> listUser = new ArrayList<>();

		listUser.add(new User("1", "Jitendra", "Kumar", new Date(), "Title1"));
		listUser.add(new User("2", "Aman", "Kumar", new Date(), "Title2"));
		listUser.add(new User("3", "Amit", "Kumar", new Date(), "Title3"));
		listUser.add(new User("4", "Suresh", "Kumar", new Date(), "Title4"));

		Mockito.when(userService.readUser()).thenReturn(listUser);

		String url = "/getusers";

		MvcResult mvcResult = mockMvc.perform(get(url)).andExpect(status().isAccepted()).andReturn();

		String actualJsonResponse = mvcResult.getResponse().getContentAsString();
		JSONObject jsonObjectResponse = new JSONObject(actualJsonResponse);
		String actual = jsonObjectResponse.getString("data");

		String exptectedJsonResponse = objectMapper
				.writeValueAsString(new ResponseEntity<ResponseDefObject<List<User>>>(
						new ResponseDefObject<List<User>>(HttpStatus.CREATED.value(), Util.SUCCESS, listUser),
						HttpStatus.ACCEPTED));

		JSONObject jsonObject = new JSONObject(exptectedJsonResponse);
		System.out.println(exptectedJsonResponse);
		String getBody = jsonObject.getString("body");
		JSONObject jsonObjectBody = new JSONObject(getBody);
		String expected = jsonObjectBody.getString("data");

		assertThat(actual).isEqualToIgnoringWhitespace(expected);
	}

	@Test
	public void testCreateUser() throws Exception {
		User user = new User("1", "Jitendra", "Kumar", new Date(), "title1");
		User savedUser = new User("1", "Jitendra", "Kumar", new Date(), "title1");

		Mockito.when(userService.createUser(user)).thenReturn(savedUser);

		String url = "/saveuser";

		mockMvc.perform(post(url).contentType("application/json").content(objectMapper.writeValueAsString(user)))
				.andExpect(status().isAccepted());
	}

	@Test
	public void testUpdateUser() throws Exception {
		User existingUser = new User("1", "Jitendra", "Kumar", new Date(), "title1");
		User savedUser = new User("1", "Jackson", "Kumar", new Date(), "title1");

		Mockito.when(userService.createUser(existingUser)).thenReturn(savedUser);

		String url = "/saveuser";

		mockMvc.perform(
				post(url).contentType("application/json").content(objectMapper.writeValueAsString(existingUser)))
				.andExpect(status().isAccepted());
	}

	@Test
	public void testDeleteUser() throws Exception {
		String id = "1";

		Mockito.when(userService.deleteUser(id)).thenReturn("User with id: " + id + " deleted successfully.");

		String url = "/deleteuser/" + id;

		mockMvc.perform(delete(url)).andExpect(status().isAccepted());

		Mockito.verify(userService, times(1)).deleteUser(id);
	}
}
