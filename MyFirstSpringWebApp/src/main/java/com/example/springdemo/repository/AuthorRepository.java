package com.example.springdemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.springdemo.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
