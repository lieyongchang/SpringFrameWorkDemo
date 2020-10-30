package com.example.RecipeWebApp.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import com.example.RecipeWebApp.Service.RecipeService;
import com.example.RecipeWebApp.domain.Recipe;

public class IndexControllerTest {

	@Mock
	RecipeService recipeService;

	@Mock
	Model model;

	IndexController indexController;

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		indexController = new IndexController(recipeService);
	}

	// mock test mvc
	@Test
	public void testMockMvc() throws Exception {
		MockMvc mocMvc = MockMvcBuilders.standaloneSetup(indexController).build();
		mocMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("Index"));
	}

	@Test
	public void getIndexPage() throws Exception {

		// given
		Set<Recipe> recipes = new HashSet<>();
		recipes.add(new Recipe());

		Recipe recipe = new Recipe();
		recipe.setId(1L);

		recipes.add(recipe);

		when(recipeService.getRecipe()).thenReturn(recipes);

		// Mockito Argument Capture
		ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

		String viewName = indexController.getIndexPage(model);

		// then
		assertEquals("Index", viewName);
		verify(recipeService, times(1)).getRecipe();
		verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
		Set<Recipe> setInController = argumentCaptor.getValue();
		assertEquals(2, setInController.size());
	}
}
