/*
 * 1. 첫째 줄에 배열의 크기 N
 * 2. 색인 아닌 사람과 색약인 사람이 본 구역의 갯수 return
 * 3. 이번엔 dfs로 풀어보자
 * */
import java.util.*;
import java.io.*;
public class Main{
	// 그림 배열
	public static char[][] map;
	// 방문 처리 배열
	public static boolean[][] visited;
	// 정답 배열 [0] 일반, [1] 색약
	public static int[] answer = new int[2];
	// 방향 벡터
	public static int[] dx = {1, 0, -1, 0};
	public static int[] dy = {0, -1, 0, 1};
	// dfs 일반
	public static void dfs(int x, int y) {
		// 문자 임시 저장
		char temp = map[x][y];
		// 방문 처리
		visited[x][y] = true;
		if(temp=='G') {
			map[x][y] ='R';
		}
		// 뒤에 적록 색약인 확인해야므로 빨강 초록을 하나로 통일
		for(int i=0; i<4; i++) {
			int cx = x +dx[i];
			int cy = y +dy[i];
			if(cx>=0 && cy>=0 && cx<map.length & cy<map[0].length && (map[cx][cy] == temp) ) {
				if(!visited[cx][cy]) {
					dfs(cx,cy);
				}
			}
		}
	}
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	int cnt = 0;
    	// 배열 입력 받기
    	int N = Integer.parseInt(br.readLine());
    	map = new char[N][N];
    	visited = new boolean[N][N];
    	for(int i=0; i<N; i++) {
    		String temp = br.readLine();
    		for(int j=0; j<N; j++) {
    			map[i][j] = temp.charAt(j);
    		}
    	}
    	// 일반인 확인하기
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<N; j++) {
    			if(!visited[i][j]) {
    				dfs(i,j);
    				cnt++;
    			}
    		}
    	}
    	answer[0] = cnt;
    	// 색약인 확인하기
    	visited = new boolean[N][N];
    	cnt = 0;
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<N; j++) {
    			if(!visited[i][j]) {
    				dfs(i,j);
    				cnt++;
    			}
    		}
    	}
    	answer[1] = cnt;
    	// 결과 출력
    	bw.write(answer[0] + " " + answer[1]);
    	bw.flush();
    }
}