/*
 * 1. 첫줄은 테스트 케이스
 * 2. 두번째 줄은 가로, 세로, 위치의 갯수
 * 3. bfs로 접근하기
 * */
import java.util.*;
import java.io.*;
public class Main{
	
	//방향 벡터
	public static int[] dx = {0, -1, 0, 1};
	public static int[] dy = {1, 0, -1, 0};
	// 가로 세로 배추
	public static int M;
	public static int N;
	public static int K;
	// 밭 사이즈
	public static int[][] field;
	//bfs
	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {x,y});
		
		while(!queue.isEmpty()) {
			x = queue.peek()[0];
			y = queue.peek()[1];
			field[x][y] =2;
			queue.poll();
			for(int i=0; i<4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				
				if(cx>=0 && cy>=0 && cx<M && cy<N) {
					if(field[cx][cy]==1) {
						queue.offer(new int[] {cx, cy});
						field[cx][cy] =2;
					}
				}
			}
		}
	}
	
    public static void main(String[] args) throws IOException{
    	//입력 받기
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int test = Integer.parseInt(br.readLine());
    	int cnt =0;
    	//테스트 케이스만큼 실행
    	for(int i=0; i<test; i++) {
    		cnt=0;
        	st = new StringTokenizer(br.readLine());
        	M = Integer.parseInt(st.nextToken());
        	N = Integer.parseInt(st.nextToken());
        	K = Integer.parseInt(st.nextToken());
        	field= new int[M][N];
        	for(int j=0; j<K; j++) {
        		st = new StringTokenizer(br.readLine());
        		int x = Integer.parseInt(st.nextToken());
        		int y = Integer.parseInt(st.nextToken());
        		field[x][y] = 1;
        	}
        	for(int j=0; j<M; j++) {
        		for(int k=0; k<N; k++) {
        			if(field[j][k] == 1) {
        				bfs(j,k);
        				cnt++;
        			}
        		}
    		}
        	System.out.println(cnt);
    	}
    }
}