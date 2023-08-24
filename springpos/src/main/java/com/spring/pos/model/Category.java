package com.spring.pos.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Category {

	private int categoryID;

	private String categoryName;
	
	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(ResultSet resultSet) {
		
		try {
			this.categoryID = resultSet.getInt(Metadata.CATEGORYID);
			this.categoryName = resultSet.getString(Metadata.CATEGORYNAME);
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
	
	public class Metadata{
		public static final String CATEGORYID = "CategoryID";
		public static final String CATEGORYNAME = "CategoryName";
	}

}
