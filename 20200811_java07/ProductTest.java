package com.ssafy.java.day07.hw;

import java.util.ArrayList;

public class ProductTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductMgr mgr = new ProductMgrImpl(new ArrayList<Product>());
		mgr.getAl().add(new TV("01-01", "삼성_tv", 1324000, 7, 60.0, "FHD"));
		mgr.getAl().add(new TV("04-04", "삼성_tv4", 1324000, 7, 30.0, "FHD"));
		mgr.getAl().add(new TV("05-05", "삼성_tv5", 1324000, 7, 70.0, "FHD"));
		mgr.getAl().add(new Refrigerator("02-02", "삼성_ref", 164300, 100, 750));
		mgr.getAl().add(new Refrigerator("06-06", "삼성_ref", 164300, 100, 300));
		mgr.getAl().add(new Refrigerator("07-07", "삼성_ref", 164300, 100, 500));
		
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
		
		mgr.modifyPrice("05-05", 100000);
		System.out.println();
		
		mgr.findBigTV();
		System.out.println();
		
		mgr.fingBigRefrigerator();
		System.out.println();
		
		mgr.printAll();
		System.out.println();
		
		System.out.println("전체 재고 상품 금액의 합은 : " + mgr.calcAllPrice() + "입니다.");
	}
}

