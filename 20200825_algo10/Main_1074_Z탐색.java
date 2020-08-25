import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//분할정복 문제 굳이 배열을 만들필요가 없다.(배열만들어서 하면 메모리 부족 에러 발생)
//2^15이기 때문에 단순 재귀로 풀면 시간 초과가 뜰 수 있다.
//따라서 분할정복으로 풀게 되었다.
public class Main_1074_Z탐색 {
    public static int r;//row
    public static int c;//col
    //z탐색을 위한 dx, dy
    public static int [] dx = {0, 1, 0, 1};
    public static int [] dy = {0, 0, 1, 1};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2, n);
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        sol(0, 0, 0, size);
    }
    //배열 크기를 최소 사이즈인 2가될떄까지 4등분하면서 입력받은 좌표가 범위 안에 있는 것들만 계산한다.
    public static void sol(int x, int y, int cnt, int size) {
//      범위 체크  
        if(x > c || x+size <= c || y > r || y+size <= r) return;
        if(size == 2) { 
            for(int i=0; i < 4; i++) {
            	int nx = dx[i] + x;
                int ny = dy[i] + y;
                if(nx == c && ny == r) System.out.println(cnt + i);
            }
            return;
        }  
        int size_tmp = size/2;        
        sol(x, y, cnt, size_tmp);        
        sol(x+size_tmp, y, cnt + (size_tmp * size_tmp), size_tmp);
        sol(x, y + size_tmp, cnt + (size_tmp * size_tmp*2), size_tmp);
        sol(x + size_tmp, y + size_tmp, cnt + (size_tmp * size_tmp*3), size_tmp);
    }
}
