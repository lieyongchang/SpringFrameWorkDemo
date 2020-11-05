package com.example.RecipeWebApp.converters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.RecipeWebApp.commands.CategoryCommand;
import com.example.RecipeWebApp.domain.Category;

class CategoryToCategoryCommandTest {

	public static final Long ID_VALUE = 1L;
	public static final String DESCRIPTION = "descript";
	CategoryToCategoryCommand convter;

	@BeforeEach
	public void setUp() throws Exception {
		convter = new CategoryToCategoryCommand();
	}

	@Test
	public void testNullObject() throws Exception {
		assertNull(convter.convert(null));
	}

	@Test
	public void testEmptyObject() throws Exception {
		assertNotNull(convter.convert(new Category()));
	}

	@Test
	public void convert() throws Exception {
		// given
		Category category = new Category();
		category.setId(ID_VALUE);
		category.setDescription(DESCRIPTION);

		// when
		CategoryCommand categoryCommand = convter.convert(category);

		// then
		assertEquals(ID_VALUE, categoryCommand.getId());
		assertEquals(DESCRIPTION, categoryCommand.getDescription());

	}

}
