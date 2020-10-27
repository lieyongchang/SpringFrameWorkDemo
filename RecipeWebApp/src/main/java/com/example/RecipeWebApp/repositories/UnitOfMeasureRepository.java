package com.example.RecipeWebApp.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.RecipeWebApp.domain.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
	Optional<UnitOfMeasure> findByDescription(String description);
}
