package com.mm.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mm.domain.User;
import com.mm.exception.UserException;
import com.mm.repository.UserRepository;
import com.mm.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User login(String username, String password) throws UserException {
		User user = userRepository.login(username, password);
		if (user == null) {
			throw new UserException("User not found!");
		}
		return user;
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

}
