package com.spring.pos.model;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Product {
	
	private int productID;
	
	private String productName;
	
	private String barcode;
	
	private double unitPrice;
	
	private double sellPrice;
	
	private Category category;
	
	private String photo;
	
	private int qtyInStock;
	
	private byte[] photoByte;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
//	public Product(ResultSet resultSet) {
//		try {
//			this.productID = resultSet.getInt(Metadata.PRODUCTID);
//			this.productName = resultSet.getString(Metadata.PRODUCTNAME);
//			this.barcode = resultSet.getString(Metadata.BARCODE);
//			this.unitPrice = resultSet.getDouble(Metadata.UNITPRICE);
//			this.sellPrice = resultSet.getDouble(Metadata.SELLPRICE);
////			this.photo = resultSet.getString(Metadata.PHOTO);
//			this.photoByte = resultSet.getBytes(Metadata.PHOTO);
//			this.qtyInStock = resultSet.getInt(Metadata.QTYINSTOCK);
//			
//			this.category = Services.CATEGORY_SERVICE.getCategoryById(resultSet.getInt(Category.Metadata.CATEGORYID));
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getQtyInStock() {
		return qtyInStock;
	}

	public void setQtyInStock(int qtyInStock) {
		this.qtyInStock = qtyInStock;
	}
	
	public byte[] getPhotoByte() {
		return photoByte;
	}

	public void setPhotoByte(byte[] photoByte) {
		this.photoByte = photoByte;
	}



	public class Metadata{
		public static final String PRODUCTID = "ProductID";
		public static final String PRODUCTNAME = "ProductName";
		public static final String BARCODE = "Barcode";
		public static final String UNITPRICE = "UnitPrice";
		public static final String SELLPRICE = "SellPrice";
//		public static final String CATEGORYID = "CategoryID";
		public static final String PHOTO = "Photo";
		public static final String QTYINSTOCK = "QtyInStock";
	}
	
	

}
