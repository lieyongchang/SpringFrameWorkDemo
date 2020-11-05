package com.example.RecipeWebApp.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.example.RecipeWebApp.commands.RecipeCommand;
import com.example.RecipeWebApp.domain.Recipe;

import lombok.Synchronized;

@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {

	private final CategoryToCategoryCommand categoryConveter;
	private final IngredientToIngredientCommand ingredientConverter;
	private final NoteToNoteCommand notesConverter;

	public RecipeToRecipeCommand(CategoryToCategoryCommand categoryConveter, IngredientToIngredientCommand ingredientConverter,
								 NoteToNoteCommand notesConverter) {
		this.categoryConveter = categoryConveter;
		this.ingredientConverter = ingredientConverter;
		this.notesConverter = notesConverter;
	}


	@Synchronized
	@Nullable
	@Override
	public RecipeCommand convert(Recipe source) {
		if (source == null) {
			return null;
		}

		final RecipeCommand recipeCommandConverter = new RecipeCommand();
		recipeCommandConverter.setId(source.getId());
		recipeCommandConverter.setCookTime(source.getCookTime());
		recipeCommandConverter.setPrepTime(source.getPrepTime());
		recipeCommandConverter.setDecription(source.getDescription());
		recipeCommandConverter.setDifficulty(source.getDifficulty());
		recipeCommandConverter.setDirections(source.getDirections());
		recipeCommandConverter.setServing(source.getServing());
		recipeCommandConverter.setSource(source.getSource());
		recipeCommandConverter.setUrl(source.getUrl());
		recipeCommandConverter.setImage(source.getImage());
		recipeCommandConverter.setNotesCommand(notesConverter.convert(source.getNotes()));

		//
		if (source.getCategories() != null && source.getCategories().size() > 0) {
			source.getCategories().forEach(
					category -> recipeCommandConverter.getCategoryCommand().add(categoryConveter.convert(category)));
		}

		if (source.getIngredients() != null && source.getIngredients().size() > 0) {
			source.getIngredients().forEach(ingredient -> recipeCommandConverter.getIngredientsCommand()
					.add(ingredientConverter.convert(ingredient)));
		}

		return recipeCommandConverter;
	}

}
