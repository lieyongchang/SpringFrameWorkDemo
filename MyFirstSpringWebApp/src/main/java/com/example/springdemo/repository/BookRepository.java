package com.example.springdemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.springdemo.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
