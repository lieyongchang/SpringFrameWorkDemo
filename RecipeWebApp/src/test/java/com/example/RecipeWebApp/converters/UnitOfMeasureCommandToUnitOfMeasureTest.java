package com.example.RecipeWebApp.converters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.RecipeWebApp.commands.UnitOfMeasureCommand;
import com.example.RecipeWebApp.domain.UnitOfMeasure;

class UnitOfMeasureCommandToUnitOfMeasureTest {

	public static final Long ID_VALUE = 1L;
	public static final String DESCRIPTION = "description";

	UnitOfMeasureCommandToUnitOfMeasure convter;

	@BeforeEach
	void setUp() throws Exception {
		convter = new UnitOfMeasureCommandToUnitOfMeasure();
	}

	@Test
	public void testNullObject() throws Exception {
		assertNull(convter.convert(null));
	}

	@Test
	public void testEmptyObject() throws Exception {
		assertNotNull(convter.convert(new UnitOfMeasureCommand()));
	}

	@Test
	public void convert() throws Exception {
		// given
		UnitOfMeasureCommand uomCommand = new UnitOfMeasureCommand();
		uomCommand.setId(ID_VALUE);
		uomCommand.setDescription(DESCRIPTION);

		// when
		UnitOfMeasure uom = convter.convert(uomCommand);

		// then
		assertNotNull(uom);
		assertEquals(ID_VALUE, uom.getId());
		assertEquals(DESCRIPTION, uom.getDescription());
	}

}
