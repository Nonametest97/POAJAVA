package com.spring.pos.services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.pos.model.Category;
import com.spring.pos.model.request.CategoryForm;
import com.spring.pos.repo.CategoryRepo;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepo repo;

	public Category getById(int id) {
		Optional<Category> category = repo.findById(id);
		return category.orElse(null);
	}

	public Category insert(CategoryForm form) {
		if (form == null) {
			return null;
		}

		Category category = new Category();
		BeanUtils.copyProperties(form, category);
		
		category = repo.save(category);

		return category;
	}
	
	public Category update(int id, CategoryForm form) {
		Category category = getById(id);
		if(category == null) {
			return null;
		}
		
		BeanUtils.copyProperties(form, category);
		repo.save(category);
		return category;
	}

	public boolean deleteById(int id, boolean isDeleteAll) {
		Category category = getById(id);
		if (category == null) {
			return false;
		}
		
		if(isDeleteAll) {
			category.setProducts(null);
			repo.save(category);
		}
		
		repo.deleteById(id);
		return true;
	}
	
	public Iterable<Category> getAll(){
		return repo.findAll();
	}

}
