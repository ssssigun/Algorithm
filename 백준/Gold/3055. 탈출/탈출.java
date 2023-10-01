/*
 * 1. bfs 문제이다
 * 	- 물이랑 비버의 이동을 동시에 큐에 넣어주기 (물 먼저 이동)
 *  - 현재 비버 위치를 물이 침범하면 안된다
 * 2. 최소 시간 return
 * 3. 물 *, 빈칸 ., 돌 X, 비버굴 D, 고슴도치 S
 * */
import java.util.*;
import java.io.*;
public class Main{
	// 숲 배열
	public static int[][] forest;
	// 물 찰곳 방문 처리 배열 
	public static boolean[][] visited;
	// 도착점
	public static int[] fin = new int[2];
	// 방향 벡터
	public static int[] dx = {1, 0, -1, 0};
	public static int[] dy = {0, -1, 0, 1};
	// bfs 
	public static void bfs(int[][] fir) {
		Queue<int[]> que = new LinkedList();
		// 초기값 넣기
		for(int i=0; i<fir.length; i++) {
			que.offer(fir[i]);
		}
		while(!que.isEmpty()) {
			int x = que.peek()[0];
			int y = que.peek()[1];
			int z = que.peek()[2];
			// 물 일때 채워주기
			if(z == 1) {
				forest[x][y] = 10000;
			}
			que.poll();
			for(int i=0; i<4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				if(cx>=0 && cy>=0 && cx<forest.length && cy<forest[0].length && forest[cx][cy]==0 && !visited[cx][cy]) {
					// 비버면
					if(z == 0) {
						forest[cx][cy] += forest[x][y]+1;
						// 물이면
					}else if(z == 1) {
						// 물은 도착치를 침범할 수 없다
						if(cx==fin[0] && cy==fin[1]) continue;
						visited[cx][cy] = true;
					}
					que.offer(new int[] {cx, cy, z});
				}
			}
		}
	}
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	// 배열 크기
    	int R = Integer.parseInt(st.nextToken());
    	int C = Integer.parseInt(st.nextToken());
    	// 배열 초기화
    	forest = new int[R][C];
    	visited = new boolean[R][C];
    	// 입력 받기
    	int[] start = new int[3];
    	List<int[]> water = new ArrayList();
    	for(int i=0; i<R; i++) {
    		String temp = br.readLine();
    		for(int j=0; j<C; j++) {
    			// 시작점
    			if(temp.charAt(j) == 'S') {
    				start = new int[] {i,j,0};
				// 도착점
    			}else if(temp.charAt(j) == 'D') {
    				fin = new int[] {i,j};
				// 물일 때
    			}else if(temp.charAt(j) == '*') {
    				water.add(new int[] {i,j,1});
    				// 물 방문
    				forest[i][j] = 10000;
    				// 물 방문할 배열 방문처리
    				visited[i][j] = true;
				// 벽일 때
    			}else if(temp.charAt(j) == 'X') {
    				// 방문 처리
    				visited[i][j] = true;
    			}
    		}
    	}
    	// 물 먼저 넣고 시작점 값 넣기
    	int[][] inp = new int[water.size()+1][3];
    	for(int i=0; i<water.size(); i++) {
    		inp[i] = water.get(i);
    	}
    	inp[water.size()] = start;
    	// 진행
    	bfs(inp);
    	// 도착지가 0이면 도달하지 못했으니 KAKTUS return
    	if(forest[fin[0]][fin[1]] == 0) {
    		bw.write("KAKTUS");
    	}else {
    		bw.write(forest[fin[0]][fin[1]]+"");
    	}
    	bw.flush();
    }
}