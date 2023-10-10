/*
 * 1. 안전 영역을 찾을때는 dfs로 확인
 * 2. 물이 점점 잠기도록 진행 1~100 사이
 * 3. 첫재줄은 배열의 크기 NxN
 * 4. 물에 잠기지 않는 안전한 영역의 최대 개수를 출력
 * */
import java.util.*;
import java.io.*;
public class Main {
	// 배열
	public static int[][] map;
	// 방문 배열
	public static boolean[][] visited;
	// 방향벡터
	public static int[]	dx = {1, 0, -1, 0};
	public static int[]	dy = {0, -1, 0, 1};
	// dfs
	public static void dfs(int x, int y) {
		// 방문처리
		visited[x][y] = true;
		for(int i=0; i<4; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];
			if(cx>=0 && cy>=0 && cx<map.length && cy<map[0].length && !visited[cx][cy]) {
				dfs(cx,cy);
			}
		}
	}
	public static void main(String[] args) throws IOException{
		// 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int max = 0;
		int cnt = 0;
		int result = 0;
		// 입력 받기
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 큰값 담아두기
				if(max < map[i][j]) {
					max = map[i][j];
				}
			}
		}
		// 물 높이 진행
		for(int i=0; i<max; i++) {
			visited= new boolean[N][N];
			cnt = 0;
			// 물높이보다 낮은 것은 제외
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					if(map[j][k]<=i) {
						visited[j][k] = true;
					}
				}
			}
			// 안전 구역 확인하기
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					if(!visited[j][k]) {
						dfs(j,k);
						cnt++;
					}
				}
			}
			// 안전 구역이 최대값인지 확인
			if(result < cnt) {
				result = cnt;
			}
		}
		// 출력
		bw.write(result+"");
		bw.flush();
	}
}