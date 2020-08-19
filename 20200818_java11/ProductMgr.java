package com.ssafy.java.day11.hw;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

interface ProductMgr {
	public ArrayList<Product> getAl();
	public void setAl(ArrayList<Product> al);
	public void add(Product p) throws DuplicateException;
	public void printAll();
	public void findName(String s) ;
	public void findSerial(String s);
	public void findTV();
	public void findRefrigerator(); 	
	public void findBigRefrigerator() throws ProductNotFoundException;
	public void findBigTV() throws ProductNotFoundException;; 
	public void modifyPrice(String s, int price) ;
	public void sell(String s, int quantity) throws QuantityException, SerialNotFoundException;
	public void buy(String s, int quantity) throws SerialNotFoundException;
	public void deleteWithSerial(String s);
	public long calcAllPrice() ;
	public void open();
	public void close();
	public void sendDataToServer();
	public void save() throws FileNotFoundException, IOException;
	public void read() throws FileNotFoundException, IOException;
}