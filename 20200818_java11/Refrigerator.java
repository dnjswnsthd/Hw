package com.ssafy.java.day11.hw;

import java.io.Serializable;

@SuppressWarnings("serial")
class Refrigerator extends Product implements Serializable{
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
