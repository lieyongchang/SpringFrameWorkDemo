package com.example.RecipeWebApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

//	@RequestMapping(value = "/")
	@RequestMapping({ "", "/", "/index" })
	public String getIndexPage() {
		return "Index";
	}
}
