package com.ssafy.java.day11.hw;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

class SendThread extends Thread {
	private ArrayList<Product> datas;
	
	SendThread(ArrayList<Product> datas) {
		this.datas = datas;
	}
	public void run() {
		try (Socket ser = new Socket("localhost", 9999);
				ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(ser.getOutputStream()));) {
			ArrayList<Product> list = new ArrayList<Product>();

			for (Product p : datas) {
				if (p instanceof TV) {
					list.add(p);
				}
			}
			for (Product p : datas) {
				if (p instanceof Refrigerator) {
					list.add(p);
				}
			}
			oos.writeObject("save");
			oos.writeObject(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
public class ProductMgrImpl extends Thread implements ProductMgr {
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
		for (Product pt : al) {
			if (pt.getSerial().equals(p.getSerial())) {
				chk = true;
			}
		}
		if (chk)
			throw new DuplicateException("이미 존재하는 제품이라 등록할 수 없습니다. (DuplicateException 발생)");
		else
			al.add(p);
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

	public void findBigTV() throws ProductNotFoundException {
		boolean chk = false;
		for (Product p : al) {
			if (p instanceof TV && ((TV) p).getInch() >= 50) {
				System.out.println(p);
				chk = true;
			}
		}
		if (!chk)
			throw new ProductNotFoundException("50Inch이상의 TV를 찾지 못했습니다. (ProductNotFoundException 발생)");
	}

	public void findBigRefrigerator() throws ProductNotFoundException {
		boolean chk = false;
		for (Product p : al) {
			if (p instanceof Refrigerator && ((Refrigerator) p).getSize() >= 400) {
				System.out.println(p);
				chk = true;
			}
		}
		if (!chk)
			throw new ProductNotFoundException("400L이상의 냉장고를 찾지 못했습니다. (ProductNotFoundException 발생)");
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

	public void sell(String s, int quantity) throws QuantityException, SerialNotFoundException {
		boolean chk = false;
		for (int i = 0; i < al.size(); i++) {
			if (al.get(i).getSerial().equals(s)) {
				if (al.get(i).getCount() - quantity < 0)
					throw new QuantityException("판매 수량이 재고를 초과했습니다. (QuantityException 발생)");
				al.get(i).setCount(al.get(i).getCount() - quantity);
				chk = true;
			}
		}
		if (!chk)
			throw new SerialNotFoundException("재고 목록에 존재하지 않은 Serial 번호가 입력되었습니다. (SerialNotFoundException 발생)");
	}

	public void buy(String s, int quantity) throws SerialNotFoundException {
		boolean chk = false;
		for (int i = 0; i < al.size(); i++) {
			if (al.get(i).getSerial().equals(s)) {
				al.get(i).setCount(al.get(i).getCount() + quantity);
				chk = true;
			}
		}
		if (!chk)
			throw new SerialNotFoundException("재고 목록에 존재하지 않은 Serial 번호가 입력되었습니다. (SerialNotFoundException 발생)");
	}

	public long calcAllPrice() {
		long sum = 0;
		for (Product p : al) {
			sum += p.getPrice();
		}
		return sum;
	}
	
	public void save() throws FileNotFoundException, IOException {
		try {
			FileWriter fw = new FileWriter("C:\\SSAFY\\java_work\\hwjava11_2반_송원준\\src\\com\\ssafy\\java\\day11\\hw\\product2.dat");
			BufferedWriter bw = new BufferedWriter(fw);
			for (Product p : al) {
				if (p instanceof TV) {
					try {
						bw.write(p.toString());
						bw.newLine();
					} catch (IOException e) {
					}
				}
			}
			for (Product p : al) {
				if (p instanceof Refrigerator) {
					try {
						bw.write(p.toString());
						bw.newLine();
					} catch (IOException e) {
					}
				}
			}
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace(); 
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void read() throws FileNotFoundException, IOException {
		try {
			FileReader fr = new FileReader("C:\\SSAFY\\java_work\\hwjava11_2반_송원준\\src\\com\\ssafy\\java\\day11\\hw\\product2.dat");
			BufferedReader br = new BufferedReader(fr);
			int readCharNo;
			char[] cbuf = new char[100];
			while ((readCharNo = br.read(cbuf)) != -1) {
				String str = new String(cbuf, 0, readCharNo);
				System.out.print(str);
			}
			System.out.println();
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	public void open() {
		try (Socket ser = new Socket("localhost", 8080);
				ObjectOutputStream oos = new ObjectOutputStream(ser.getOutputStream());
				ObjectInputStream ois = new ObjectInputStream(ser.getInputStream());) {
			oos.writeObject("open");
			al = (ArrayList<Product>) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void close() {
		sendDataToServer();
	}
	public void sendDataToServer() {
		SendThread st = new SendThread(al);
		st.start();
	}
}
