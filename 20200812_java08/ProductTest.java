package com.ssafy.java.day07.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import com.ssafy.java.day07.hw.QuantityException;
import com.ssafy.java.day07.hw.SerialNotFoundException;
import com.ssafy.java.day07.hw.DuplicateException;
import com.ssafy.java.day07.hw.ProductNotFoundException;

public class ProductTest {
	public static void main(String[] args) throws IOException {
		ProductMgr mgr = new ProductMgrImpl(new ArrayList<Product>());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		mgr.getAl().add(new TV("01-01", "삼성_tv", 1324000, 7, 60, "FHD"));
		mgr.getAl().add(new TV("02-02", "삼성_tv4", 1324000, 7, 30, "FHD"));
//		mgr.getAl().add(new TV("03-03", "삼성_tv5", 1324000, 7, 70, "FHD"));
//		mgr.getAl().add(new Refrigerator("04-04", "삼성_ref", 164300, 100, 750));
		mgr.getAl().add(new Refrigerator("05-05", "삼성_ref", 164300, 100, 300));
//		mgr.getAl().add(new Refrigerator("06-06", "삼성_ref", 164300, 100, 500));
		loop:while(true) {
			System.out.println(" ======= Electro Mart 재고 관리 시스템 ======= ");
			System.out.println("1. TV 추가 ");
			System.out.println("2. 냉장고 추가 ");
			System.out.println("3. 상품 모두 출력 ");
			System.out.println("4. 상품 시리얼 번호로 검색 ");
			System.out.println("5. 상품 이름으로 검색 ");
			System.out.println("6. TV 모두 검색 ");
			System.out.println("7. 냉장고 모두 검색 ");
			System.out.println("8. 50Inch 이상 크기의 TV 검색 ");
			System.out.println("9. 400L 이상 크기의 냉장고 모두 검색 ");
			System.out.println("10. 상품 시리얼 번호로 상품 가격 변경 ");
			System.out.println("11. 상품 시리얼 번호로 삭제 ");
			System.out.println("12. 재고 상품 가격총합 검색 ");
			System.out.println("13. 상품 판매 ");
			System.out.println("14. 재고 구매 ");
			System.out.println("15. 종료 ");
			
			System.out.println("원하는 작업의 번호를 입력해주세요");
			int num = Integer.parseInt(br.readLine());
			
			System.out.println();
			switch(num) {
			case(1) : {
				System.out.println(" ======= Electro Mart 재고 관리 시스템 ======= ");
				System.out.println("1. TV 추가를 선택하셨습니다. 시리얼 번호, 상품명, 가격 ");
				System.out.println(",수량,  크기(Inch), 패널순으로 입력해주세요.(공백 구분)");
				st = new StringTokenizer(br.readLine());
				try {
					mgr.add(new TV(st.nextToken(), st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), st.nextToken()));
					System.out.println("추가 되었습니다.");
				}catch(DuplicateException e) {
					System.err.println(e.getMessage());
					System.err.println("!!!!!!!!!!!!!!!!!!!DuplicateException!!!!!!!!!!!!!!!!!!!");
					System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!경고!!!!!!!!!!!!!!!!!!!!!!!!!!");
				}
				break;
			}
			case(2) :{
				System.out.println(" ======= Electro Mart 재고 관리 시스템 ======= ");
				System.out.println("2. 냉장고 추가를 선택하셨습니다. 시리얼 번호, 상품명 ");
				System.out.println(", 가격, 수량, 용량(L) 순으로 입력해주세요.(공백 구분)");
				st = new StringTokenizer(br.readLine());
				try {
					mgr.add(new Refrigerator(st.nextToken(), st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
					System.out.println("추가 되었습니다.");
				}catch(DuplicateException e) {
					System.err.println(e.getMessage());
					System.err.println("!!!!!!!!!!!!!!!!!!!DuplicateException!!!!!!!!!!!!!!!!!!!");
					System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!경고!!!!!!!!!!!!!!!!!!!!!!!!!!");
				}
				break;
			}
			case(3) :{
				System.out.println(" ======= Electro Mart 재고 관리 시스템 ======= ");
				System.out.println("3. 상품 모두 출력을 선택하셨습니다.");
				System.out.println("모든 상품을 출력한 결과 입니다.");
				mgr.printAll();
				break;
			}
			case(4) :{
				System.out.println(" ======= Electro Mart 재고 관리 시스템 ======= ");
				System.out.println("4. 상품 시리얼 번호로 검색을 선택하셨습니다.");
				System.out.println("검색하고자 하는 상품 시리얼 번호를 입력하세요.");
				st = new StringTokenizer(br.readLine());
				System.out.println("검색한 상품을 출력합니다.");
				mgr.findSerial(st.nextToken());
				break;
			}
			case(5) :{
				System.out.println(" ======= Electro Mart 재고 관리 시스템 ======= ");
				System.out.println("5. 상품 이름으로 검색을 선택하셨습니다.");
				System.out.println("검색하고자 하는 상품 이름을 입력하세요.");
				st = new StringTokenizer(br.readLine());
				System.out.println("검색한 상품을 출력합니다.");
				mgr.findName(st.nextToken());
				break;
			}
			case(6) :{
				System.out.println(" ======= Electro Mart 재고 관리 시스템 ======= ");
				System.out.println("6. TV를 모두 검색한 결과입니다.");
				mgr.findTV();
				break;
			}
			case(7) :{
				System.out.println(" ======= Electro Mart 재고 관리 시스템 ======= ");
				System.out.println("7. 냉장고를 모두 검색한 결과입니다.");
				mgr.findRefrigerator();
				break;
			}
			case(8) :{
				System.out.println(" ======= Electro Mart 재고 관리 시스템 ======= ");
				System.out.println("8. 50Inch 이상 크기의 TV를 검색한 결과입니다.");
				try {
					mgr.findBigTV();
				}
				catch(ProductNotFoundException e) {
					System.err.println(e.getMessage());
					System.err.println("!!!!!!!!!!!!!!!!ProductNotFoundException!!!!!!!!!!!!!!!!");
					System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!경고!!!!!!!!!!!!!!!!!!!!!!!!!!");
					System.err.println();System.err.println();
				}
				break;
			}
			case(9) :{
				System.out.println(" ======= Electro Mart 재고 관리 시스템 ======= ");
				System.out.println("9. 400L 이상 크기의 냉장고를 검색한 결과입니다.");
				try {
					mgr.findBigRefrigerator();
				}
				catch(ProductNotFoundException e) {
					System.err.println(e.getMessage());
					System.err.println("!!!!!!!!!!!!!!!!ProductNotFoundException!!!!!!!!!!!!!!!!");
					System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!경고!!!!!!!!!!!!!!!!!!!!!!!!!!");
				}
				break;
			}
			case(10) :{
				System.out.println(" ======= Electro Mart 재고 관리 시스템 ======= ");
				System.out.println("10. 상품 시리얼 번호로 상품 가격 변경을 선택하셨습니다. ");
				System.out.println("가격 변경을 원하는 상품의 시리얼 번호와 가격을 입력하세요.(공백 구분)");
				st = new StringTokenizer(br.readLine());
				mgr.modifyPrice(st.nextToken(), Integer.parseInt(st.nextToken()));
				break;
			}
			case(11) :{
				System.out.println(" ======= Electro Mart 재고 관리 시스템 ======= ");
				System.out.println("11. 상품 시리얼 번호로 삭제를 선택하셨습니다.");
				System.out.println("삭제를 원하는 상품의 시리얼 번호를 입력해주세요.");
				mgr.deleteWithSerial(br.readLine());
				break;
			}
			case(12) :{
				System.out.println(" ======= Electro Mart 재고 관리 시스템 ======= ");
				System.out.println("12. 재고 상품 가격총합 검색 결과입니다. ");
				System.out.println(mgr.calcAllPrice());
				break;
			}
			case(13) :{
				System.out.println(" ======= Electro Mart 재고 관리 시스템 ======= ");
				System.out.println("13.판매된 상품의 시리얼 번호와 수량을 입력하세요 (공백 구분)");
				st = new StringTokenizer(br.readLine());
				try {
					mgr.sell(st.nextToken(), Integer.parseInt(st.nextToken()));
				}catch(QuantityException e) {
					System.err.println(e.getMessage());
					System.err.println("!!!!!!!!!!!!!!!!!QuantityExceptionError!!!!!!!!!!!!!!!!!");
					System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!경고!!!!!!!!!!!!!!!!!!!!!!!!!!");

				}catch(SerialNotFoundException e) {
					System.err.println(e.getMessage());
					System.err.println("!!!!!!!!!!!!!!SerialNotFoundExceptionError!!!!!!!!!!!!!!");
					System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!경고!!!!!!!!!!!!!!!!!!!!!!!!!!");
				}
				break;
			}
			case(14) :{
				System.out.println(" ======= Electro Mart 재고 관리 시스템 ======= ");
				System.out.println("14.재고가 구매된 상품의 시리얼 번호와 수량을 입력하세요 (공백 구분)");
				st = new StringTokenizer(br.readLine());
				try {
					mgr.buy(st.nextToken(), Integer.parseInt(st.nextToken()));
				}catch(SerialNotFoundException e) {
					System.err.println(e.getMessage());
					System.err.println("!!!!!!!!!!!!!!!!!QuantityExceptionError!!!!!!!!!!!!!!!!!");
					System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!경고!!!!!!!!!!!!!!!!!!!!!!!!!!");
				}
				break;
			}
			case(15) :{
				System.out.println(" ======= Electro Mart 재고 관리 시스템 ======= ");
				System.out.println("종료합니다.");
				break loop;
			}
			}
			System.out.println();
		}
	}
}

