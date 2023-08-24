package com.spring.pos.model;

import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblproduct")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productid")
	private int productID;

	@Column(name = "productname")
	private String productName;

	@Column(name = "barcode")
	private String barcode;

	@Column(name = "unitprice")
	private double unitPrice;

	@Column(name = "sellprice")
	private double sellPrice;

	@Lob
	@Column(name = "photo", columnDefinition = "LONGBLOB", nullable = true)
	@Basic(fetch = FetchType.LAZY)
	private byte[] photo;

	@Column(name = "qtyinstock")
	private int qtyInStock;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "categoryid", referencedColumnName = "categoryid")
	private Category category;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "productid", referencedColumnName = "productid")
	private List<AddStock> addStocks;

	public Product() {
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

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public int getQtyInStock() {
		return qtyInStock;
	}

	public void setQtyInStock(int qtyInStock) {
		this.qtyInStock = qtyInStock;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<AddStock> getAddStocks() {
		return addStocks;
	}

	public void setAddStocks(List<AddStock> addStocks) {
		this.addStocks = addStocks;
	}

	public class Metadata {
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
