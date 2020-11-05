package com.example.RecipeWebApp.converters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.RecipeWebApp.commands.UnitOfMeasureCommand;
import com.example.RecipeWebApp.domain.UnitOfMeasure;

class UnitOfMeasureToUnitOfMeasureCommandTest {

	public static final Long ID_VALUE = 1L;
	public static final String DESCRIPTION = "description";

	UnitOfMeasureToUnitOfMeasureCommand convter;

	@BeforeEach
	void setUp() throws Exception {
		convter = new UnitOfMeasureToUnitOfMeasureCommand();
	}

	@Test
	public void testNullObject() throws Exception {
		assertNull(convter.convert(null));
	}

	@Test
	public void testEmptyObject() throws Exception {
		assertNotNull(convter.convert(new UnitOfMeasure()));
	}

	@Test
	public void convert() throws Exception {
		// given
		UnitOfMeasure uom = new UnitOfMeasure();
		uom.setId(ID_VALUE);
		uom.setDescription(DESCRIPTION);

		// when
		UnitOfMeasureCommand uomCommand = convter.convert(uom);

		// then
		assertEquals(ID_VALUE, uomCommand.getId());
		assertEquals(DESCRIPTION, uomCommand.getDescription());

	}

}
