package com.example.RecipeWebApp.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.example.RecipeWebApp.commands.IngredientCommand;
import com.example.RecipeWebApp.domain.Ingredient;

import lombok.Synchronized;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

	private final UnitOfMeasureToUnitOfMeasureCommand uomConverter;

	public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand uomConverter) {
		this.uomConverter = uomConverter;
	}

	@Synchronized
	@Nullable
	@Override
	public IngredientCommand convert(Ingredient source) {
		if (source == null) {
			return null;
		}

		IngredientCommand ingredientCommandConverter = new IngredientCommand();
		ingredientCommandConverter.setId(source.getId());
		if (source.getRecipe() != null) {
			ingredientCommandConverter.setRecipeId(source.getRecipe().getId());
		}
		ingredientCommandConverter.setAmount(source.getAmount());
		ingredientCommandConverter.setDescription(source.getDescription());
		ingredientCommandConverter.setUom(uomConverter.convert(source.getUom()));
		return ingredientCommandConverter;
	}

}
