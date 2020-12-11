package com.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.model.User;

// paRepository defines standard CRUD methods, plus JPA-specific operations. We don’t have to write 
// implementation code because Spring Data JPA will generate necessary code at runtime,
// in form of proxy instances.

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	Optional<User> findById(long id);

}
