package com.ssafy.hw14.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

import com.ssafy.hw14.util.ProductManager;
import com.ssafy.hw14.vo.Product;

public class ProductTest {
	ProductTest() throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		loop:while (true) {
			System.out.println(" ======= Electro Mart 재고 관리 시스템 ======= ");
			System.out.println("1. 상품 정보 추가 ");
			System.out.println("2. 상품 전체 정보 검색 ");
			System.out.println("3. 상품명으로 검색 ");
			System.out.println("4. 상품 특정 가격 이하 가격 검색");
			System.out.println("5. 제품 번호로 검색 ");
			System.out.println("6. 제품 번호로 삭제 ");
			System.out.println("7. 제품번호로 찾아 가격 업데이트 기능 ");
			System.out.println("8. 종료");

			System.out.println("원하는 작업의 번호를 입력해주세요");
			int num = Integer.parseInt(br.readLine());
			ProductManager manager = ProductManager.getInstance();
			System.out.println();

			switch (num) {
			case (1): {
				System.out.println(" ======= Electro Mart 재고 관리 시스템 ======= ");
				System.out.println("1. 상품 정보 추가를 선택하셨습니다.");
				System.out.println("시리얼 번호, 상품명, 가격, 수량을 입력해주세요.(공백 구분)");
				st = new StringTokenizer(br.readLine());
				String serial = st.nextToken();
				String name = st.nextToken();
				int price = Integer.parseInt(st.nextToken());
				int quantity = Integer.parseInt(st.nextToken());
				Product product = new Product();
				product.setSerial(serial);
				product.setName(name);
				product.setPrice(price);
				product.setQuantity(quantity);
				boolean flag = manager.addProduct(product);
				System.out.println(flag ? "success" : "fail");
				break;
			}
			case (2): {
				System.out.println(" ======= Electro Mart 재고 관리 시스템 ======= ");
				System.out.println("2. 상품 전체 정보 검색 ");
				List <Product> list = manager.getListAll();
				for(Product p : list) {
					System.out.println(p);
				}
				break;
			}
			case (3): {
				System.out.println(" ======= Electro Mart 재고 관리 시스템 ======= ");
				System.out.println("3. 상품명으로 검색 ");
				System.out.println("검색할 상품명을 입력하세요.");
				String name = br.readLine();
				Product product = new Product();
				product.setName(name);
				manager.selectName(product);
				if(product.getName() == null) {
					System.out.println("없는 정보입니다.");
				}else {
					System.out.println(product);
				}
				break;
			}
			case (4): {
				System.out.println(" ======= Electro Mart 재고 관리 시스템 ======= ");
				System.out.println("4. 상품 특정 가격 이하 가격 검색 ");
				System.out.println("금액을 입력하세요.");
				int price = Integer.parseInt(br.readLine());
				List <Product> list = manager.getListCheap(price);
				for(Product p : list) {
					System.out.println(p);
				}
				break;
			}
			case (5): {
				System.out.println(" ======= Electro Mart 재고 관리 시스템 ======= ");
				System.out.println("5. 제품 번호로 검색 ");
				System.out.println("검색할 시리얼 번호를 입력하세요.");
				String serial = br.readLine();
				Product product = new Product();
				product.setSerial(serial);
				manager.selectSerial(product);
				if(product.getName() == null) {
					System.out.println("없는 정보입니다.");
				}else {
					System.out.println(product);
				}
				break;
			}
			case (6): {
				System.out.println(" ======= Electro Mart 재고 관리 시스템 ======= ");
				System.out.println("6. 제품 번호로 삭제 ");
				System.out.println("삭제할 시리얼 번호를 입력하세요.");
				String serial = br.readLine();
				Product product = new Product();
				product.setSerial(serial);
				manager.deleteSerial(product);
				break;
			}
			case (7): {
				System.out.println(" ======= Electro Mart 재고 관리 시스템 ======= ");
				System.out.println("7. 제품번호로 찾아 가격 업데이트 기능 ");
				System.out.println("수정할 상품의 시리얼 번호와 수정할 가격의 값을 입력하세요(공백 구분)");
				st = new StringTokenizer(br.readLine());
				String serial = st.nextToken();
				int price = Integer.parseInt(st.nextToken());
				Product product = new Product();
				product.setSerial(serial);
				manager.modiSerial(product, price);
				break;
			}
			case (8): {
				System.out.println("종료되었습니다.");
				break loop;
			}
			}

		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		new ProductTest();
	}

}
