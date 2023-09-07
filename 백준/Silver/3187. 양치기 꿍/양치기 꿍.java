/*
 * 1. 울타리 안 양의 수와 늑대의 수를 세는 문제
 * 2. .는 빈칸, #는 울타리,v는 늑대, k는 양이다.
 * 3. bfs로 울타리 안의 양의 수와 늑대 수를 구하고 살아남는 양과 늑대의 수를 return
 * */
import java.util.*;
import java.io.*;
public class Main{
	// 목장 배열
	public static char[][] filed;
	// 방문 처리 배열
	public static boolean[][] visited;
	// 양과 늑대의 수
	public static int sheep=0;
	public static int wolf=0;
	// 방향 벡터
	public static int[] dx = {1, 0, -1, 0};
	public static int[] dy = {0, -1, 0, 1};
	// bfs
	public static void bfs(int x, int y) {
		Queue<int[]> que = new LinkedList();
		int cSheep = 0;
		int cWolf = 0;
		// 초기값 입력
		que.offer(new int[] {x,y});
		visited[x][y] = true;
		
		while(!que.isEmpty()) {
			x = que.peek()[0];
			y = que.peek()[1];
			que.poll();
			// 양일 때
			if(filed[x][y]=='k') {
				cSheep++;
			// 늑대일 때
			}else if(filed[x][y]=='v') {
				cWolf++;
			}

			
			for(int i=0; i<4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				// 범위 안이면
				if(cx>=0 && cy>=0 && cx<filed.length && cy<filed[0].length) {
					// 울타리가 아니면 추가
					if(filed[cx][cy]!='#' && !visited[cx][cy]) {
						que.offer(new int[]{cx,cy});
						// 방문 처리
						visited[cx][cy] = true;
					}
				}
			}
		}
		// 양이 많을 경우
		if(cSheep>cWolf) {
			sheep += cSheep;
		// 그외 나머지 경우
		}else {
			wolf += cWolf;
		}

	}
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    	// 첫째줄 입력 받기 (RxC)
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int R = Integer.parseInt(st.nextToken());
    	int C = Integer.parseInt(st.nextToken());
    	// 배열 입력 받기
    	visited = new boolean[R][C];
    	filed = new char[R][C];
    	for(int i=0; i<R; i++) {
    		String temp = br.readLine();
    		for(int j=0; j<C; j++) {
    			filed[i][j] = temp.charAt(j);
    		}
    	}
    	// bfs로 확인하기
    	for(int i=0; i<filed.length; i++) {
    		for(int j=0; j<filed[0].length; j++) {
    			if(filed[i][j] != '#' && !visited[i][j]) {
    				bfs(i,j);
    			}
    		}
    	}
    	// 양과 늑대의 수 출력
    	bw.write(sheep + " "+ wolf);
    	bw.flush();
//    	}
    }
}