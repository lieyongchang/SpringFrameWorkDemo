package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.IRecipeService;

@Controller
public class IndexController {

	private final IRecipeService recipeService;

	public IndexController(IRecipeService recipeService) {
		super();
		this.recipeService = recipeService;
	}

	/*
	 * 
	 * Uncomment this to see JPA Query in action
	 * 
	 */
	// private CategoryRepository categoryRepo;
	// private UnitOfMeasureRepository uomRepo;

	// public IndexController(CategoryRepository categoryRepo,
	// UnitOfMeasureRepository uomRepo) {
	// super();
	// this.categoryRepo = categoryRepo;
	// this.uomRepo = uomRepo;
	// }

	// @RequestMapping(value = "/")
	@RequestMapping({ "", "/", "/index" })
	public String getIndexPage(Model model) {
		model.addAttribute("recipes", recipeService.getRecipe());
		/*
		 * 
		 * Uncomment this to see JPA Query in action
		 * 
		 */

		// Optional<Category> categoryOptional =
		// categoryRepo.findByDescription("American");
		// Optional<UnitOfMeasure> uomOptional = uomRepo.findByDescription("Teaspoon");
		//
		// System.out.println("category: " + categoryOptional.get().getId());
		// System.out.println("Unit of Measure: " + uomOptional.get().getId());
		return "Index";
	}
}
