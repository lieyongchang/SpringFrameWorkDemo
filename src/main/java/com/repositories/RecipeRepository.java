package com.repositories;

import org.springframework.data.repository.CrudRepository;

import com.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
