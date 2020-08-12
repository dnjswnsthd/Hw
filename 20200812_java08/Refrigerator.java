package com.ssafy.java.day07.hw;

class Refrigerator extends Product {
	private int size;
	
	public Refrigerator(String serial, String name, int price, int count,
			int size) {
		super(serial, name, price, count);
		// TODO Auto-generated constructor stub
		this.size=size;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + String.format(" | %5dL",
				this.getSize());
	}	
}
