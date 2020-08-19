package com.ssafy.hw.step11;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

class JobThread extends Thread {
	private Socket client;
	JobThread(Socket client) {
		this.client = client;
	}
	public void run() {
		try (ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
				ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(client.getInputStream()));
				) {
			String data = (String)ois.readObject();
			switch (data) {
			case "open":
				try(ObjectInputStream fileObj = new ObjectInputStream(new FileInputStream("product.dat"));
						) {
					oos.writeObject(fileObj.readObject());
				} catch (Exception e) {
					System.out.println(e.getMessage());
					oos.writeObject(new ArrayList<Product>());
				}
				break;
			case "save":
				List<Product> list = (List<Product>) ois.readObject();
				list.stream().forEach(System.out::println);
				
				if (list != null) {
					new Thread(() -> {
						try (ObjectOutputStream foos = new ObjectOutputStream(new FileOutputStream("product.dat"))) {
							foos.writeObject(list);
							System.out.println("파일이 서버에 저장되었습니다.");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}).start();
				}
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
public class ProductServer {

	private void service() {
		try (ServerSocket ss = new ServerSocket(8080);) {
			System.out.println("상품 서버 구동");
			while (true) {
				Socket client = ss.accept();
				new JobThread(client).start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ProductServer().service();
	}
}
