package com.ssafy.java.day11.hw;

import java.io.Serializable;

@SuppressWarnings("serial")
class TV extends Product implements Serializable{
	private int inch;
	private String displayType;
	
	public TV(String serial, String name, int price, int count,
			int inch, String displayType) {
		super(serial, name, price, count);
		// TODO Auto-generated constructor stub
		this.inch = inch;
		this.displayType=displayType;
	}
	public int getInch() {
		return inch;
	}
	public void setInch(int inch) {
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
		return super.toString() + String.format(" | %-5dInch | %-8s",
				this.getInch(), this.getDisplayType());
	}
}