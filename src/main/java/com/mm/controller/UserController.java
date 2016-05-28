package com.mm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mm.domain.User;
import com.mm.exception.UserException;
import com.mm.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(String firstName, String lastName, String username, String password) {
		userService.save(new User(username, password, firstName, lastName));
		return "/WEB-INF/index.jsp";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(String username, String password) {
		try {
			User user = userService.login(username, password);
			return new ModelAndView("/WEB-INF/welcome.jsp", "user", user.getFirstName());
		} catch (UserException ex) {
			return new ModelAndView("/WEB-INF/error.jsp", "message", ex.getMessage());
		}
	}

}
