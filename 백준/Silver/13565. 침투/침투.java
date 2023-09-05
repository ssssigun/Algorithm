/*
 * 1. 첫째 줄 격자의 크기 M과 N (M x N)
 * 2. 둘째 줄부터 0이 흰색, 1이 검은
 * 3. 맨위 첫째줄부터 시작해서 bfs로 인접한 0을 다 2로 바꿔주기
 * 4. 마지막 밑에 줄까지 도달했는지 체크 후 Yes or No return
 * 
 * */
import java.util.*;
import java.io.*;
public class Main{
	// 배열
	public static int[][] map;
	// 방향 벡터
	public static int[] dx 	= {0,1,0,-1};
	public static int[] dy 	= {-1,0,1,0};
	// bfs
	public static void bfs(int x, int y) {
		Queue<int[]> que = new LinkedList();
		que.offer(new int[] {x,y});
		map[x][y] =2;
		while(!que.isEmpty()) {
			x = que.peek()[0];
			y = que.peek()[1];
			que.poll();
			
			for(int i=0; i<4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				if(cx>=0 && cy>=0 && cx<map.length && cy<map[0].length) {
					if(map[cx][cy]==0) {
						que.offer(new int[] {cx,cy});
						map[cx][cy]=2;
					}
				}
			}
		}
	}
	
    public static void main(String[] args) throws IOException{
    	//입력
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	// 기본 답 No
    	String answer = "NO";
    	// map 크기 설정 및 초기화
    	int M = Integer.parseInt(st.nextToken());
    	int N = Integer.parseInt(st.nextToken());
    	map = new int[M][N];
    	// map 입력 받기
    	for(int i=0; i<M; i++) {
    		String temp = br.readLine();
    		for(int j=0; j<N; j++) {
    			map[i][j] = temp.charAt(j) - '0';
    		}
    	}
    	//outside에서 주입이므로 상단에서 bfs 시작
    	for(int i=0; i<N; i++) {
    		if(map[0][i]==0) {
    			bfs(0,i);
    		}
    	}
    	//마지막까지 도달했는지 확인
    	for(int i=0; i<N; i++) {
    		if(map[M-1][i]==2) {
    			answer="YES";
    			break;
    		}
    	}
    	// 출력
    	System.out.println(answer);
    } 
}