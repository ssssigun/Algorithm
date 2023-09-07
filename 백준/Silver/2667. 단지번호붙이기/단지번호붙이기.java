/*
 * 1. 1 집, 0 빈칸
 * 2. 첫줄엔 단지 수, 두번째부 단지별 집수 오름차순으로 정렬 return
 * 3. 첫째 줄엔 지도 크기 N 
 * 4. bfs로 접근
 * */
import java.util.*;
import java.io.*;
public class Main{
	// 지도 배열
	public static int[][] map;
	// 방향 벡터
	public static int[] dx = {1, 0, -1, 0};
	public static int[] dy = {0, -1, 0, 1};
	// 정답 배열
	public static List<Integer> answer = new ArrayList();
	// bfs
	public static void bfs(int x, int y) {
		// 집 개수 카운트
		int cnt =1;
		Queue<int[]> que = new LinkedList();
		que.offer(new int[] {x,y});
		map[x][y]=0;
		
		while(!que.isEmpty()) {
			x = que.peek()[0];
			y = que.peek()[1];
			que.poll();
			for(int i=0; i<4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				if(cx>=0 && cy>=0 && cx<map.length && cy<map.length && map[cx][cy]==1) {
					que.offer(new int[] {cx,cy});
					map[cx][cy]=0;
					cnt++;
				}
			}
		}
		answer.add(cnt);
	}
	
    public static void main (String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	// 배열 입력 받기
    	int N = Integer.parseInt(st.nextToken());
    	map = new int[N][N];
    	for(int i=0; i<N; i++) {
    		String temp = br.readLine();
    		for(int j=0; j<N; j++) {
    			map[i][j] = temp.charAt(j) - '0';
    		}
    	}
    	// 단지 갯수 세기
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<N; j++) {
    			if(map[i][j] == 1) {
    				bfs(i,j);
    			}
    		}
    	}
    	// 오름차순 정렬
    	Collections.sort(answer);
    	// 정답 출력
    	bw.write(answer.size()+"\n");
    	for(int i=0; i<answer.size(); i++) {
    		bw.write(answer.get(i)+"\n");
    	}
    	bw.flush();
    }
}