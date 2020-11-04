package com.example.RecipeWebApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.RecipeWebApp.Service.IRecipeService;
import com.example.RecipeWebApp.Service.IimageService;

@Controller
public class imageController {
	private final IimageService imgService;
	private final IRecipeService recipeService;

	public imageController(IimageService imgService, IRecipeService recipeService) {
		this.imgService = imgService;
		this.recipeService = recipeService;
	}

	@GetMapping("recipe/{id}/image")
	public String showUploadForm(@PathVariable String id, Model model) {
		model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));

		return "recipe/imageuploadform";
	}

	@PostMapping("recipe/{id}/image")
	public String handleImagePost(@PathVariable String id, @RequestParam("imagefile") MultipartFile file) {

		imgService.saveImageFile(Long.valueOf(id), file);

		return "redirect:/recipe/" + id + "/show";
	}
}
