package com.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

	// Optional is a new container type that wraps a single value,
	Optional<Category> findByDescription(String description);
}
