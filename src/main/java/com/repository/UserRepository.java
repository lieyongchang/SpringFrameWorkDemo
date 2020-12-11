package com.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	/**
	 * Retrieve all <code>Vet</code>s from the data store.
	 * 
	 * @return a <code>Collection</code> of <code>Vet</code>s
	 */
	@Transactional(readOnly = true)
	@Cacheable("users")
	List<User> findAll() throws DataAccessException;
}
