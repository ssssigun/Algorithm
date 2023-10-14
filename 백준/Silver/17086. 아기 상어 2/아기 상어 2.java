/*
 * 1. 상어와의 거리 최대값 구하기
 * 2. bfs로 접근
 * 3. 첫 줄엔 공간의 크기 N과 M
 * 4. 최대값 return
 * */
import java.util.*;
import java.io.*;
public class Main{
	// 최대값 저장
	public static int max = 0;
	// 공간 배열
	public static int[][] map;
	// 방문 처리 배열
	public static boolean[][] visited;
	// 방향 벡터 (8방향)
	public static int[] dx = {1, 1, 0,-1,-1,-1, 0, 1};
	public static int[] dy = {0,-1,-1,-1, 0, 1, 1, 1};
	// bfs
	public static void bfs(int x, int y, int dep) {
		Queue<int[]> que = new LinkedList();
		que.offer(new int[] {x,y,dep});
		visited[x][y] = true;
		while(!que.isEmpty()) {
			x = que.peek()[0];
			y = que.peek()[1];
			dep = que.peek()[2];
			que.poll();
			// 방향 벡터
			for(int i=0; i<dx.length; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				if(cx>=0 && cy>=0 && cx<map.length && cy<map[0].length && !visited[cx][cy]) {
					// 상어 발견시 종료
					if(map[cx][cy] == 1) {
						//최대값보다 크다면 변경
						if(dep+1 > max) {
							max = dep+1;
						}
						return;
					}
					que.offer(new int[] {cx, cy, dep+1});
					visited[cx][cy] = true;
				}
			}
		}
	}
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	// 배열 크기 입력 받기
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	map = new int[N][M];
    	// 배열 입력 받기
    	for(int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0; j<M; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	// 거리 최대값 구하기
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<M; j++) {
    			visited = new boolean[N][M];
    			if(map[i][j] == 0) {
    				bfs(i,j,0);
    			}
    		}
    	}
    	// 출력
    	bw.write(max+"");
    	bw.flush();
    }
}