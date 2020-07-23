package com.ssafy;

public class ProductTest {

	public static void main(String[] args) {
		TV samsung_tv = new TV(1, "2020 QLED 8K", 1296440);
		TV lg_tv = new TV();
		Refrigerator samsung_ref = new Refrigerator();
		Refrigerator lg_ref = new Refrigerator(2, "LG전자 디오스 냉장고", 1169180, 38);
		samsung_tv.setTv_quantity(10);
		samsung_tv.setTv_size(70);
		samsung_tv.setTv_type("QLED");
		lg_tv .setTv_num(2);
		lg_tv .setTv_name("LG 올레드 TV");
		lg_tv .setTv_price(1920000);
		lg_tv .setTv_quantity(23);
		lg_tv .setTv_size(80);
		lg_tv .setTv_type("OLED");
		
		samsung_ref.setRef_num(1);
		samsung_ref.setRef_name("삼성 비스포크 냉장고");
		samsung_ref.setRef_price(132000);
		samsung_ref.setRef_quantity(7);
		samsung_ref.setRef_size(350);
		lg_ref.setRef_size(300);
		
		System.out.println("삼성 TV의 이름: " + samsung_tv.getTv_name() + " 입니다.");
		System.out.println(samsung_tv.toString());
		System.out.println("LG TV의 가격: " + lg_tv.getTv_price() + "원 입니다.");
		System.out.println(lg_tv.toString());
		System.out.println("삼성 냉장고의 크기: " + samsung_ref.getRef_size() + "L 입니다.");
		System.out.println(samsung_ref.toString());
		System.out.println("LG 냉장고의 남은 수량: " + lg_ref.getRef_quantity() + "대 입니다.");
		System.out.println(lg_ref.toString());
	}
}
