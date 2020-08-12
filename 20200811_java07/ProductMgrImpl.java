package com.ssafy.java.day07.hw;

import java.util.ArrayList;

public class ProductMgrImpl implements ProductMgr{
	private ArrayList<Product> al;
	public ProductMgrImpl(ArrayList<Product> al) {
		this.al = al;
	}
	public ArrayList<Product> getAl() {
		return al;
	}
	public void setAl(ArrayList<Product> al) {
		this.al = al;
	}
	public void printAll() {
		for (Product p : al)
			System.out.println(p);
	}
	public void findName(String s) {
		for (Product p : al) {
			if (p.getName().indexOf(s) != -1) {
				System.out.println(p);
			}
		}
	}
	public void findSerial(String s) {
		for (Product p : al) {
			if (p.getSerial().equals(s)) {
				System.out.println(p);
				return;
			}
		}
	}
	public void findTV() {
		for (Product p : al) {
			if (p instanceof TV) {
				System.out.println(p);
			}
		}
	}

	public void findRefrigerator() {
		for (Product p : al) {
			if (p instanceof Refrigerator) {
				System.out.println(p);
			}
		}
	}
	
	public void findBigTV() {
		for (Product p : al) {
			if (p instanceof TV && ((TV) p).getInch() > 50) {
				System.out.println(p);
			}
		}
	}

	public void findBigRefrigerator() {
		for (Product p : al) {
			if (p instanceof Refrigerator && ((Refrigerator) p).getSize() > 400) {
				System.out.println(p);
			}
		}
	}

	public void modifyPrice(String s, int price) {
		for (Product p : al) {
			if (p.getSerial().equals(s)) {
				p.setPrice(price);
			}
		}
	}

	public void deleteWithSerial(String s) {
		for (int i = 0; i < al.size(); i++) {
			if (al.get(i).getSerial().equals(s)) {
				System.out.println(al.get(i));
				al.remove(i);
				break;
			}
		}
	}

	public long calcAllPrice() {
		long sum = 0;
		for (Product p : al) {
			sum += p.getPrice();
		}
		return sum;
	}
}
