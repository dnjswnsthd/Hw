import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
//완탐 X 백트레킹 사용
//입력받은 배열의 가중치가 0인 경우, 가중치가 0이 아닌 경로가 없는 것
public class Main_Jungol_1681_해밀턴_순환회로 {
	private static int arr[][];
	private static int num,result;
	private static boolean visited[];
	private static List <Integer> list;
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine().trim());
		arr = new int[num+1][num+1];
		visited = new boolean[num+1];
		list = new ArrayList<Integer>();
		result = Integer.MAX_VALUE;
		for(int i=1;i<=num;i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			for(int j=1;j<=num;j++) 
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		visited[1]=true;
		sol(0,1);
		System.out.println(result);
	}
	
	static void sol(int sum, int now) {
		for(int i=1;i<=num;i++) {
			if(visited[i] || arr[now][i]==0) continue;
			visited[i]=true;			
			sol(sum+arr[now][i],i);
			visited[i]=false;
		}
		boolean finish=true;
		for(int i=1;i<=num;i++)
			if(!visited[i]) {
				finish=false;
				break;
			}
		if(finish && arr[now][1]!=0) 
			result = Math.min(result, sum+arr[now][1]);
	}
}
