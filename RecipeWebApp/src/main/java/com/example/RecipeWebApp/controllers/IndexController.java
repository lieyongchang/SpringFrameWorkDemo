package com.example.RecipeWebApp.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.RecipeWebApp.domain.Category;
import com.example.RecipeWebApp.domain.UnitOfMeasure;
import com.example.RecipeWebApp.repositories.CategoryRepository;
import com.example.RecipeWebApp.repositories.UnitOfMeasureRepository;

@Controller
public class IndexController {

	private CategoryRepository categoryRepo;
	private UnitOfMeasureRepository uomRepo;

	public IndexController(CategoryRepository categoryRepo, UnitOfMeasureRepository uomRepo) {
		super();
		this.categoryRepo = categoryRepo;
		this.uomRepo = uomRepo;
	}

//	@RequestMapping(value = "/")
	@RequestMapping({ "", "/", "/index" })
	public String getIndexPage() {

		Optional<Category> categoryOptional = categoryRepo.findByDescription("American");
		Optional<UnitOfMeasure> uomOptional = uomRepo.findByDescription("Teaspoon");

		System.out.println("category: " + categoryOptional.get().getId());
		System.out.println("Unit of Measure: " + uomOptional.get().getId());
		return "Index";
	}
}
