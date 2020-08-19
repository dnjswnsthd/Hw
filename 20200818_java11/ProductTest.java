package com.ssafy.hw.step11;

import java.util.List;
import java.util.Scanner;

public class ProductTest {

	private IProductMgr pm = ProductMgrImpl.getInstance();
	private Scanner sc = new Scanner(System.in);

	public void service() {
		while (true) {
			try {				
				switch (choiceMenu(sc)) {
				case 0: exit(); return;
				case 1: addProduct(); break;
				case 2: showAllProducts(); break;
				case 3: showProductByNum(); break;
				case 4: showProductsByName(); break;
				case 5: showTV(); break;
				case 6: showRefrigerator(); break;
				case 7: showRefr400(); break;
				case 8: showTV50(); break;
				case 9: updateProduct(); break;
				case 10: deleteProduct(); break;
				case 11: showTotalSum(); break;
				case 12: showProductsByNamePrice(); break;
				case 13: sendDataToServer(); break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void sendDataToServer() {
		System.out.println("서버로 send!!!");
		pm.sendDataToServer();
	}

	private void showProductsByNamePrice() {
		System.out.println("상품명과 원하는금액은?");
		printProducts(pm.selectProductsByNamePrice(sc.next(), sc.nextInt()));
	}

	private void showTotalSum() {
		System.out.println("전체 재고금액은 " + pm.totalSum() + "원 입니다.");
	}

	private void deleteProduct() {
		System.out.println("삭제할 상품 번호?");
		pm.deleteProduct(sc.next());
	}

	private void updateProduct() {
		System.out.println("상품 번호와 상품가격은?");
		pm.updateProduct(sc.next(), sc.nextInt());
	}

	private void showTV50() throws ProductNotFoundException {
		printProducts(pm.selectTV50());
	}

	private void showRefr400() throws ProductNotFoundException {
		printProducts(pm.selectRefr400());
	}

	private void showRefrigerator() {
		printProducts(pm.selectRefrigeratorList());
	}

	private void showTV() {
		printProducts(pm.selectTvList());
	}

	private void showProductsByName() {
		System.out.println("상품 명 검색");
		printProducts(pm.selectProductsByName(sc.next()));
	}

	private void showProductByNum() throws ProductNotFoundException {
		System.out.println("상품번호 입력");
		System.out.println(pm.selectProductByNum(sc.next()));
	}

	private void showAllProducts() {
		printProducts(pm.selectProductList());
	}

	private void printProducts(List<Product> list) {
		list.stream().forEach(System.out::println);
	}
	
	private void addProduct() throws DuplicateException {
		System.out.println("1.TV 2.냉장고 정보 입력");
		int kind = sc.nextInt();
		
		System.out.print("상품번호 : ");
		String num = sc.next();

		System.out.print("상품이름 : ");
		String name = sc.next();
		
		System.out.print("상품가격 : ");
		int price = sc.nextInt();
		
		System.out.print("상품수량 : ");
		int amount = sc.nextInt();
		
		Product p = null;
		if (kind == 1) {
			System.out.print("인치 : ");
			int inch = sc.nextInt();
			
			System.out.print("타입 : ");
			String type = sc.next();
			
			p = new TV(num, name, price, amount, inch, type);
		} else if (kind == 2) {
			System.out.print("용량 : ");
			int quantity = sc.nextInt();
			
			p = new Refrigerator(num, name, price, amount, quantity);
		}
		pm.add(p);
		System.out.println("상품이 추가되었습니다.");
	}

	private void exit() {
		pm.close();
		System.out.println("프로그램이 종료되었습니다.");
	}

	private int choiceMenu(Scanner sc) {
		System.out.println("번호를 입력하세요");
		System.out.println("1. 상품정보 저장");
		System.out.println("2. 상품 전체검색");
		System.out.println("3. 상품번호로 상품을 검색");
		System.out.println("4. 상품명으로 상품을 검색(포함)");
		System.out.println("5. TV정보만 검색");
		System.out.println("6. 냉장고만 검색");
		System.out.println("7. 400L이상의 냉장고검색");
		System.out.println("8. 50인치 이상의 티비 검색");
		System.out.println("9. 상품가격 변경");
		System.out.println("10. 상품 삭제");
		System.out.println("11. 전체 재고금액");
		System.out.println("12. 상품명 포함하는 것들 중에 지정가격 이하 목록");
		System.out.println("13. 상품 정보 데이터 서버로 보내기");
		System.out.println("0. 종료");
		return sc.nextInt();
	}

	public static void main(String[] args) throws Exception {
		new ProductTest().service();
	}
}
