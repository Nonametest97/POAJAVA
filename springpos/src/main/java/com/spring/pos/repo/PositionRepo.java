package com.spring.pos.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.pos.model.Position;

@Repository
public interface PositionRepo extends CrudRepository<Position, Long>{
	

}
