package com.ssafy;

public class Refrigerator {
	public int ref_num;
	public String ref_name;
	public int ref_price;
	public int ref_quantity;
	public int ref_size;
	
	public Refrigerator() {}
	public Refrigerator(int ref_num, String ref_name, int ref_price, int ref_quantity) {
		this.ref_num = ref_num;
		this.ref_name = ref_name;
		this.ref_price = ref_price;
		this.ref_quantity = ref_quantity;
	}
	public int getRef_num() {return ref_num;}
	public void setRef_num(int ref_num) {this.ref_num = ref_num;}
	
	public String getRef_name() {return ref_name;}
	public void setRef_name(String ref_name) {this.ref_name = ref_name;}
	
	public int getRef_price() {return ref_price;}
	public void setRef_price(int ref_price) {this.ref_price = ref_price;}
	
	public int getRef_quantity() {return ref_quantity;}
	public void setRef_quantity(int ref_quantity) {this.ref_quantity = ref_quantity;}
	
	public int getRef_size() {return ref_size;}
	public void setRef_size(int ref_size) {this.ref_size = ref_size;}
	
	public String toString() {
		return "냉장고 정보 == 번호 : " + this.ref_num + " 이름 : " + this.ref_name + " 가격 : " + this.ref_price + "원 수량 : " + this.ref_quantity + "대 용량 : " + this.ref_size + "L 입니다. =="; 
	}
}
