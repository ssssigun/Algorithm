/*
 * 1. 큰 덩어리 찾기(많이 모여있는 덩어리의 크기를 return)
 * 2. 첫째 줄 입력은 세로 N, 가로 M, 음식물 쓰레기의 갯수 K
 * 3. 둘째 줄 부터 음식물 쓰레기의 위치
 * */
import java.io.*;
import java.util.*;
public class Main{
	// 통로 배열
	public static int[][] road;
	// 큰 덩어리 저장
	public static int max=0;
	// 방향 벡터
	public static int[] dx = {1,0,-1,0};
	public static int[] dy = {0,-1,0,1};
	// bfs
	public static void bfs(int x, int y) {
		Queue<int[]> que = new LinkedList();
		int cnt = 0;
		// 초기값
		que.offer(new int[] {x,y});
		road[x][y] = 2;
		// 큐가 빌 때까지 반복
		while(!que.isEmpty()) {
			cnt++;
			x = que.peek()[0];
			y = que.peek()[1];
			que.poll();
			// 인접해 있는 지 확인
			for(int i=0; i<4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				// 배열 범위 안에서 
				if(cx>=0 && cy>=0 && cx<road.length && cy<road[0].length) {
					// 음식물 쓰레기면 갯수 세기
					if(road[cx][cy]==1) {
						que.offer(new int[] {cx,cy});
						road[cx][cy] = 2;
					}
				}
			}
		}
		// 큰 덩어리 저장
		if(max<cnt) {
			max = cnt;
		}
	}
	
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	// 세로, 가로, 음식물 수 입력받기
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	// 배열 입력 받기
    	road = new int[N][M];
    	for(int i=0; i<K; i++) {
    		st = new StringTokenizer(br.readLine());
    		int x = Integer.parseInt(st.nextToken())-1;
    		int y = Integer.parseInt(st.nextToken())-1;
    		road[x][y] = 1;
    	}
    	// 덩어리 찾기
    	for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(road[i][j]==1) {
					bfs(i,j);
				}
			}
		}
    	// 큰 덩어리 출력
    	bw.write(max+"");
    	bw.flush();
    	bw.close();
    	br.close();
    }
}