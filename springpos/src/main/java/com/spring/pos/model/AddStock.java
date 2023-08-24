package com.spring.pos.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbladdstock")
public class AddStock {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "addstockid")
	private long addStockId;

	@ManyToOne
	@JoinColumn(name = "productid", referencedColumnName = "productid")
	private Product product;

	@Column(name = "adddate")
	private Date addDate;

	@Column(name = "expiredate")
	private Date expireDate;

	@Column(name = "qty")
	private int qty;

	@ManyToOne
	@JoinColumn(name = "userid", referencedColumnName = "userid")
	private User user;
	
	public AddStock() {
	}
	
	public long getAddStockId() {
		return addStockId;
	}

	public void setAddStockId(long addStockId) {
		this.addStockId = addStockId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
