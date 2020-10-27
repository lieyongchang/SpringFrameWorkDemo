package com.example.RecipeWebApp.Service;

import java.util.HashSet;
import java.util.Set;

import com.example.RecipeWebApp.domain.Recipe;
import com.example.RecipeWebApp.repositories.RecipeRepository;

public class RecipeService implements IRecipeService {

	private RecipeRepository recipeRepo;

	public RecipeService(RecipeRepository recipeRepo) {
		this.recipeRepo = recipeRepo;
	}

	@Override
	public Set<Recipe> getRecipe() {
		// recipeSet is just a container
		Set<Recipe> recipeSet = new HashSet<>();

		// go through recipe repo, and put everything into the container
		recipeRepo.findAll().iterator().forEachRemaining(recipeSet::add);

		return recipeSet;
	}

}
