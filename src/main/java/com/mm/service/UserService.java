package com.mm.service;

import com.mm.domain.User;
import com.mm.exception.UserException;

public interface UserService {

	User save(User user) throws UserException;

	User login(String username, String password) throws UserException;

}
