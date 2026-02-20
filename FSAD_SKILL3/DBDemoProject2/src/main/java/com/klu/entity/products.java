package com.klu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class products {
	
	@Override
	public String toString() {
		return "products [productid=" + productid + ", name=" + name + ", category=" + category + ", price=" + price
				+ ", quantity=" + quantity +"]";
	}
	@Id
	private int productid;
	@Column
	private String name;
	
	private String category;
	
	private int price;
	private int quantity;
	public products(int productid, String name,int price,String category,int quantity) {
		super();
		this.productid = productid;
		this.name = name;
		this.price=price;
		this.category=category;
		this.quantity=quantity;
	}
	public products() {
		// TODO Auto-generated constructor stub
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	

}
