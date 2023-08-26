package com.spring.pos.model.request;

public class ProductForm {

	private String productName;

	private String barcode;

	private double unitPrice;

	private double sellPrice;

	private int qtyInStock;

	private int categoryID =-1;
	
	public ProductForm() {
	}
	
	public ProductForm(String productName, String barcode, double unitPrice, double sellPrice, int qtyInStock,
			Integer categoryID) {
		this.productName = productName;
		this.barcode = barcode;
		this.unitPrice = unitPrice;
		this.sellPrice = sellPrice;
		this.qtyInStock = qtyInStock;
		if(categoryID != null)
			this.categoryID = categoryID;
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

	public int getQtyInStock() {
		return qtyInStock;
	}

	public void setQtyInStock(int qtyInStock) {
		this.qtyInStock = qtyInStock;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	@Override
	public String toString() {
		return "ProductForm [productName=" + productName + ", barcode=" + barcode + ", unitPrice=" + unitPrice
				+ ", sellPrice=" + sellPrice + ", qtyInStock=" + qtyInStock + ", categoryID=" + categoryID + "]";
	}
	
	

}
