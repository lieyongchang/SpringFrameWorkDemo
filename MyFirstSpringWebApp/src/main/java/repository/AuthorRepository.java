package repository;

import org.springframework.data.repository.CrudRepository;

import domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
