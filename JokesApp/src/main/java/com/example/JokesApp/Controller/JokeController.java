package com.example.JokesApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.JokesApp.Services.IJokeServices;

@Controller
public class JokeController {

	private IJokeServices jokeService;

	@Autowired
	public JokeController(IJokeServices jokeService) {
		this.jokeService = jokeService;
	}

	@RequestMapping({ "/", "" })
	public String DisplayJokes(Model model) {
		model.addAttribute("joke", jokeService.getJokes());

		return "chucknorris";
	}

}
