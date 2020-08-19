package com.ssafy.hw.step11;
import java.io.Serializable;

public class Product implements Serializable {
	
	private static final long serialVersionUID = 6857083847779482116L;
	
	private String num;
	private String name;
	private int price;
	private int amount;

	public Product() {
	}
	
	public Product(String num, String name, int price, int amount) {
		this.num = num;
		this.name = name;
		this.price = price;
		this.amount = amount;
	}

	
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
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
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Product [productNum=" + num + ", name=" + name + ", price=" + price + ", amount=" + amount + "]";
	}

	
}
