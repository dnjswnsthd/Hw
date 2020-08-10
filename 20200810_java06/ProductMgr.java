package com.ssafy.java.day06.hw;
import java.util.ArrayList;

class ProductMgr {
	private ArrayList<Product> al;
	public ProductMgr(ArrayList<Product> al) {
		this.al = al;
	}
	public ArrayList<Product> getAl() {
		return al;
	}
	public void setAl(ArrayList<Product> al) {
		this.al = al;
	}
	
	public void printAll() {
		for(Product p : al) System.out.println(p);
	}
	
	public void findName(String s) {
		boolean isFind=false;
		for(Product p : al) {
			if ( p.getName().indexOf(s) != -1) {
				isFind=true;
				System.out.println(p);
			}
		}
		if(!isFind) System.out.println("이름으로 검색합니다.");
	}
	
	public void findSerial(String s) {
		for(Product p : al) {
			if (p.getSerial().equals(s)) {
				System.out.println(p);
				return;
			}
		}
		System.out.println("상품 시리얼 번호으로 검색합니다.");
	}
	public void findTV() {
		for(Product p : al) {
			if (p instanceof TV) {
				System.out.println(p);
			}
		}
	}
	
	public void findRefrigerator() {
		for(Product p : al) {
			if (p instanceof Refrigerator) {
				System.out.println(p);
			}
		}
	}
	
	public void deleteWithSerial(String s) {
		for(int i =0; i<al.size(); i++) {
			if (al.get(i).getSerial().equals(s)) {
				System.out.println(al.get(i));
				System.out.println("상품 시리얼 번호로 삭제합니다.");
				al.remove(i);
				break;
			}
		}
	}

	public long calcAllPrice() {
		long sum = 0;
		for(Product p : al) {
			sum+=p.getCount() *p.getPrice();
		}
		return sum;
	}
	
}
