package com.spring.pos.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.pos.model.Category;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Integer>{

}
