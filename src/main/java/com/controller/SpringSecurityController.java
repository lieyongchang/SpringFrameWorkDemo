package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SpringSecurityController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String LoginPage(Model model, HttpServletRequest request) {

		if (request.isUserInRole("ROLE_ADMIN")) {
			// redirect to indexAdmin.html page
			return "user/userList";
		}
		return "login";

	}
}
