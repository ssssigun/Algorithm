/*
 * 1. 얼음이 녹는 것, 조각으로 나뉘는 지 확인(bfs) 구현해야한다.
 * 2. 첫줄엔 배열의 크기 N과 M, 둘째 줄부터는 배열
 * 3. 빙산이 분리되는 최초의 시간 return
 * */
import java.util.*;
import java.io.*;
public class Main {
	// 배열
	public static int[][] map;
	// 복사배열
	public static int[][] cMap;
	// 방문 처리 배열
	public static boolean[][] visited;
	// 방향 벡터
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};
	// bfs
	public static void bfs(int x, int y) {
		Queue<int[]> que = new LinkedList();
		que.offer(new int[] {x,y});
		visited[x][y] = true;
		while(!que.isEmpty()) {
			x = que.peek()[0];
			y = que.peek()[1];
			que.poll();
			for(int i=0; i<4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				if(cx>=0 && cy>=0 && cx<map.length && cy<map[0].length && !visited[cx][cy] && map[cx][cy] != 0) {
					que.offer(new int[] {cx, cy});
					visited[cx][cy] = true;
				}
			}
		}
	}
	// 얼음 녹는 함수
	public static void melt(int x, int y) {

		for(int i=0; i<4; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];
			if(cx>=0 && cy>=0 && cx<map.length && cy<map[0].length) {
				if(map[cx][cy] == 0 && map[x][y]>0 && cMap[x][y]>0) {
					cMap[x][y] -=1;
				}
			}
		}
	}
	public static void main(String[] args) throws IOException{
		// 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 입력 받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cMap = new int[N][M];
		// 배열 입력 받기
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 얼음 녹기 진행
		for(int i=0; i<=1000; i++) {
			visited = new boolean[N][M];
			int cnt = 0;
			// 녹았는지 확인
			for(int j=0; j<N; j++) {
				for(int k=0; k<M; k++) {
					if(map[j][k] != 0 && !visited[j][k]) {
						bfs(j, k);
						cnt++;
					}
				}
			}
			// 두조각이 됬으면  시간 출력
			if(cnt >= 2) {
				bw.write(i+"");
				break;
			// 다 녹았는데 분리 되지 않았으면 0 출력
			}else if(cnt == 0) {
				bw.write("0");
				break;
			}
			// 배열 복사
			for(int j=0; j<map.length; j++) {
				cMap[j] = map[j].clone();
			}
			// 얼음 녹기 진행
			for(int j=0; j<N; j++) {
				for(int k=0; k<M; k++) {
					if(map[j][k] != 0) {
						melt(j,k);
					}
				}
			}
			// 배열 복사
			for(int j=0; j<cMap.length; j++) {
				map[j] = cMap[j].clone();
			}
		}
		bw.flush();
	}
}		