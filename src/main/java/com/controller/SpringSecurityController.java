package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringSecurityController {

	@RequestMapping(value = "/login")
	public String LoginPage() {

		return "/login";

	}

	@RequestMapping(value = "/403")
	public String error403() {
		return "/error/403";
	}
}
