/*
 * 1. 1 이동할 수 있는 칸, 0 이동할 수 없는 칸
 * 2. 첫출 세로 N, 가로 M 
 * 3. N x M 최단 거리 return
 * 4. 최단 거리이므로 bfs로 접근
 * */
import java.util.*;
import java.io.*;
public class Main{
	// 미로 배열
	public static int[][] map;
	// 방향 벡터
	public static int dx[] = {1, 0, -1, 0};
	public static int dy[] = {0, -1, 0, 1};
	// bfs
	public static void bfs(int x, int y) {
		Queue<int[]> que = new LinkedList();
		que.offer(new int[] {x,y});
			
		while(!que.isEmpty()) {
			x = que.peek()[0];
			y = que.peek()[1];
			que.poll();
			
			for(int i=0; i<4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				if(cx>=0 && cy>=0 && cx<map.length && cy<map[0].length) {
					if(map[cx][cy]==1) {
						que.offer(new int[] {cx, cy});
						map[cx][cy] = map[x][y]+1;
					}
				}
			}
		}
	}
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    	// 첫째줄 입력 받기 (RxC)
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	// 배열 입력 받기
    	map = new int[N][M];
    	for(int i=0; i<N; i++) {
    		String temp = br.readLine();
    		for(int j=0; j<M; j++) {
    			map[i][j] = Integer.parseInt(temp.charAt(j)+"");
    		}
    	}
    	// 최단거리 구하기
    	bfs(0,0);
    	// 출력
    	bw.write(map[N-1][M-1]+"");
    	bw.flush();
    }
}