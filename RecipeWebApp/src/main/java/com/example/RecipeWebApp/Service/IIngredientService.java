package com.example.RecipeWebApp.Service;

import com.example.RecipeWebApp.commands.IngredientCommand;

public interface IIngredientService {
	IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);

	IngredientCommand saveIngredientCommand(IngredientCommand command);

	void deleteById(Long recipeId, Long idToDelete);
}
