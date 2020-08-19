package com.ssafy.hw.step11;

import java.io.BufferedOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

class SendThread extends Thread {
	private List<Product> datas;
	
	SendThread(List<Product> datas) {
		this.datas = datas;
	}
	public void run() {
		try (Socket ser = new Socket("localhost", 9999);
				ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(ser.getOutputStream()));) {
			List<Product> list = new ArrayList<Product>();

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

public class ProductMgrImpl implements IProductMgr {

	private List<Product> dataList = new ArrayList<>();
	private static ProductMgrImpl instance;

	private ProductMgrImpl() {
		open();
	}
	
	public static ProductMgrImpl getInstance() {
		if (instance == null) {
			instance = new ProductMgrImpl();
		}
		return instance;
	}

	@Override
	public void add(Product p) throws DuplicateException {
		for (Product check : dataList) {
			if (check.getNum().equals(p.getNum())) {
				throw new DuplicateException();
			}
		}
		dataList.add(p);
	}

	@Override
	public List<Product> selectProductList() {
		return dataList;
	}

	@Override
	public Product selectProductByNum(String num) throws ProductNotFoundException {
		for (Product p : dataList) {
			if (p.getNum().equals(num)) return p;
		}
		throw new ProductNotFoundException();
	}

	@Override
	public List<Product> selectProductsByName(String name) {
		List<Product> result = new ArrayList<Product>();
		for (Product p : dataList) {
			if (p.getName().contains(name))
				result.add(p);
		}
		return result;
	}

	@Override
	public List<Product> selectTvList() {
		List<Product> tvList = new ArrayList<Product>();
		for (Product p : dataList) {
			if (p instanceof TV) {
				tvList.add(p);
			}
		}
		return tvList;
	}

	@Override
	public List<Product> selectRefrigeratorList() {
		ArrayList<Product> result = new ArrayList<Product>();
		for (Product p : dataList) {
			if (p instanceof Refrigerator) {
				result.add(p);
			}
		}
		return result;
	}

	@Override
	public void deleteProduct(String num) {
		for (Product p : dataList) {
			if (p.getNum().equals(num)) {
				dataList.remove(p);
				return;
			}
		}
	}

	@Override
	public void open() {
		try (Socket ser = new Socket("localhost", 9999);
				ObjectOutputStream oos = new ObjectOutputStream(ser.getOutputStream());
				ObjectInputStream ois = new ObjectInputStream(ser.getInputStream());) {
			oos.writeObject("open");
			dataList = (List<Product>) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void close() {
		sendDataToServer();
	}

	@Override
	public List<Product> selectRefr400() throws ProductNotFoundException {
		List<Product> list = new ArrayList<Product>();
		for (int i = 0; i < dataList.size(); i++) {
			if (dataList.get(i) instanceof Refrigerator) {
				Refrigerator r = (Refrigerator) dataList.get(i);
				if (r.getLiter() >= 400) {
					list.add(dataList.get(i));
				}
			}
		}
		if (list.isEmpty()) {
			throw new ProductNotFoundException();
		}
		return list;
	}

	@Override
	public List<Product> selectTV50() throws ProductNotFoundException {
		List<Product> list = new ArrayList<Product>();
		for (int i = 0; i < dataList.size(); i++) {
			if (dataList.get(i) instanceof TV) {
				TV tv = (TV) dataList.get(i);
				if (tv.getInch() >= 50) {
					list.add(dataList.get(i));
				}
			}
		}
		if (list.isEmpty()) {
			throw new ProductNotFoundException();
		}
		return list;
	}

	@Override
	public List<Product> selectProductsByNamePrice(String name, int price) {
		List<Product> list = new ArrayList<Product>();
		for (int i = 0; i < dataList.size(); i++) {
			if (dataList.get(i).getName().contains(name) && dataList.get(i).getPrice() <= price) {
				list.add(dataList.get(i));
			}
		}
		return list;
	}

	@Override
	public int totalSum() {
		int sum = 0;
		for (int i = 0; i < dataList.size(); i++) {
			sum += dataList.get(i).getAmount() * dataList.get(i).getPrice();
		}
		return sum;
	}

	@Override
	public void updateProduct(String num, int price) {
		for (int i = 0; i < dataList.size(); i++) {
			if (dataList.get(i).getNum().equals(num)) {
				dataList.get(i).setPrice(price);
				return;
			}
		}
	}

	@Override
	public void sendDataToServer() {
		SendThread st = new SendThread(dataList);
		st.start();
	}
}
