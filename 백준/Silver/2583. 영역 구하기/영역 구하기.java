/*
 * 1. M x N 모눈 종이에 K개의 직사각형이 주어진다
 * 2. 빈칸의 갯수와 빈칸의 크기를 오름차순으로 return 
 * 3. 첫줄 입력은 M, N, K
 * 4. 둘재 줄부터 k개 입력은 (왼쪽 아래 꼭짓점), (오른쪽 위 꼭짓점) 으로 주어진다
 * 5. dfs로 풀어보자
 * */
import java.util.*;
import java.io.*;
public class Main{
	// 모눈 종이 배열 겸 방문 처리 배열
	public static boolean[][] map;
	// 방향 벡터
	public static int[] dx = {1, 0, -1, 0};
	public static int[] dy = {0, -1, 0, 1};
	// 빈칸의 갯수 세는 변수
	public static int area = 0;
	// dfs
	public static void dfs(int x, int y) {
		map[x][y] = true;
		area++;
		for(int i=0; i<4; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];
			if(cx>=0 && cy>=0 && cx<map.length && cy< map[0].length) {
				if(!map[cx][cy]) {
					dfs(cx,cy);
				}
			}
		}
	}
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	// 정답 배열
    	List<Integer> answer = new ArrayList();
    	// 빈칸 갯수
    	int cnt = 0;
    	// 입력 받기
    	int M = Integer.parseInt(st.nextToken());
    	int N = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	// 배열 크기 선언
    	map = new boolean[M][N];
    	// 직사각형 위치는 true로 변환
    	for(int i=0; i<K; i++) {
    		// 입력 받기
    		st = new StringTokenizer(br.readLine());
    		int lx =Integer.parseInt(st.nextToken());
    		int ly =Integer.parseInt(st.nextToken());
    		int rx =Integer.parseInt(st.nextToken());
    		int ry =Integer.parseInt(st.nextToken());
    		for(int j=lx; j<rx; j++) {
    			for(int k=ly; k<ry; k++) {
    				map[k][j] = true;
    			}
    		}
    	
    	}
    	//전체 돌면서 dfs로 빈칸 갯수와 크기 탐색
    	for(int i=0; i<map.length; i++) {
    		for(int j=0; j<map[0].length; j++) {
    			if(!map[i][j]) {
    				dfs(i, j);
    				answer.add(area);
    				cnt++;
    				area = 0;
    			}
    		}
    	}
    	// 오름차순 정렬
    	Collections.sort(answer);
    	// 출력
    	bw.write(cnt+"\n");
    	for(int i=0; i<answer.size(); i++) {
    		bw.write(answer.get(i)+" ");
    	}
    	bw.flush();
    }
}