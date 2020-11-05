package com.example.RecipeWebApp.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.example.RecipeWebApp.commands.RecipeCommand;
import com.example.RecipeWebApp.domain.Recipe;

import lombok.Synchronized;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {

	private final CategoryCommandToCategory categoryConveter;
	private final IngredientCommandToIngredient ingredientConverter;
	private final NoteCommandToNote notesConverter;

	public RecipeCommandToRecipe(CategoryCommandToCategory categoryConveter,
			IngredientCommandToIngredient ingredientConverter, NoteCommandToNote notesConverter) {
		super();
		this.categoryConveter = categoryConveter;
		this.ingredientConverter = ingredientConverter;
		this.notesConverter = notesConverter;
	}

	@Synchronized
	@Nullable
	@Override
	public Recipe convert(RecipeCommand source) {
		if (source == null) {
			return null;
		}

		final Recipe recipe = new Recipe();
		recipe.setId(source.getId());
		recipe.setDescription(source.getDecription());
		recipe.setPrepTime(source.getPrepTime());
		recipe.setCookTime(source.getCookTime());
		recipe.setServing(source.getServing());
		recipe.setSource(source.getSource());
		recipe.setUrl(source.getUrl());

		recipe.setDirections(source.getDirections());
		recipe.setDifficulty(source.getDifficulty());
		recipe.setNotes(notesConverter.convert(source.getNotesCommand()));

		//
		if (source.getCategoryCommand() != null && source.getCategoryCommand().size() > 0) {
			source.getCategoryCommand()
					.forEach(category -> recipe.getCategories().add(categoryConveter.convert(category)));
		}

		if (source.getIngredientsCommand() != null && source.getIngredientsCommand().size() > 0) {
			source.getIngredientsCommand()
					.forEach(ingredient -> recipe.getIngredients().add(ingredientConverter.convert(ingredient)));
		}

		return recipe;
	}

}
