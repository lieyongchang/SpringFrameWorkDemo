package com.example.RecipeWebApp.Service;

import java.util.Set;

import com.example.RecipeWebApp.commands.RecipeCommand;
import com.example.RecipeWebApp.domain.Recipe;

public interface IRecipeService {
	Set<Recipe> getRecipe();

	Recipe findById(Long l);

	RecipeCommand findCommandById(Long l);

	RecipeCommand saveRecipeCommand(RecipeCommand command);

	void deleteById(Long idToDelete);

}
