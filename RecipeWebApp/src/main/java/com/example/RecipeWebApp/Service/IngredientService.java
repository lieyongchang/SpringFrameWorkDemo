package com.example.RecipeWebApp.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.RecipeWebApp.commands.IngredientCommand;
import com.example.RecipeWebApp.converters.IngredientCommandToIngredient;
import com.example.RecipeWebApp.converters.IngredientToIngredientCommand;
import com.example.RecipeWebApp.domain.Ingredient;
import com.example.RecipeWebApp.domain.Recipe;
import com.example.RecipeWebApp.repositories.RecipeRepository;
import com.example.RecipeWebApp.repositories.UnitOfMeasureRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class IngredientService implements IIngredientService {

	private final IngredientToIngredientCommand ingredientToIngredientCommand;
	private final IngredientCommandToIngredient ingredientCommandToIngredient;
	private final RecipeRepository recipeRepo;
	private final UnitOfMeasureRepository unitOfMeasureRepo;

	public IngredientService(IngredientToIngredientCommand ingredientToIngredientCommand,
			IngredientCommandToIngredient ingredientCommandToIngredient, RecipeRepository recipeRepo,
			UnitOfMeasureRepository unitOfMeasureRepo) {
		this.ingredientToIngredientCommand = ingredientToIngredientCommand;
		this.ingredientCommandToIngredient = ingredientCommandToIngredient;
		this.recipeRepo = recipeRepo;
		this.unitOfMeasureRepo = unitOfMeasureRepo;
	}

	@Override
	public IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {

		Optional<Recipe> recipeOptional = recipeRepo.findById(recipeId);

		if (!recipeOptional.isPresent()) {
			// todo impl error handling
			log.error("recipe id not found. Id: " + recipeId);
		}

		Recipe recipe = recipeOptional.get();

		Optional<IngredientCommand> ingredientCommandOptional = recipe.getIngredients().stream()
				.filter(ingredient -> ingredient.getId().equals(ingredientId))
				.map(ingredient -> ingredientToIngredientCommand.convert(ingredient)).findFirst();

		if (!ingredientCommandOptional.isPresent()) {
			// todo impl error handling
			log.error("Ingredient id not found: " + ingredientId);
		}

		return ingredientCommandOptional.get();
	}

	@Override
	@Transactional
	public IngredientCommand saveIngredientCommand(IngredientCommand command) {
		Optional<Recipe> recipeOptional = recipeRepo.findById(command.getRecipeId());

		if (!recipeOptional.isPresent()) {

			// todo toss error if not found!
			log.error("Recipe not found for id: " + command.getRecipeId());
			return new IngredientCommand();
		} else {
			Recipe recipe = recipeOptional.get();

			Optional<Ingredient> ingredientOptional = recipe.getIngredients().stream()
					.filter(ingredient -> ingredient.getId().equals(command.getId())).findFirst();

			if (ingredientOptional.isPresent()) {
				Ingredient ingredientFound = ingredientOptional.get();
				ingredientFound.setDescription(command.getDescription());
				ingredientFound.setAmount(command.getAmount());
				ingredientFound.setUom(unitOfMeasureRepo.findById(command.getUom().getId())
						.orElseThrow(() -> new RuntimeException("UOM NOT FOUND"))); // todo address this
			} else {
				// add new Ingredient
				recipe.addIngredient(ingredientCommandToIngredient.convert(command));
			}

			Recipe savedRecipe = recipeRepo.save(recipe);

			// to do check for fail
			return ingredientToIngredientCommand.convert(savedRecipe.getIngredients().stream()
					.filter(recipeIngredients -> recipeIngredients.getId().equals(command.getId())).findFirst().get());
		}

	}

	/***
	 * 
	 * Delete an Ingredient
	 * 
	 **/

	@Override
	public void deleteById(Long recipeId, Long idToDelete) {
		Optional<Recipe> recipeOptional = recipeRepo.findById(recipeId);

		if (recipeOptional.isPresent()) {
			Recipe recipe = recipeOptional.get();
			log.debug("found recipe");

			Optional<Ingredient> ingredientOptional = recipe.getIngredients().stream()
					.filter(ingredient -> ingredient.getId().equals(idToDelete)).findFirst();

			if (ingredientOptional.isPresent()) {
				log.debug("found Ingredient");
				Ingredient ingredientToDelete = ingredientOptional.get();
				ingredientToDelete.setRecipe(null);
				recipe.getIngredients().remove(ingredientOptional.get());
				recipeRepo.save(recipe);
			}
		} else {
			log.debug("Recipe Id Not found. Id:" + recipeId);
		}
	}
}
