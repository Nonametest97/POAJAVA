package com.spring.pos.model;

public class OrderDetail {

	private Order order;

	private Product product;

	private int qty;

	private double price;

	private double total;

//	public OrderDetail(ResultSet resultSet) {
//		try {
//			this.order = Services.ORDER_SERVICE.getOrderById(resultSet.getInt(Order.Metadata.ORDERID));
//			this.product = Services.PRODUCT_SERVICE.getProductById(resultSet.getInt(Product.Metadata.PRODUCTID));
//			this.qty = resultSet.getInt(Metadata.QTY);
//			this.price = resultSet.getDouble(Metadata.PRICE);
//			this.total = resultSet.getDouble(Metadata.TOTAL);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	public class Metadata{
		public static final String QTY = "Qty";
		public static final String PRICE = "Price";
		public static final String TOTAL = "Total";
	}

}
