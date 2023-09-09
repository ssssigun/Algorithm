/*
 * 1. 나이트의 이동 방향 벡터 4곳
 * 2. bfs로 접근 (최단거리)
 * 3. 첫째 줄은 테스트 케이스 갯수
 * 4. 둘째 줄은 나이트의 초기 값
 * 5. 셋째 줄은 도착지점
 * 6. 도착지까지 최소 이동 값 return;
 * */
import java.util.*;
import java.io.*;
public class Main{
	// 체스판 배열
	public static int[][] map;
	// 방향 벡터 (8 방향)
	public static int[] dx = {2, 2, -1, 1, -2, -2, -1, 1};
	public static int[] dy = {-1,1, -2,-2, -1, 1, 2, 2};
	// dfs
	public static void bfs(int x, int y) {
		Queue<int[]> que = new LinkedList();
		que.offer(new int[] {x,y});
		map[x][y] = 1;
		while(!que.isEmpty()) {
			x = que.peek()[0];
			y = que.peek()[1];
			que.poll();
			
			for(int i=0; i<dx.length; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				if(cx>=0 && cy>=0 && cx<map.length && cy<map[0].length) {
					if(map[cx][cy] == 0) {
						que.offer(new int[] {cx,cy});
						map[cx][cy] = map[x][y]+1;
					}
				}
			}
		}
	}
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st;
    	int tNum = Integer.parseInt(br.readLine());
    	// 입력 받기
    	for(int i=0; i<tNum; i++) {
    		// 크기 선언
    		int size = Integer.parseInt(br.readLine());
    		map = new int[size][size];
    		// 처음 위치
    		int[] fir = new int[2];
    		// 도착 위치
    		int[] fin = new int[2];
    		// 위치 입력 받기
    		st = new StringTokenizer(br.readLine());
    		fir[0] = Integer.parseInt(st.nextToken());
			fir[1] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			fin[0] = Integer.parseInt(st.nextToken());
			fin[1] = Integer.parseInt(st.nextToken());
			
			// bfs 실행
			bfs(fir[0],fir[1]);
			bw.write(map[fin[0]][fin[1]]-1+"\n");
			bw.flush();
    	}
    }
}