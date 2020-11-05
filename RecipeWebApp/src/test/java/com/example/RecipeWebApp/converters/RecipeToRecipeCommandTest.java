package com.example.RecipeWebApp.converters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.RecipeWebApp.commands.RecipeCommand;
import com.example.RecipeWebApp.domain.Category;
import com.example.RecipeWebApp.domain.Ingredient;
import com.example.RecipeWebApp.domain.Notes;
import com.example.RecipeWebApp.domain.Recipe;

class RecipeToRecipeCommandTest {

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

	RecipeToRecipeCommand convter;

	@BeforeEach
	void setUp() throws Exception {
		convter = new RecipeToRecipeCommand(new CategoryToCategoryCommand(),
				new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand()), new NoteToNoteCommand());
	}

	@Test
	public void testNullConvert() throws Exception {
		assertNull(convter.convert(null));
	}

	@Test
	public void testEmptyObject() throws Exception {
		assertNotNull(convter.convert(new Recipe()));
	}

	@Test
	public void convert() throws Exception {

		// given
		Recipe recipe = new Recipe();
		recipe.setId(ID_VALUE);
		recipe.setDescription(DESCRIPTION);
		recipe.setPrepTime(PREPTIME);
		recipe.setCookTime(COOKTIME);
		recipe.setServing(SERVING);
		recipe.setSource(SOURCE);
		recipe.setUrl(URL);
		recipe.setDirections(DIRECTIONS);

		Notes notes = new Notes();
		notes.setId(NOTES_ID);

		recipe.setNotes(notes);

		Category category = new Category();
		category.setId(CAT_ID_1);

		Category category2 = new Category();
		category2.setId(CAT_ID2);

		recipe.getCategories().add(category);
		recipe.getCategories().add(category2);

		Ingredient ingredient = new Ingredient();
		ingredient.setId(INGRED_ID_1);

		Ingredient ingredient2 = new Ingredient();
		ingredient2.setId(INGRED_ID_2);

		recipe.getIngredients().add(ingredient);
		recipe.getIngredients().add(ingredient2);

		// when
		RecipeCommand recipeCommand = convter.convert(recipe);

		// then
		assertNotNull(recipeCommand);
		assertEquals(ID_VALUE, recipeCommand.getId());
		assertEquals(DESCRIPTION, recipeCommand.getDecription());
		assertEquals(PREPTIME, recipeCommand.getPrepTime());
		assertEquals(COOKTIME, recipeCommand.getCookTime());
		assertEquals(SERVING, recipeCommand.getServing());
		assertEquals(SOURCE, recipeCommand.getSource());
		assertEquals(URL, recipeCommand.getUrl());
		assertEquals(DIRECTIONS, recipeCommand.getDirections());

		//
		assertEquals(NOTES_ID, recipeCommand.getNotesCommand().getId());
		assertEquals(2, recipeCommand.getCategoryCommand().size());
		assertEquals(2, recipeCommand.getIngredientsCommand().size());
	}

}
