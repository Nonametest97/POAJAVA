package com.spring.pos.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblorder")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderid")
	private int orderID;

	@Column(name = "orderdate")
	private Date orderDate;

	@Column(name = "userid")
	private String userId;

	@Column(name = "totalamount")
	private double totalAmount;

	@OneToMany
	@JoinColumn(name = "orderid", referencedColumnName = "orderid")
	private List<OrderDetail> orderDetails;

	public Order() {
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public class Metadata {
		public static final String ORDERID = "OrderID";
		public static final String ORDERDATE = "OrderDate";
		public static final String USERID = "UserID";
		public static final String TOTALAMOUNT = "TotalAmount";
	}

}
