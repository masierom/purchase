package com.example.purchase.domain;

import org.springframework.data.annotation.Id;

public class Purchase {
	@Id
	private String id;
	private String productId;
	private String productTitle;
	private String productCategory;
	private int quantity;
	private double price;
	private String userId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductTitle() {
		return productTitle;
	}
	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}

/*
 * List user purchasers /api/purchase/{userId}
 * get purchase /api/purchase/{userId}/{id}
 * buy POST /api/purchase/{userId}
 */
