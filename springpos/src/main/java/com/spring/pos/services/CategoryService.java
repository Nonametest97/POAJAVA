package com.spring.pos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.pos.model.Category;
import com.spring.pos.model.Product;
import com.spring.pos.model.request.CategoryForm;
import com.spring.pos.model.response.ProductResponse;
import com.spring.pos.repo.CategoryRepo;
import com.spring.pos.repo.ProductRepo;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepo repo;
	
	@Autowired
	private ProductRepo proRepo;

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
		
		if(!isDeleteAll) {
			List<Product> products = category.getProducts();
			for(Product product : products) {
				product.setCategory(null);
				proRepo.save(product);
			}
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
