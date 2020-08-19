package com.ssafy.hw.step11;

import java.util.List;

public interface IProductMgr {
	public void add(Product p) throws DuplicateException;
	public List<Product> selectProductList();
	public Product selectProductByNum(String num) throws ProductNotFoundException;
	public List<Product> selectProductsByName(String name);
	public List<Product> selectTvList();
	public List<Product> selectRefrigeratorList();
	
	public List<Product> selectRefr400() throws ProductNotFoundException;
	public List<Product> selectTV50() throws ProductNotFoundException;
	public List<Product> selectProductsByNamePrice(String name,int price);
	
	public void deleteProduct(String num);
	
	public void updateProduct(String num, int price);
	public int totalSum();
	public void open();
	public void close();
	public void sendDataToServer();
}
