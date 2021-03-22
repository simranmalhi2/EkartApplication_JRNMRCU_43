package com.ekart.model;

import java.util.Date;

public class Product {

	private Long productId;
	private String name;
	private double price;
	private int quantity;
	private Date manufacturedDate;
	private Date expiryDate;
	
	public Product() {
		
	}
	
	public Product(Long productId, String name, double price, int quantity, Date manufacturedDate, Date expiryDate) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.manufacturedDate = manufacturedDate;
		this.expiryDate = expiryDate;
	}
	
	public Product(Long productId, String name, double price, int quantity) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public Product(Long productId) {
		super();
		this.productId = productId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getManufacturedDate() {
		return manufacturedDate;
	}

	public void setManufacturedDate(Date manufacturedDate) {
		this.manufacturedDate = manufacturedDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", price=" + price + ", quantity=" + quantity
				+ ", manufacturedDate=" + manufacturedDate + ", expiryDate=" + expiryDate + "]";
	}
	
	


}
