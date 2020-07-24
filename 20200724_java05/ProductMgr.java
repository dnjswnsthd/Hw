package com.ssafy;

public class ProductMgr {
	private Product [] products = new Product[100];
	private Product [] products_tmp = new Product[100];
	private Product product = new Product();
	private int index = 0;
	private int index_tmp = 0;
	static ProductMgr productmgr = null;
	
	private ProductMgr() {}
	
	public static ProductMgr getInstance() {
		if(productmgr == null) {
			productmgr = new ProductMgr();
		}
		return productmgr;
	}
	public void add(Product p) {
		products[index] = p;
		index++;
	}
	public Product[] list() {
		return products;
	}
	public Product list(int num) {
		for(int i = 0; i < index; i++) {
			if(products[i].getNum() == num) {
				product = products[i];
				break;
			}
		}
		return product;
	}
	public void delete(int num) {
		for(int i = 0; i < index; i++) {
			if(products[i].getNum() == num) {
				if (index == 1) {
					products[i] = null;
				}
				else {
					products[i] = products[index-1];
				}
			}
		}index--;
	}
	public Product[] priceList(int price) {
		index_tmp = 0;
		for (int i = 0; i < index; i++) {
			if(products[i].getPrice() <= price) {
				products_tmp[index_tmp] = products[i];
				index_tmp++;
			}
		}
		return products_tmp;
	}
	public int getSize() {
		return index;
	}
	public int getTmpSize() {
		return index_tmp;
	}
}
