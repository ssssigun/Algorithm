/*
 * 1. 첫째 줄은 MxN
 * 2. 둘째 줄 부터 타일
 * 3. 세로 타일이면 같은 열 확인, 가로 타일이면 같은 행 확인하기
 * 4. dfs로 접근
 * 5. 인접한 타일의 수 return
 * */
import java.util.*;
import java.io.*;
public class Main{
	// 타일 배열
	public static char[][] tile;
	// 방향 백터
	// 세로 타일일 때 [0], 가로 타일일 때 [1]
	public static int[] dx = {1, 0};
	public static int[] dy = {0, 1};
	// dfs
	public static void dfs(int x, int y, int div) {
		// 방문 처리
		char temp = tile[x][y];
		tile[x][y] = '0';
		// 타일 종류에 따라 확인하는 방향 변경
		//위에서부터 차례대로 확인하기 때문에 위랑 왼쪽은 확인 안해도 된다.
		int cx = x +dx[div];
		int cy = y +dy[div];
		//범위 안일 때
		if(cx>=0 && cy>=0 && cx<tile.length && cy<tile[0].length) {
			// 같은 종류의 타일이면 더 탐색하기
			if(tile[cx][cy] == temp) {
				dfs(cx,cy,div);
			}
		}
	}	
	
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int cnt = 0;
    	// 첫줄 입력 받기
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	// 배열 입력 받기
    	tile = new char[N][M];
    	for(int i=0; i<N; i++) {
    		String temp = br.readLine();
    		for(int j=0; j<M; j++) {
    			tile[i][j] = temp.charAt(j);
    		}
    	}
    	// 타일이 인접해 있는지 확인하기
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<M; j++) {
    			// 가로 타일이면
    			if(tile[i][j] == '-') {
    				dfs(i,j,1);
    				cnt++;
				//세로 타일이면
    			}else if(tile[i][j] == '|') {
    				dfs(i,j,0);
    				cnt++;
				//방문 했으면 지나가기
    			}else {
    				continue;
    			}
    		}
    	}
    	// 타일 수 출력
    	bw.write(cnt+"");
    	bw.flush();
    	bw.close();
    } 
}