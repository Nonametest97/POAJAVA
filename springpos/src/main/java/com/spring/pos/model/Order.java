package com.spring.pos.model;

import java.sql.Date;
import java.sql.ResultSet;

public class Order {

	private int orderID;

	private Date orderDate;

	private User user;

	private double totalAmount;
	
	public Order() {
	}
	
	public Order(int orderID, Date orderDate, User user, double totalAmount) {
		this.orderID = orderID;
		this.orderDate = orderDate;
		this.user = user;
		this.totalAmount = totalAmount;
	}



//	public Order(ResultSet resultSet) {
//		
//		try {
//			this.orderID = resultSet.getInt(Metadata.ORDERID);
//			this.orderDate = resultSet.getDate(Metadata.ORDERDATE);
//			this.user = Services.USER_SERVICE.getUserById(resultSet.getInt(User.Metadata.USERID));
//			this.totalAmount = resultSet.getDouble(Metadata.TOTALAMOUNT);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public class Metadata{
		public static final String ORDERID = "OrderID";
		public static final String ORDERDATE = "OrderDate";
		public static final String USERID = "UserID";
		public static final String TOTALAMOUNT = "TotalAmount";
	}

}
