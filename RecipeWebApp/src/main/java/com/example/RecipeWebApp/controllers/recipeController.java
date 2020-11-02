package com.example.RecipeWebApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.RecipeWebApp.Service.IRecipeService;
import com.example.RecipeWebApp.commands.RecipeCommand;

@Controller
public class recipeController {
	private final IRecipeService recipeService;

	public recipeController(IRecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@RequestMapping("/recipe/show/{id}")
	public String showById(@PathVariable String id, Model model) {
		model.addAttribute("recipe", recipeService.findById(Long.valueOf(id)));

		return "recipe/show";
	}

	/***
	 * 
	 * Render Recipeform.html
	 * 
	 * 
	 **/

	@RequestMapping("recipe/new")
	public String newRecipe(Model model) {
		model.addAttribute("recipe", new RecipeCommand());

		return "recipe/recipeform";
	}

	@PostMapping("recipe")
	public String saveOrUpdate(@ModelAttribute RecipeCommand command) {
		RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);

		return "redirect:/recipe/show/" + savedCommand.getId();
	}
}
