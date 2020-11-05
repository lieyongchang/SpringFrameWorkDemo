package com.example.RecipeWebApp.Service;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.RecipeWebApp.commands.RecipeCommand;
import com.example.RecipeWebApp.converters.RecipeCommandToRecipe;
import com.example.RecipeWebApp.converters.RecipeToRecipeCommand;
import com.example.RecipeWebApp.domain.Recipe;
import com.example.RecipeWebApp.repositories.RecipeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class IRecipeServiceTest {

	public static final String NEW_DESCRIPTION = "New Description";

	@Autowired
	IRecipeService recipeService;

	@Autowired
	RecipeRepository recipeRepository;

	@Autowired
	RecipeCommandToRecipe recipeCommandToRecipe;

	@Autowired
	RecipeToRecipeCommand recipeToRecipeCommand;

	@Transactional
	@Test
	public void testSaveOfDescription() throws Exception {
		// given
		Iterable<Recipe> recipes = recipeRepository.findAll();
		Recipe testRecipe = recipes.iterator().next();
		RecipeCommand testRecipeCommand = recipeToRecipeCommand.convert(testRecipe);

		// when
		testRecipeCommand.setDecription(NEW_DESCRIPTION);
		RecipeCommand savedRecipeCommand = recipeService.saveRecipeCommand(testRecipeCommand);

		// then
		assertEquals(NEW_DESCRIPTION, savedRecipeCommand.getDecription());
		assertEquals(testRecipe.getId(), savedRecipeCommand.getId());
		assertEquals(testRecipe.getCategories().size(), savedRecipeCommand.getCategoryCommand().size());
		assertEquals(testRecipe.getIngredients().size(), savedRecipeCommand.getIngredientsCommand().size());
	}

}
