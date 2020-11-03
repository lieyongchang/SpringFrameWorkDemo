package com.example.RecipeWebApp.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.RecipeWebApp.commands.RecipeCommand;
import com.example.RecipeWebApp.converters.RecipeCommandToRecipe;
import com.example.RecipeWebApp.converters.RecipeToRecipeCommand;
import com.example.RecipeWebApp.domain.Recipe;
import com.example.RecipeWebApp.repositories.RecipeRepository;

// this is to add logger file

// just saying this is a service class
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RecipeService implements IRecipeService {

	private final RecipeRepository recipeRepo;
	private final RecipeToRecipeCommand recipeToRecipeCommand;
	private final RecipeCommandToRecipe recipeCommandToRecipe;

	public RecipeService(RecipeRepository recipeRepo, RecipeToRecipeCommand recipeToRecipeCommand,
			RecipeCommandToRecipe recipeCommandToRecipe) {
		this.recipeRepo = recipeRepo;
		this.recipeToRecipeCommand = recipeToRecipeCommand;
		this.recipeCommandToRecipe = recipeCommandToRecipe;
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

	@Override
	public Recipe findById(Long l) {
		Optional<Recipe> recipeOptional = recipeRepo.findById(l);

		if (!recipeOptional.isPresent()) {
			throw new RuntimeException("Recipe Not Found!");
		}

		return recipeOptional.get();
	}

	@Override
	@Transactional
	public RecipeCommand findCommandById(Long l) {
		return recipeToRecipeCommand.convert(findById(l));
	}

	@Override
	@Transactional
	public RecipeCommand saveRecipeCommand(RecipeCommand command) {
		Recipe detachedRecipe = recipeCommandToRecipe.convert(command);

		Recipe savedRecipe = recipeRepo.save(detachedRecipe);
		log.debug("Saved RecipeId:" + savedRecipe.getId());
		return recipeToRecipeCommand.convert(savedRecipe);
	}

	@Override
	public void deleteById(Long idToDelete) {
		recipeRepo.deleteById(idToDelete);
	}

}
