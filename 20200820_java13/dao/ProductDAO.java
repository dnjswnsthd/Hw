package com.ssafy.hw14.dao;

import java.util.List;

import com.ssafy.hw14.vo.Product;

public interface ProductDAO {
	boolean addProduct(Product product);
	List <Product> getListAll();
	void selectSerial(Product product);
	List <Product> getListCheap(int price);
	void selectName(Product product);
	void deleteSerial(Product product);
	void modiSerial(Product product, int price);
}
