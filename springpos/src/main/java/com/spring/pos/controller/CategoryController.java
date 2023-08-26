package com.spring.pos.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.pos.model.Category;
import com.spring.pos.model.Product;
import com.spring.pos.model.request.CategoryForm;
import com.spring.pos.model.request.ProductForm;
import com.spring.pos.model.response.CategoryResponse;
import com.spring.pos.model.response.ProductResponse;
import com.spring.pos.services.CategoryService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService service;

	@GetMapping
	public ResponseStatus getAllCategory() {
		ResponseStatus responseStatus = new ResponseStatus(ResponseStatus.STATUS_SUCCESS);
		Iterator<Category> categories = service.getAll().iterator();
		List<CategoryResponse> list = new ArrayList<CategoryResponse>();
		while (categories.hasNext()) {
			Category category = categories.next();
			CategoryResponse categoryResponse = new CategoryResponse();
			BeanUtils.copyProperties(category, categoryResponse);

			list.add(categoryResponse);
		}
		responseStatus.setResult(list);

		return responseStatus;

	}

	@GetMapping("/{id}")
	public ResponseStatus getCategoryById(@PathVariable int id, @RequestParam(required = false) boolean detail,
			HttpServletRequest request) {
		ResponseStatus responseStatus = new ResponseStatus(ResponseStatus.STATUS_NOTFOUND,
				"Could not find Category wit id [" + id + "]");
		Category category = service.getById(id);
		if (category == null) {
			return responseStatus;
		}

		CategoryResponse categoryResponse = new CategoryResponse();
		BeanUtils.copyProperties(category, categoryResponse);

		if (detail) {
			List<ProductResponse> productForms = new ArrayList<ProductResponse>();
			for (Product product : category.getProducts()) {
				ProductResponse productResponse = new ProductResponse();
				BeanUtils.copyProperties(product, productResponse);
				productResponse.setPhotoUrl(ProductController.generateUrl(request, product));
				
				productForms.add(productResponse);
			}
			categoryResponse.setProducts(productForms);
			
		}

		responseStatus.setStatus(ResponseStatus.STATUS_FOUND);
		responseStatus.setMessages("");
		responseStatus.setResult(categoryResponse);
		return responseStatus;
	}

	@PostMapping
	public ResponseStatus insertCategory(@RequestBody CategoryForm form) {
		Category category = service.insert(form);
		ResponseStatus responseStatus = new ResponseStatus(ResponseStatus.STATUS_USER_ERROR, "Error User input");
		if (category != null) {
			CategoryResponse response = new CategoryResponse();
			BeanUtils.copyProperties(category, response);
			responseStatus.setResult(response);

			responseStatus.setStatus(ResponseStatus.STATUS_SUCCESS);
			responseStatus.setMessages("");
		}
		return responseStatus;
	}

	@PatchMapping("/{id}")
	public ResponseStatus updateCategoryById(int id, @RequestBody CategoryForm form) {
		ResponseStatus responseStatus = new ResponseStatus(ResponseStatus.STATUS_NOTFOUND,
				"Could not find Category wit id [" + id + "]");
		Category category = service.update(id, form);

		if (category == null) {
			return responseStatus;
		}

		CategoryResponse response = new CategoryResponse();
		BeanUtils.copyProperties(category, response);
		responseStatus.setResult(response);

		responseStatus.setStatus(ResponseStatus.STATUS_SUCCESS);
		responseStatus.setMessages("");
		return responseStatus;
	}

	@DeleteMapping("/{id}")
	public ResponseStatus deleteCategoryById(@PathVariable int id, @RequestParam(required = false) boolean hardDelete) {
		ResponseStatus responseStatus = new ResponseStatus(ResponseStatus.STATUS_NOTFOUND,
				"Could not find Category wit id [" + id + "]");
		boolean isDelete = service.deleteById(id, hardDelete);
		if (isDelete) {
			responseStatus.setStatus(ResponseStatus.STATUS_FOUND);
			responseStatus.setMessages("Delete Category with id [" + id + "]" + " successful");
		}
		return responseStatus;
	}

}
