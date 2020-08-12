package com.ssafy.java.day07.hw;

import java.util.ArrayList;

public class ProductMgrImpl implements ProductMgr{
	private ArrayList<Product> al;
	public ProductMgrImpl(ArrayList<Product> al) {
		this.al = al;
	}
	public ArrayList<Product> getAl() {
		return al;
	}
	public void setAl(ArrayList<Product> al) {
		this.al = al;
	}
	public void add(Product p) throws DuplicateException {
		boolean chk = false;
		for(Product pt : al) {
			if(pt.getSerial().equals(p.getSerial())) {
				chk = true;
			}
		}
		if(chk) throw new DuplicateException("이미 존재하는 제품이라 등록할 수 없습니다. (DuplicateException 발생)");
		else al.add(p);
	}
	public void printAll() {
		for (Product p : al)
			System.out.println(p);
	}
	public void findName(String s) {
		for (Product p : al) {
			if (p.getName().indexOf(s) != -1) {
				System.out.println(p);
			}
		}
	}
	public void findSerial(String s) {
		for (Product p : al) {
			if (p.getSerial().equals(s)) {
				System.out.println(p);
				return;
			}
		}
	}
	public void findTV() {
		for (Product p : al) {
			if (p instanceof TV) {
				System.out.println(p);
			}
		}
	}

	public void findRefrigerator() {
		for (Product p : al) {
			if (p instanceof Refrigerator) {
				System.out.println(p);
			}
		}
	}
	
	public void findBigTV() throws ProductNotFoundException{
		boolean chk = false;
		for (Product p : al) {
			if (p instanceof TV && ((TV) p).getInch() >= 50) {
				System.out.println(p);
				chk = true;
			}
		}
		if(!chk) throw new ProductNotFoundException("50Inch이상의 TV를 찾지 못했습니다. (ProductNotFoundException 발생)");
	}

	public void findBigRefrigerator() throws ProductNotFoundException{
		boolean chk = false;
		for (Product p : al) {
			if (p instanceof Refrigerator && ((Refrigerator) p).getSize() >= 400) {
				System.out.println(p);
				chk = true;
			}
		}
		if(!chk) throw new ProductNotFoundException("400L이상의 냉장고를 찾지 못했습니다. (ProductNotFoundException 발생)");
	}

	public void modifyPrice(String s, int price) {
		for (Product p : al) {
			if (p.getSerial().equals(s)) {
				p.setPrice(price);
			}
		}
	}

	public void deleteWithSerial(String s) {
		for (int i = 0; i < al.size(); i++) {
			if (al.get(i).getSerial().equals(s)) {
				System.out.println(al.get(i));
				al.remove(i);
				break;
			}
		}
	}
	public void sell(String s, int quantity) throws QuantityException, SerialNotFoundException{
		boolean chk = false;
		for (int i = 0; i < al.size(); i++) {
			if(al.get(i).getSerial().equals(s)) {
				if(al.get(i).getCount()-quantity < 0) throw new QuantityException("판매 수량이 재고를 초과했습니다. (QuantityException 발생)");
				al.get(i).setCount(al.get(i).getCount()-quantity);
				chk = true;
			}
		}
		if(!chk) throw new SerialNotFoundException("재고 목록에 존재하지 않은 Serial 번호가 입력되었습니다. (SerialNotFoundException 발생)");
	}
	public void buy(String s, int quantity) throws SerialNotFoundException {
		boolean chk = false;
		for (int i = 0; i < al.size(); i++) {
			if(al.get(i).getSerial().equals(s)) {
				al.get(i).setCount(al.get(i).getCount()+quantity);
				chk = true;
			}
		}
		if(!chk) throw new SerialNotFoundException("재고 목록에 존재하지 않은 Serial 번호가 입력되었습니다. (SerialNotFoundException 발생)");
	}

	public long calcAllPrice() {
		long sum = 0;
		for (Product p : al) {
			sum += p.getPrice();
		}
		return sum;
	}
}
