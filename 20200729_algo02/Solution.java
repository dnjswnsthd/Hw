import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int [][] map;
		for(int t = 1; t <= tc; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int res = 0;
			map = new int[n][n];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			//셋팅 완료
			
			//파리체 크기에 따라서 횟수를 계산, 한 번 가격할때의 죽은 파리의 마리 수를 tmp에 저장하여 max값을 구해 출력
			for(int i = 0; i <= n-m; i++) {
				for(int j = 0; j <= n-m; j++) {
					int tmp = 0;
					for(int k = i; k < i + m; k++) {
						for(int l = j; l < j + m; l++) {
							tmp += map[k][l];
						}
					}
					if(res < tmp) res = tmp;
				}
			}
			System.out.print("#" + t + " " + res + "\n");
			
		}
		sc.close();
	}
}
