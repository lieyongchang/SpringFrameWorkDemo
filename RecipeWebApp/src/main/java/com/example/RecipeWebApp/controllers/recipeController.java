package com.example.RecipeWebApp.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.example.RecipeWebApp.Service.IRecipeService;
import com.example.RecipeWebApp.commands.RecipeCommand;
import com.example.RecipeWebApp.exceptions.NotFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class recipeController {

	private static final String RECIPE_RECIPEFORM_URL = "recipe/recipeform";
	private final IRecipeService recipeService;

	public recipeController(IRecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@GetMapping("/recipe/{id}/show")
	public String showById(@PathVariable String id, Model model) {
		model.addAttribute("recipe", recipeService.findById(Long.valueOf(id)));
		log.debug("showById");
		return "recipe/show";
	}

	/***
	 * 
	 * Render recipeform.html
	 * 
	 **/

	@RequestMapping("recipe/new")
	public String newRecipe(Model model) {
		model.addAttribute("recipe", new RecipeCommand());

		return "recipe/recipeform";
	}

	/***
	 * 
	 * 
	 * 
	 * 
	 * ***/

	@PostMapping("recipe")
	public String saveOrUpdate(@Valid @ModelAttribute("recipe") RecipeCommand command, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {

			bindingResult.getAllErrors().forEach(objectError -> {
				log.debug(objectError.toString());
			});

			return RECIPE_RECIPEFORM_URL;
		}

		RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);

		return "redirect:/recipe/" + savedCommand.getId() + "/show";
	}

	/***
	 * 
	 * Update a Recipe
	 * 
	 **/

	@GetMapping("recipe/{id}/update")
	public String updateRecipe(@PathVariable String id, Model model) {
		model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));

		return RECIPE_RECIPEFORM_URL;
	}

	/***
	 * 
	 * Delete a Recipe
	 * 
	 **/

	@GetMapping("recipe/{id}/delete")
	public String DeleteRecipe(@PathVariable String id) {
		recipeService.deleteById(Long.valueOf(id));
		return "redirect:/";
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NotFoundException.class)
	public ModelAndView handleNotFound(Exception exception) {

		log.error("Handling not found exception");

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("404error");
		modelAndView.addObject("exception", exception);
		return modelAndView;
	}
}
