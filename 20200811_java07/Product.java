package com.ssafy.java.day07.hw;

class Product {
	private String serial;
	private String name;
	private int price;
	private int count;
	
	public Product(String serial, String name, int price, int count) {
		this.serial = serial;
		this.name = name;
		this.price = price;
		this.count = count;
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return String.format("%-10s | %-15s | %-15d | %8d",
				this.getSerial(), this.getName(),
				this.getPrice(), this.getCount());
	}
}