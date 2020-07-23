package com.ssafy;

public class TV {
	public int tv_num;
	public String tv_name;
	public int tv_price;
	public int tv_quantity;
	public int tv_size;
	public String tv_type;
	
	public TV() {}
	public TV(int tv_num, String tv_name, int tv_price) {
		this.tv_num = tv_num;
		this.tv_name = tv_name;
		this.tv_price = tv_price;
	}
	public int getTv_num() {return tv_num;}
	public void setTv_num(int tv_num) {this.tv_num = tv_num;}
	
	public String getTv_name() {return tv_name;}
	public void setTv_name(String tv_name) {this.tv_name = tv_name;}
	
	public int getTv_price() {return tv_price;}
	public void setTv_price(int tv_price) {this.tv_price = tv_price;}
	
	public int getTv_quantity() {return tv_quantity;}
	public void setTv_quantity(int tv_quantity) {this.tv_quantity = tv_quantity;}
	
	public int getTv_size() {return tv_size;}
	public void setTv_size(int tv_size) {this.tv_size = tv_size;}
	
	public String getTv_type() {return tv_type;}
	public void setTv_type(String tv_type) {this.tv_type = tv_type;}
	
	public String toString() {
	return "TV 정보 == 번호 : " + this.tv_num + "이름 : " + this.tv_name + " 가격 : " + this.tv_price + "원 수량 : " + this.tv_quantity + "대 인치 : " + this.tv_size + "inch 디스플레이 타입 : " + this.tv_type + " 입니다. =="; 
	}
}
