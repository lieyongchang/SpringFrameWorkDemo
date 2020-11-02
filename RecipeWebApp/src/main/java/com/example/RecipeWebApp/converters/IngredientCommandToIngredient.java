package com.example.RecipeWebApp.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.example.RecipeWebApp.commands.IngredientCommand;
import com.example.RecipeWebApp.domain.Ingredient;

@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {
	private final UnitOfMeasureCommandToUnitOfMeasure uomConverter;

	public IngredientCommandToIngredient(UnitOfMeasureCommandToUnitOfMeasure uomConverter) {
		this.uomConverter = uomConverter;
	}

	@Nullable
	@Override
	public Ingredient convert(IngredientCommand source) {

		if (source == null) {
			return null;
		}
		final Ingredient ingredientConverter = new Ingredient();
		ingredientConverter.setId(source.getId());
		ingredientConverter.setDescription(source.getDescription());
		ingredientConverter.setAmount(source.getAmount());
		ingredientConverter.setUom(uomConverter.convert(source.getUom()));
		return ingredientConverter;

	}
}
