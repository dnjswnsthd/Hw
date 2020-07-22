package com.ssafy.algo;
import java.util.Scanner;

public class DigitTest1 {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int [] list = new int[100];
		int size = 0;
		while(true) {
			int num = sc.nextInt();
			if(num == 0) { break;}
			list[size] = num;					
			size += 1;
		}
		int [] res = new int[10];
		for(int i = 0; i < size; i++) {
			res[list[i] / 10]++;
		}
		for(int j = 0; j < 10; j++) {
			if (res[j] != 0) {
				System.out.printf("%d : %d개 \n", j, res[j]);
			}
		}
		sc.close();
	}
}
