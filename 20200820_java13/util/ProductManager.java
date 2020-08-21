package com.ssafy.hw14.util;

import java.util.List;

import com.ssafy.hw14.service.ProductService;
import com.ssafy.hw14.service.ProductServiceImpl;
import com.ssafy.hw14.vo.Product;
//싱글턴 디자인 패턴
public class ProductManager {
	private static ProductManager instance;
	ProductService service = new ProductServiceImpl();
	private ProductManager() {}
	public static ProductManager getInstance() {
		if(instance == null) {
			instance = new ProductManager();
		}
		return instance;
	}
	public boolean addProduct(Product product) {
		return service.addProduct(product);
	}
	public List <Product> getListAll(){
		return service.getListAll();
	}
	public void selectSerial(Product product) {
		service.selectSerial(product);
	}
	public List <Product> getListCheap(int price){
		return service.getListCheap(price);
	}
	public void selectName(Product product) {
		service.selectName(product);
	}
	public void deleteSerial(Product product) {
		service.deleteSerial(product);
	}
	public void modiSerial(Product product, int price) {
		service.modiSerial(product, price);
	}
}
