/*
 * 1. 보물 사이의 최단거리 구하기
 * 	- 보물은 최단 거리로 이동했을 때 가장 긴시간이 걸리는 곳에 묻혀있다.
 * 	- bfs로 여러번 돌렸을 때 최단 거리가 큰 값을 return하면 될 것 같다.
 * 2. 첫 줄은 세로와 가로의 값
 * 3. 둘째 줄 부터 맵 배열
 * */
import java.util.*;
import java.io.*;
public class Main{
	// 섬 배열
	public static boolean[][] map;
	// 방문 처리 겸 최단 거리 배열
	public static int[][] visited;
	// 방향 벡터
	public static int[] dx = {1, 0, -1, 0};
	public static int[] dy = {0, -1, 0, 1};
	// 최단 거리 중 가장 값이 큰 값
	public static int answer = 0;
	// bfs
	public static void bfs(int x, int y) {
		Queue<int[]> que = new LinkedList();
		que.offer(new int[] {x,y});
		visited[x][y] = 1;
		while(!que.isEmpty()) {
			x = que.peek()[0];
			y = que.peek()[1];
			que.poll();
			for(int i=0; i<4; i++) {
				int cx = x +dx[i];
				int cy = y +dy[i];
				if(cx>=0 && cy>=0 && cx<map.length && cy<map[0].length && map[cx][cy] && visited[cx][cy]==0) {
					que.offer(new int[] {cx, cy});
					visited[cx][cy] = visited[x][y] +1;
					if(answer < visited[cx][cy]) {
						answer = visited[cx][cy];
					}
				}
			}
		}
	}
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	// 배열 크기 입력 받기
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int v = Integer.parseInt(st.nextToken());
    	int h = Integer.parseInt(st.nextToken());
    	// 배열 크기 초기화 및 입력 받기
    	map = new boolean[v][h];
    	for(int i=0; i<v; i++) {
    		String temp = br.readLine();
    		for(int j=0; j<h; j++) {
    			if(temp.charAt(j) == 'W') {
    				map[i][j] = false;
    			}else if(temp.charAt(j) == 'L') {
    				map[i][j] = true;
    			}
    		}
    	}
    	// 최단 거리 중 큰 값 구하기 
    	for(int i=0; i<v; i++) {
    		for(int j=0; j<h; j++) {
    			if(map[i][j]) {
    				visited = new int[v][h];
    				bfs(i,j);
    			}
    		}
    	}
    	// 츌력
    	bw.write((answer-1)+"");
    	bw.flush();
    }
}