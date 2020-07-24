package com.ssafy;

public class Product {
	private int num;
	private String name;
	private int price;
	private int quantity;
	
	public Product() {}
	public Product(int num, String name, int price, int quantity) {
		super();
		this.num = num;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String toString() {
		return "상품 번호: " + num + "\t| 상품이름 : " + name + "\t| 가격 : " + price + "원  \t| 수량 : " + quantity + "대 입니다.";
	}
	
}
