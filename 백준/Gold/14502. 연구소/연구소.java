/*
 * 1. 벽 세우고 bfs로 확인하면 될 것 같다.
 * 	  - 벽 세우기는 백트래킹으로, 바이러스 전파는 bfs, 안전 구역 세는거는 이중 for문
 * 2. 첫줄은 배열 크기 세로  N, 가로 M
 * 3. 둘째 줄부터는 배열
 * 4. 벽은 3개만 세울 수 있음, 0 빈칸, 1 벽, 2는 바이러스
 * 5. 안전 영역의 최대크기 return
 * */
import java.util.*;
import java.io.*;
public class Main {
	// 지도 배열
	public static int[][] map;
	// 방향 벡터
	public static int[] dx = {1, 0, -1, 0};
	public static int[] dy = {0, -1, 0, 1};
	// 안전 구역 최대 크기
	public static int max = 0;
	
	public static void main(String[] args) throws IOException{
		// 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 배열 크기 N x M
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		// 배열 입력 받기
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 바이러스 확인
		cWall(0);
		
		// 출력
		bw.write(max+"");
		bw.flush();
	}
	// 백트래킹
	public static void cWall(int cnt){
		// 벽 3개 만들었으면 바이러스 전파
		if(cnt == 3) { 
			bfs();
			return;
		}
		for(int i=0; i<map.length; i++) {
			// 벽 세웠다가 원래대로 변경
			for(int j=0; j<map[0].length; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					cWall(cnt+1);
					map[i][j] = 0;
				}
			}
		}
		
	}
	// bfs
	public static void bfs() {
		Queue<int[]> que = new LinkedList();
		// 배열 복사
		int[][] temp = new int[map.length][map[0].length];
		for(int i=0; i<map.length; i++) {
			temp[i] = map[i].clone();
		}
		// 바이러스 위치 넣기
		for(int i=0; i<temp.length; i++) {
			for(int j=0; j<temp[0].length; j++) {
				if(temp[i][j] == 2) {
					que.offer(new int[] {i,j});
				}
			}
		}
		// 바이러스 전파
		while(!que.isEmpty()) {
			int x = que.peek()[0];
			int y = que.peek()[1];
			que.poll();
			for(int i=0; i<4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				if(cx>=0 && cy >=0 && cx<temp.length && cy<temp[0].length && temp[cx][cy]==0) {
					que.offer(new int[] {cx,cy});
					temp[cx][cy] = 2;
				}
			}
		}
		// 안전 구역 확인
		int cnt=0;
		for(int i=0; i<temp.length; i++) {
			for(int j=0; j<temp[0].length; j++) {
				if(temp[i][j] == 0) {
					cnt++;
				}
			}
		}
		// 안전 구역이 큰 경우에 변수값 갱신
		if(max<cnt) {
			max = cnt;
		}
	}

}
	