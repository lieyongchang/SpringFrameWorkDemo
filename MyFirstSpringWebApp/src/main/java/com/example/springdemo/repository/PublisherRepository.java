package com.example.springdemo.repository;
import org.springframework.data.repository.CrudRepository;

import com.example.springdemo.domain.*;

public interface PublisherRepository extends CrudRepository<Publisher,Long>{

}
