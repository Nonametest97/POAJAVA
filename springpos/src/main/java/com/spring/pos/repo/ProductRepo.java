package com.spring.pos.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.pos.model.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, Integer>{

	
	
}
