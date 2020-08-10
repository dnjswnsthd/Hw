package com.ssafy.java.day06.hw;

import java.util.ArrayList;

public class ProductTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductMgr mgr = new ProductMgr(new ArrayList<Product>());
		mgr.getAl().add(new TV("01-01", "삼성_tv", 1324000, 7, 60.0, "FHD"));
		mgr.getAl().add(new Refrigerator("02-02", "삼성_ref", 164300, 100, 750));
		
		mgr.printAll();
		System.out.println();
		
		mgr.findSerial("");
		System.out.println();
		
		mgr.findSerial("01-01");
		System.out.println();
		
		mgr.findName("삼성_tv");
		System.out.println();
		
		mgr.findName("삼성_냉장고");
		System.out.println();
		
		mgr.findName("삼성");
		System.out.println();
		
		mgr.findTV();
		System.out.println();
		
		mgr.findRefrigerator();
		System.out.println();
		
		mgr.deleteWithSerial("01-01");
		mgr.printAll();
		System.out.println();
		
		mgr.getAl().add(new TV("03-03", "삼성_tv2", 153200, 71, 80.0, "4KHD"));
		mgr.printAll();
		System.out.println();
		
		System.out.println("전체 재고 상품 금액의 합은 : " + mgr.calcAllPrice() + "입니다.");
	}
}

