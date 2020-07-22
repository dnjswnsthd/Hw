package com.ssafy.hw.step03;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			int sogum = Integer.parseInt(st.nextToken());
			int[][] pond = new int[size][size];
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					pond[i][j] = -1;
				}
			}
			int[][] move = new int[sogum][3];
			for (int i = 0; i < sogum; i++) {
				st = new StringTokenizer(br.readLine());
				move[i][0] = Integer.parseInt(st.nextToken());
				move[i][1] = Integer.parseInt(st.nextToken());
				move[i][2] = Integer.parseInt(st.nextToken()) - 1;
				pond[move[i][0]][move[i][1]] = i;
			}
			loop:for (int i = 0; i < sogum; i++) {
				for (int j = 3; j > 0; j--) {
					int[] tmp = move[i];
					int nx = tmp[0] + dx[tmp[2]] * j;
					int ny = tmp[1] + dy[tmp[2]] * j;
					if (nx < 0 || size <= nx || ny < 0 || size <= ny) {
						pond[tmp[0]][tmp[1]] = -1;
						continue loop;
					}
					if (pond[nx][ny] != -1) {
						pond[tmp[0]][tmp[1]] = -1;
						continue loop;
					} else {
						pond[tmp[0]][tmp[1]] = -1;
						pond[nx][ny] = i;
						tmp[0] = nx;
						tmp[1] = ny;
					}
				}
			}
			int sogum_n = 0;
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if(pond[i][j] != -1) {
						sogum_n++;
					}
				}
			}
			System.out.printf("#%d %d\n", t, sogum_n);
		}
		br.close();
	}
}
