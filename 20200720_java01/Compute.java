package com.java.first;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Compute {
	public static void main(String[] args) throws IOException {
		int num_1, num_2;
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(rd.readLine());
		
		num_1 = Integer.parseInt(token.nextToken());
		num_2 = Integer.parseInt(token.nextToken());
		
		System.out.printf("곱 = %d \n", num_1 * num_2);
		System.out.printf("몫 = %d \n", num_1 / num_2);
	}
}
