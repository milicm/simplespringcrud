package com.mm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "/WEB-INF/index.jsp";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String indexRegister() {
		return "/WEB-INF/register.jsp";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String indexLogin() {
		return "/WEB-INF/login.jsp";
	}
}
