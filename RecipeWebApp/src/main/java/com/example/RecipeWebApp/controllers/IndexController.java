package com.example.RecipeWebApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

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

//	@RequestMapping(value = "/")
	@RequestMapping({ "", "/", "/index" })
	public String getIndexPage() {

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
