package com.spring.pos.services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring.pos.controller.ResponseStatus;
import com.spring.pos.model.Category;
import com.spring.pos.model.Product;
import com.spring.pos.model.request.ProductForm;
import com.spring.pos.repo.CategoryRepo;
import com.spring.pos.repo.ProductRepo;
import com.spring.pos.util.FormHelper;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class ProductService {

	@Autowired
	private ProductRepo repo;
	
	@Autowired
	private CategoryService categoryService;

	public Product getById(int id) {
		Optional<Product> product = repo.findById(id);
		return product.orElse(null);
	}

	public Product insert(ProductForm form, MultipartFile photo, ResponseStatus responseStatus) throws Exception {
		if (form == null) {
			return null;
		}
		
		int categoryId = form.getCategoryID();
		Category category = null;
		if(categoryId != -1 && (category = categoryService.getById(categoryId)) == null) {
			responseStatus.addMessage("Category does not exist with id[" + form.getCategoryID() + "]");
			return null;
		}
		
		Product product = new Product();
		BeanUtils.copyProperties(form, product);
		if (photo!=null && photo.getBytes().length > 0) {
			product.setPhoto(photo.getBytes());
		}
		product.setCategory(category);
		repo.save(product);

		return product;
	}
	
	public Product updateProductById(int id, HttpServletRequest request, ProductForm form,MultipartFile photo, ResponseStatus response) throws Exception {
		Product product = getById(id);
		if(product == null) {
			return null;
		}
		
		FormHelper.setOnlyRequest(request, form, product);
		if(photo !=null && photo.getBytes() !=null && photo.getBytes().length > 0) {
			product.setPhoto(photo.getBytes());
		}
		
		
		return repo.save(product);
		
	}
	
	public boolean deleteById(int id) {
		return deleteById(id,false);
	}
	
	public boolean deleteById(int id, boolean isDeleteAll) {
		Product product = getById(id);
		if(product == null)
			return false;
		
		if(!isDeleteAll) {
			product.setCategory(null);
			repo.save(product);
		}
		
		repo.deleteById(id);
		return true;
	}

//	public Product insertProduct()

}
