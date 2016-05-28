package com.mm.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mm.SimpleSpringCrudApplicationTests;
import com.mm.domain.User;
import com.mm.exception.UserException;

public class UserServiceTests extends SimpleSpringCrudApplicationTests {

	@Autowired
	private UserService userService;

	@Before
	public void setup() {

	}

	@Test
	public void login() {
		User user = userService.save(new User("mm", "1234", "M", "M"));
		assertNotNull(user);
		User u = userService.login("mm", "1234");
		assertNotNull(u);
		assertEquals(user, u);
	}

	@Test(expected = UserException.class)
	public void loginFailure() throws UserException {
		User u = userService.login("mm", "mm");
	}

}
