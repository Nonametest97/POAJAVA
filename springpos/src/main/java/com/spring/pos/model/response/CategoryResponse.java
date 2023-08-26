package com.spring.pos.model.response;

import java.util.List;

import com.spring.pos.model.request.ProductForm;

public class CategoryResponse {

	private int categoryID;

	private String categoryName;

	private List<ProductResponse> products;

	public CategoryResponse() {
	}

	public List<ProductResponse> getProducts() {
		return products;
	}

	public void setProducts(List<ProductResponse> products) {
		this.products = products;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
