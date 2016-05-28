package com.mm.service;

import com.mm.domain.User;
import com.mm.exception.UserException;

public interface UserService {

	User login(String username, String password) throws UserException;

}
