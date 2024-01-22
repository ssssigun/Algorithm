/*
 * 1. dfs로 완전 탐색해야할 것 같다.
 * 2. 첫째 줄은 5x5 사이즈
 * 3. 만들 수 있는 수의 개수를 출력
 * */
import java.io.*;
import java.util.*;
public class Main {
	public static int[][] filed = new int[5][5]; // 숫자판
	public static Set<String> set= new HashSet(); // 조합 가능한 수 저장
	// 방향 벡터
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException{
		// 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String str = "";
		// 입력 받기
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				filed[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 숫자 조합하기
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				dfs(i, j, 0, str);
			}
		}
		// 출력
		bw.write(set.size()+"");
		bw.flush();
	}
	// dfs
	public static void dfs(int x,int y, int depth, String s) {
		if(depth == 6) {
			set.add(s);
			return;
		}else {
			for(int i=0; i<4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				if(cx>=0 && cy>=0 && cx<5 && cy<5) {
					dfs(cx, cy, depth+1,s+filed[cx][cy]);
				}
			}
		}
	}
}