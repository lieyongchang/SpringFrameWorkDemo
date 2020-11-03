package com.example.RecipeWebApp.Service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.RecipeWebApp.commands.UnitOfMeasureCommand;
import com.example.RecipeWebApp.converters.UnitOfMeasureToUnitOfMeasureCommand;
import com.example.RecipeWebApp.domain.UnitOfMeasure;
import com.example.RecipeWebApp.repositories.UnitOfMeasureRepository;

class UnitOfMeasureServiceTest {
	UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand = new UnitOfMeasureToUnitOfMeasureCommand();
	IUnitOfMeasureService service;

	@Mock
	UnitOfMeasureRepository unitOfMeasureRepo;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		service = new UnitOfMeasureService(unitOfMeasureRepo, unitOfMeasureToUnitOfMeasureCommand);
	}

	@Test
	public void listAllUoms() throws Exception {
		// given
		Set<UnitOfMeasure> unitOfMeasures = new HashSet<>();
		UnitOfMeasure uom1 = new UnitOfMeasure();
		uom1.setId(1L);
		unitOfMeasures.add(uom1);

		UnitOfMeasure uom2 = new UnitOfMeasure();
		uom2.setId(2L);
		unitOfMeasures.add(uom2);

		when(unitOfMeasureRepo.findAll()).thenReturn(unitOfMeasures);

		// when
		Set<UnitOfMeasureCommand> commands = service.listAllUoms();

		// then
		assertEquals(2, commands.size());
		verify(unitOfMeasureRepo, times(1)).findAll();
	}

}
