package com.java.first;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CheckPotin {

	public static void main(String[] args) throws IOException{
		int num_1, num_2;
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(rd.readLine());
		
		num_1 = Integer.parseInt(token.nextToken());
		num_2 = Integer.parseInt(token.nextToken());
		int tmp = (num_2+100)-num_1;
		if (tmp > 0) {
			System.out.printf("비만수치는 %d 입니다.\n", tmp);
			System.out.println("당신은 비만이군요.");
		}else {
			System.out.printf("비만수치는 %d 입니다.\n", tmp);
			System.out.println("당신은 비만이 아니군요.");
		}
	}
}