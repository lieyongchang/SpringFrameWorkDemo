package com.example.RecipeWebApp.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CategoryTest {

	Category category;

	@Before
	public void setUp() {
		category = new Category();
	}

	@Test
	public void getId() throws Exception {
		Long idValue = 4L;

		category.setId(idValue);

		assertEquals(idValue, category.getId());
	}

	@Test
	public void getDescription() throws Exception {
	};

	@Test
	public void getRecipes() throws Exception {
	};

}
