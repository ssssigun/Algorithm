/*
 * 1. 섬의 갯수 세는 문제
 * 2. 여기서는 대각선까지 하나의 섬이다.
 * 3. 따라서 방향 백터를 추가해야하고 bfs로 진행
 */
import java.util.*;
import java.io.*;
public class Main{
	//맵
	public static int[][] map;
	//방향 벡터(대각까지 포함)
	public static int[] dx =  {0, 1, 1, 1, 0,-1, -1,-1};
	public static int[] dy =  {-1,-1,0, 1, 1, 1, 0,-1};
	// bfs
	public static void bfs(int x, int y) {
		Queue<int[]> que = new LinkedList();
		que.offer(new int[] {x,y});
		
		while(!que.isEmpty()) {
			x = que.peek()[0];
			y = que.peek()[1];
			que.poll();
			map[x][y] =2;
		
			// 8방향 확인
			for(int i=0; i<dx.length; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				if(cx>=0 && cy>=0 && cx<map.length && cy<map[0].length ) {
					if(map[cx][cy]==1) {
						que.offer(new int[] {cx,cy});
						map[cx][cy] =2;
					}
				}
			}
		}
	}
	
    public static void main(String[] args) throws IOException{
    	//입력
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int cnt =0;
    	while(true) {
    		//지도 입력 받기
    		st = new StringTokenizer(br.readLine());
    		int w = Integer.parseInt(st.nextToken());
    		int h = Integer.parseInt(st.nextToken());
    		cnt=0;
    		// 마지막 입력(0,0)시 탈출
    		if(h==0) {
    			break;
    		}
    		// 섬 입력 받기
    		map = new int[h][w];
    		for(int i=0; i<h; 	i++) {
    			st = new StringTokenizer(br.readLine());
    			for(int j=0; j<w; j++){
    				map[i][j] = Integer.parseInt(st.nextToken());
    			}
    		}
    		//돌면서 섬이 몇개인지 확인
    		for(int i=0; i<h; i++) {
    			for(int j=0; j<w; j++) {
    				if(map[i][j]==1) {
	    	    		bfs(i,j);
	    	    		cnt++;
    				}
    			}
    		}
    		// 섬의 갯수 출력	
    		System.out.println(cnt);
    	}
    } 
}