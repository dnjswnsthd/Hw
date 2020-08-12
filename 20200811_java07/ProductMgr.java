package com.ssafy.java.day07.hw;
import java.util.ArrayList;

interface ProductMgr {
	public ArrayList<Product> getAl();
	public void setAl(ArrayList<Product> al);
	public void printAll();
	public void findName(String s) ;
	public void findSerial(String s);
	public void findTV();
	public void findRefrigerator();	
	public void findBigRefrigerator();
	public void findBigTV();
	public void modifyPrice(String s, int price) ;
	public void deleteWithSerial(String s);
	public long calcAllPrice() ;
}