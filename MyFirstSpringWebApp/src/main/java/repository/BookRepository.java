package repository;

import org.springframework.data.repository.CrudRepository;

import domain.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
