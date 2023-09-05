/*
 * 1. 정사각형 배열 안에서만 움직인다.
 * 2. 출발지는 (0,0) | 이동 방향은 오른쪽과 아래 | NxN에 도착하면 승리 (N는 경기장의 크기)
 * 3. 한번 이동할 때 현재 위치하는 칸의 수만큼 이동 가능 (수 초과, 미만 불가능)
 * 4. 첫째 줄 입력은 게임 구역의 크기 N, 두번 째 줄부터 게임판이 주어진다
 * 5. map[n][n]에 도착 가능하면 "HaruHaru" return
 * 6. dfs로 접근해야할 것 같다.
 * 	- 두 방향에 따라 접근이 가능한지 가봐야될듯
 * */
import java.util.*;
import java.io.*;
public class Main{
	//정답 문자열
	public static String answer = "Hing";
	// 게임판 배열
	public static int[][] board;
	//방문 처리 배열
	public static boolean[][] visited;
	// 방향 벡터 (오른쪽, 아래)
	public static int[] dx = {0,1};
	public static int[] dy = {1,0};
	// dfs
	public static void dfs(int x, int y) {
		int dis = board[x][y];
		visited[x][y] =true;
		// 도착지점이면 "HaruHaru" return;
		if(dis == -1) {
			answer="HaruHaru";
			return;
		}
		for(int i=0; i<2; i++) {
			int cx = x + dis * dx[i];
			int cy = y + dis * dy[i];
			if(cx>=0 && cy>=0 && cx<board.length && cy<board[0].length) {
				if(!visited[cx][cy]) {
					dfs(cx,cy);
				}
			}
		}
	}
	
    public static void main(String[] args) throws IOException{
    	// 입력
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st;
    	int N = Integer.parseInt(br.readLine());
    	//방문 배열 초기화
    	visited = new boolean[N][N];
    	// 게임판 배열 입력받기
    	board = new int[N][N];
    	for(int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0; j<N; j++) {
    			board[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	// dfs 실행
    	dfs(0,0);
    	// 출력
    	bw.write(answer);
    	bw.flush();
    } 
}