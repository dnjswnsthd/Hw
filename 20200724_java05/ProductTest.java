package com.ssafy;
import java.util.Scanner;

public class ProductTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ProductMgr productmgr = ProductMgr.getInstance();
		Product products;
		
		loop:while(true) {
			System.out.println(" <<< 상품 정보 프로그램 >>> ");
			System.out.println("1. 상품 정보 입력");
			System.out.println("2. 상품 정보 전체 보기");
			System.out.println("3. 상품 번호로 검색");
			System.out.println("4. 상품 번호로 삭제");
			System.out.println("5. 특정가격 이하의 상품만 검색");
			System.out.println("0. 종료");
			
			int num = sc.nextInt();
			sc.nextLine();
			
			switch(num){
			case(1): {
				System.out.println("1.상품 정보 입력");
				System.out.println("상품 번호 : ");
				int pro_num = sc.nextInt();
				sc.nextLine();
				
				System.out.println("상품 이름 : ");
				String pro_name = sc.nextLine();
				
				System.out.println("상품 가격 : ");
				int pro_price = sc.nextInt();
				sc.nextLine();
				
				System.out.println("상품 수량 : ");
				int pro_quantity = sc.nextInt();
				sc.nextLine();
				products = new Product(pro_num, pro_name, pro_price, pro_quantity);
				productmgr.add(products);
				break;
			}
			case(2):{
				System.out.println("2. 상품 정보 전체 보기");
				for(int i = 0; i < productmgr.getSize(); i++) {
					System.out.println(productmgr.list()[i].toString());
				}
				break;
			}
			case(3):{
				System.out.println("3. 상품 번호로 검색");
				System.out.println("원하는 상품의 번호를 입력하세요 : ");
				int search_num = sc.nextInt();
				sc.nextLine();
				System.out.println(productmgr.list(search_num).toString());
				break;
			}
			case(4):{
				System.out.println("4. 상품 번호로 삭제");
				System.out.println("삭제하고 싶은 상품의 번호를 입력하세요 : ");
				int delete_num = sc.nextInt();
				sc.nextLine();
				productmgr.delete(delete_num);
				break;
			}
			case(5):{
				System.out.println("5. 특정가격 이하의 상품만 검색");
				System.out.println("검색하고 싶은 가격을 입력하세요 : ");
				int price_num = sc.nextInt();
				sc.nextLine();
				productmgr.priceList(price_num);
				for(int i = 0; i < productmgr.getTmpSize(); i++) {
					System.out.println(productmgr.priceList(price_num)[i].toString());
				}
				break;
			}
			case(6):{
				break loop;
			}
			
			}
		}
		sc.close();
	}
}
