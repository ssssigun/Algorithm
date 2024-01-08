/*
 * 1. 단순 dfs 문제
 * 2. 첫째줄엔 캠퍼스 크기를 나타내는 N과 M
 * 	- o 빈공간, x 벽, I 도연, P 사람
 * 3. 도연이가 만나는 사람으 ㅣ수를 return
 * 	- 단 아무도 못 만났으면 TT return
*/
import java.io.*;
import java.util.*;
public class Main{
	public static char[][] map; // 캠퍼스 배열
	// 방향 벡터
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};	
	public static int cnt = 0; // 사람을 마주친 횟수
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken()); // N 세로
    	int M = Integer.parseInt(st.nextToken()); // M 가로
    	int[] I = new int[2]; // 시작점 (도연의 위치)
    	map = new char[N][M];
    	// 맵 입력 받기
    	for(int i=0; i<N; i++) {
			String temp = br.readLine();
    		for(int j=0; j<M; j++) {
    			char t = temp.charAt(j);
    			if(t == 'I') {
    				I = new int[] {i,j};
    			}
				map[i][j] = t;
    		}
    	}
    	// dfs 실행
    	dfs(I[0], I[1]);
    	// 출력
    	if(cnt == 0) {
    		bw.write("TT");
    	}else {
    		bw.write(cnt+"");
    	}
    	bw.flush();
    }
    // dfs
    public static void dfs(int cx, int cy) {
    	for(int i=0; i<4; i++) {
    		int x = cx + dx[i];
    		int y = cy + dy[i];
    		if(x>=0 && x<map.length && y>=0 && y<map[0].length && map[x][y] != 'X') {
    			if(map[x][y] == 'P') {
    				cnt++;
    			}
				map[x][y] = 'X';
				dfs(x,y);
    		}
    	}
    }
}