package com.example.RecipeWebApp.Service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.RecipeWebApp.domain.Recipe;
import com.example.RecipeWebApp.repositories.RecipeRepository;

// this is to add logger file

// just saying this is a service class
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RecipeService implements IRecipeService {

	private final RecipeRepository recipeRepo;

	public RecipeService(RecipeRepository recipeRepo) {
		this.recipeRepo = recipeRepo;
	}

	@Override
	public Set<Recipe> getRecipe() {
		log.debug("I'm in the service");

		// recipeSet is just a container
		Set<Recipe> recipeSet = new HashSet<>();

		// go through recipe repo, and put everything into the container
		recipeRepo.findAll().iterator().forEachRemaining(recipeSet::add);

		return recipeSet;
	}

}
