package com.ssafy.hw.step11;

public class ProductNotFoundException extends Exception {
	public ProductNotFoundException() {
		System.out.println("상품이 존재하지 않습니다.");
	}
}
