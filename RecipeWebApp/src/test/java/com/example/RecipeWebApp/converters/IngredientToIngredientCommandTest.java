package com.example.RecipeWebApp.converters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.RecipeWebApp.commands.IngredientCommand;
import com.example.RecipeWebApp.domain.Ingredient;
import com.example.RecipeWebApp.domain.Recipe;

class IngredientToIngredientCommandTest {

	public static final Long ID_VALUE = 1L;
	public static final String DESCRIPTION = "description";
	public static final BigDecimal AMOUNT = new BigDecimal("1");
	public static final Long UOM = 2L;
	public static final Recipe RECIPE = new Recipe();

	IngredientToIngredientCommand convter;

	@BeforeEach
	void setUp() throws Exception {
		convter = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
	}

	@Test
	public void testNullConvert() throws Exception {
		assertNull(convter.convert(null));
	}

	@Test
	public void testEmptyObject() throws Exception {
		assertNotNull(convter.convert(new Ingredient()));
	}

	@Test
	public void testConvertNullUOM() throws Exception {

		// given
		Ingredient ingredient = new Ingredient();
		ingredient.setId(ID_VALUE);
		ingredient.setDescription(DESCRIPTION);
		ingredient.setAmount(AMOUNT);
		ingredient.setRecipe(RECIPE);
		ingredient.setUom(null);

		// when
		// Ingredient ingredient = new Ingredient();
		IngredientCommand ingrediCommand = convter.convert(ingredient);

		// then
		assertNull(ingrediCommand.getUom());
		assertEquals(ID_VALUE, ingrediCommand.getId());
		assertEquals(DESCRIPTION, ingrediCommand.getDescription());
		assertEquals(AMOUNT, ingrediCommand.getAmount());

	}

}
