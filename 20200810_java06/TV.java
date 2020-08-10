package com.ssafy.java.day06.hw;

class TV extends Product {
	private double inch;
	private String displayType;
	
	public TV(String serial, String name, int price, int count,
			double inch, String displayType) {
		super(serial, name, price, count);
		// TODO Auto-generated constructor stub
		this.inch = inch;
		this.displayType=displayType;
	}
	public double getInch() {
		return inch;
	}
	public void setInch(double inch) {
		this.inch = inch;
	}
	public String getDisplayType() {
		return displayType;
	}
	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + String.format(" | %-5.1f | %-8s",
				this.getInch(), this.getDisplayType());
	}
}