package com.example.RecipeWebApp.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.RecipeWebApp.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

	Optional<Category> findByDescription(String description);
}
