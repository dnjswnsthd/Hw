package com.ssafy.hw.step11;

public class TV extends Product{
	private static final long serialVersionUID = 1L;
	
	private int inch;
	private String type;
	
	public TV(String productNum, String name, int price, int amount, int inch, String type) {
		super(productNum, name, price, amount);
		this.inch = inch;
		this.type = type;
	}

	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "TV [inch=" + inch + ", type=" + type + ", getNum()=" + getNum() + ", getName()="
				+ getName() + ", getPrice()=" + getPrice() + ", getAmount()=" + getAmount() + "]";
	}
}
