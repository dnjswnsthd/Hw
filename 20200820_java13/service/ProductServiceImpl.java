package com.ssafy.hw14.service;

import java.util.List;

import com.ssafy.hw14.dao.ProductDAO;
import com.ssafy.hw14.dao.ProductDAOImpl;
import com.ssafy.hw14.vo.Product;

public class ProductServiceImpl implements ProductService {
	ProductDAO dao = new ProductDAOImpl();

	@Override
	public boolean addProduct(Product product) {
		return dao.addProduct(product);
	}

	@Override
	public List <Product> getListAll() {
		return dao.getListAll();
	}

	@Override
	public void selectSerial(Product product) {
		dao.selectSerial(product);
	}

	@Override
	public List<Product> getListCheap(int price) {
		return dao.getListCheap(price);
	}

	@Override
	public void selectName(Product product) {
		dao.selectName(product);
	}

	@Override
	public void deleteSerial(Product product) {
		dao.deleteSerial(product);
	}

	@Override
	public void modiSerial(Product product, int price) {
		dao.modiSerial(product, price);
	}
}
