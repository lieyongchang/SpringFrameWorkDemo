package com.example.RecipeWebApp.converters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.RecipeWebApp.commands.IngredientCommand;
import com.example.RecipeWebApp.commands.UnitOfMeasureCommand;
import com.example.RecipeWebApp.domain.Ingredient;
import com.example.RecipeWebApp.domain.Recipe;

class IngredientCommandToIngredientTest {

	public static final Long ID_VALUE = 1L;
	public static final String DESCRIPTION = "description";
	public static final BigDecimal AMOUNT = new BigDecimal("1");
	public static final Long UOM = 2L;
	public static final Recipe recipe = new Recipe();

	IngredientCommandToIngredient convter;

	@BeforeEach
	void setUp() throws Exception {
		convter = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
	}

	@Test
	public void testNullObject() throws Exception {
		assertNull(convter.convert(null));
	}

	@Test
	public void testEmptyObject() throws Exception {
		assertNotNull(convter.convert(new IngredientCommand()));
	}

	@Test
	public void convert() throws Exception {

		// given
		IngredientCommand ingrediCommand = new IngredientCommand();
		ingrediCommand.setId(ID_VALUE);
		ingrediCommand.setDescription(DESCRIPTION);
		ingrediCommand.setAmount(AMOUNT);

		UnitOfMeasureCommand uomCommand = new UnitOfMeasureCommand();
		uomCommand.setId(UOM);
		ingrediCommand.setUom(uomCommand);

		// when
		// Ingredient ingredient = new Ingredient();
		Ingredient ingredient = convter.convert(ingrediCommand);

		// then
		assertNotNull(ingredient);
		assertNotNull(ingredient.getUom());
		assertEquals(ID_VALUE, ingredient.getId());
		assertEquals(DESCRIPTION, ingredient.getDescription());
		assertEquals(AMOUNT, ingredient.getAmount());
		assertEquals(UOM, ingredient.getUom().getId());
	}
}
