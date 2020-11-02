package com.example.RecipeWebApp.converters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.RecipeWebApp.commands.CategoryCommand;
import com.example.RecipeWebApp.commands.IngredientCommand;
import com.example.RecipeWebApp.commands.NotesCommand;
import com.example.RecipeWebApp.commands.RecipeCommand;
import com.example.RecipeWebApp.domain.Recipe;

class RecipeCommandToRecipeTest {

	public static final Long ID_VALUE = 1L;
	public static final String DESCRIPTION = "descript";
	public static final Integer PREPTIME = 1;
	public static final Integer COOKTIME = 1;
	public static final Integer SERVING = 1;
	public static final String SOURCE = "source";
	public static final String URL = "www.google.com";
	public static final String DIRECTIONS = "Left";

	//
	public static final Long CAT_ID_1 = 1L;
	public static final Long CAT_ID2 = 2L;
	public static final Long INGRED_ID_1 = 3L;
	public static final Long INGRED_ID_2 = 4L;
	public static final Long NOTES_ID = 9L;

	RecipeCommandToRecipe convter;

	@BeforeEach
	void setUp() throws Exception {
		convter = new RecipeCommandToRecipe(new CategoryCommandToCategory(),
				new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure()), new NoteCommandToNote());
	}

	@Test
	public void testNullObject() throws Exception {
		assertNull(convter.convert(null));
	}

	@Test
	public void testEmptyObject() throws Exception {
		assertNotNull(convter.convert(new RecipeCommand()));
	}

	@Test
	public void convert() throws Exception {

		// given
		RecipeCommand recipeCommand = new RecipeCommand();
		recipeCommand.setId(ID_VALUE);
		recipeCommand.setDecription(DESCRIPTION);
		recipeCommand.setPrepTime(PREPTIME);
		recipeCommand.setCookTime(COOKTIME);
		recipeCommand.setServing(SERVING);
		recipeCommand.setSource(SOURCE);
		recipeCommand.setUrl(URL);
		recipeCommand.setDirections(DIRECTIONS);

		NotesCommand notes = new NotesCommand();
		notes.setId(NOTES_ID);

		recipeCommand.setNotesCommand(notes);

		CategoryCommand category = new CategoryCommand();
		category.setId(CAT_ID_1);

		CategoryCommand category2 = new CategoryCommand();
		category2.setId(CAT_ID2);

		recipeCommand.getCategoryCommand().add(category);
		recipeCommand.getCategoryCommand().add(category2);

		IngredientCommand ingredient = new IngredientCommand();
		ingredient.setId(INGRED_ID_1);

		IngredientCommand ingredient2 = new IngredientCommand();
		ingredient2.setId(INGRED_ID_2);

		recipeCommand.getIngredientsCommand().add(ingredient);
		recipeCommand.getIngredientsCommand().add(ingredient2);

		// when
		Recipe recipe = convter.convert(recipeCommand);

		// then
		assertNotNull(recipe);
		assertEquals(ID_VALUE, recipe.getId());
		assertEquals(DESCRIPTION, recipe.getDescription());
		assertEquals(PREPTIME, recipe.getPrepTime());
		assertEquals(COOKTIME, recipe.getCookTime());
		assertEquals(SERVING, recipe.getServing());
		assertEquals(SOURCE, recipe.getSource());
		assertEquals(URL, recipe.getUrl());
		assertEquals(DIRECTIONS, recipe.getDirections());

		//
		assertEquals(NOTES_ID, recipe.getNotes().getId());
		assertEquals(2, recipe.getCategories().size());
		assertEquals(2, recipe.getIngredients().size());
	}

}
