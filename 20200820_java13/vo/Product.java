package com.ssafy.hw14.vo;

public class Product {
	private String serial;
	private String name;
	private int price;
	private int quantity;
	
	public Product() {
		super();
	}
	public Product(String serial, String name, int price, int quantity) {
		super();
		this.serial = serial;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	@Override
	public String toString() {
		return "Product [serial=" + serial + ", name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}
}
