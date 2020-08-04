import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_jungol1863_종교_union {
	static int[] parent;
	static int[] rank;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		parent = new int[n + 1];
		rank = new int[n + 1];

		for (int i = 0; i < m; i++) {
			String[] str_ = br.readLine().split(" ");
			int x = Integer.parseInt(str_[0]);
			int y = Integer.parseInt(str_[1]);
			union(x, y);
		}
		int cnt = 0;
		for (int i = 0; i <= n; i++) {
			if (i == parent[i]) {
				cnt++;
			}
		}
		System.out.println(cnt);
		br.close();
	}
	public static int find(int x) {
		if (x == parent[x]) {
			return x;
		}
		parent[x] = find(parent[x]);
		return parent[x];
	}
	public static void union(int x, int y) {
		int dx = find(x);
		int dy = find(y);
		if (rank[dx] < rank[dy]) {
			parent[dx] = dy;
		} else {
			parent[dy] = dx;
			if (rank[dx] == rank[dy]) {
				rank[dx]++;
			}
		}
	}
}
