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
	public ModelAndView register(String firstName, String lastName, String username, String password) {
		try {
			userService.save(new User(username, password, firstName, lastName, 1));
			return new ModelAndView("index");
		} catch (UserException ex) {
			return new ModelAndView("err", "message", ex.getMessage());
		}
	}

/*	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(String username, String password) {
		try {
			User user = userService.login(username, password);
			return new ModelAndView("welcome", "user", user.getFirstName());
		} catch (UserException ex) {
			return new ModelAndView("err", "message", ex.getMessage());
		}
	}
*/
}
