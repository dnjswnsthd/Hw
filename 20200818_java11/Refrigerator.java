package com.ssafy.hw.step11;

public class Refrigerator extends Product {
	private static final long serialVersionUID = -1453555407862274118L;
	private int liter;

	public Refrigerator() {
	}

	public Refrigerator(String productNum, String name, int price, int quantity, int liter) {
		super(productNum, name, price, quantity);
		this.liter = liter;
	}

	public int getLiter() {
		return liter;
	}

	public void setLiter(int liter) {
		this.liter = liter;
	}

	@Override
	public String toString() {
		return "Refrigerator [liter=" + liter + ", getProductNum()=" + getNum() + ", getName()=" + getName()
				+ ", getPrice()=" + getPrice() + ", getAmount()=" + getAmount() + "]";
	}

}
