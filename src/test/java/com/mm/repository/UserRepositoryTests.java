package com.mm.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mm.SimpleSpringCrudApplicationTests;
import com.mm.domain.User;

public class UserRepositoryTests extends SimpleSpringCrudApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Before
	public void setup() {
	}
	
	@Test
	public void save() {
		User user = userRepository.save(new User("admin", "admin", "John", "Doe"));
		assertNotNull(user);
	}

	@Test
	public void find() {
		User user = userRepository.save(new User("x", "x", "John", "Doe"));
		assertNotNull(user);
		User u = userRepository.findOne(user.getId());
		assertNotNull(u);
		assertEquals(user, u);
	}

	@Test
	public void findAll() {
		User u = userRepository.save(new User("a", "a", "a", "a"));
		assertNotNull(u);
		List<User> users = userRepository.findAll();
		assertNotNull(users);
		assertFalse(users.isEmpty());
	}

	@Test
	public void delete() {
		User u = userRepository.save(new User("b", "b", "b", "b"));
		assertNotNull(u);
		userRepository.delete(u.getId());
		User deletedUser = userRepository.findOne(u.getId());
		assertNull(deletedUser);

	}

	@Test
	public void update() {
		User u = userRepository.save(new User("c", "c", "c", "c"));
		assertNotNull(u);
		u.setFirstName("John");
		u.setLastName("Doe");
		u.setPassword("cc");
		User updatedUser = userRepository.save(u);
		assertNotNull(updatedUser);
		assertEquals(u, updatedUser);
	}
	
	@Test
	public void login() {
		User u = userRepository.save(new User("d", "d", "d", "d"));
		User loggedUser = userRepository.login(u.getUsername(), u.getPassword());
		assertNotNull(loggedUser);
		assertEquals(u, loggedUser);
	}

}
