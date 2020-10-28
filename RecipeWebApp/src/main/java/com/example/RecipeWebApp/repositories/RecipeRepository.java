package com.example.RecipeWebApp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.RecipeWebApp.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
