/**
 * 
 */
package com.example.RecipeWebApp.repositories;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.RecipeWebApp.domain.UnitOfMeasure;

/**
 * @author darkk This is about Spring Integration test
 */
@RunWith(SpringRunner.class)
@DataJpaTest
class UnitOfMeasureRepositoryTest {

	@Autowired
	UnitOfMeasureRepository uomRepo;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	public void findByDescription() throws Exception {
		Optional<UnitOfMeasure> uom = uomRepo.findByDescription("Teaspoon");
		Optional<UnitOfMeasure> uomCup = uomRepo.findByDescription("Cup");

		assertEquals("Teaspoon", uom.get().getDescription());
		assertEquals("Cup", uomCup.get().getDescription());
	}

}
