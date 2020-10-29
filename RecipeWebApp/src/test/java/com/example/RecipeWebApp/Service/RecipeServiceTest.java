package com.example.RecipeWebApp.Service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.RecipeWebApp.domain.Recipe;
import com.example.RecipeWebApp.repositories.RecipeRepository;

// this is using mockito mock

public class RecipeServiceTest {

	RecipeService recipeService;

	@Mock
	RecipeRepository recipeRepository;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		recipeService = new RecipeService(recipeRepository);
	}

	@Test
	public void getRecipes() throws Exception {

		Recipe recipe = new Recipe();
		HashSet recipesData = new HashSet();
//		System.out.println("yc: " + recipeService);
		recipesData.add(recipe);
		when(recipeRepository.findAll()).thenReturn(recipesData);

		Set<Recipe> recipes = recipeService.getRecipe();

		assertEquals(recipes.size(), 1);
		verify(recipeRepository, times(1)).findAll();
	}

}
