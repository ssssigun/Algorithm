/* 1. 가로 M, 세로 N, 높이 H
 * 2. 1은 익은 토마토, 0은 익지 않은 토마토, -1은 빈칸
 * 3. 토마토가 모두 익는 최소 일수를 return
 * 	- 토마토가 모두 익지 못하는 상황이면 -1 출력
 * */
import java.util.*;
import java.io.*;
public class Main{
	// 상자 배열
	public static int[][][] box;
	// 방향벡터 (6방향)
	public static int[] dx = {1, 0, -1, 0, 0, 0};
	public static int[] dy = {0, -1, 0, 1, 0, 0};
	public static int[] dz = {0, 0, 0, 0, 1, -1};
	// bfs
	public static void bfs(List<int[]> tomato) {
		Queue<int[]> que = new LinkedList();
		for(int i=0; i<tomato.size(); i++) {
			que.offer(tomato.get(i));
		}
		while(!que.isEmpty()) {
			int x = que.peek()[0];
			int y = que.peek()[1];
			int z = que.peek()[2];
			que.poll();
			
			for(int i=0; i<6; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				int cz = z + dz[i];
				if(cx>=0 && cy>=0 && cz>=0 && cx<box.length && cy<box[0].length && cz<box[0][0].length) {
					if(box[cx][cy][cz] == 0) {
						que.offer(new int[] {cx, cy, cz});
						box[cx][cy][cz] = box[x][y][z]+1;
					}
				}
			}
		}
		
	}
    public static void main(String[] args) throws IOException{
    	// 선언
    	int answer = 0;
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	List<int[]> list = new ArrayList();
    	// 배열 크기 입력
    	int M = Integer.parseInt(st.nextToken());
    	int N = Integer.parseInt(st.nextToken());
    	int H = Integer.parseInt(st.nextToken());
    	// 배열 입력 받기
    	box = new int[N][M][H];
    	for(int i=0; i<H; i++) {
    		for(int j=0; j<N; j++) {
    			st = new StringTokenizer(br.readLine());
    			for(int k=0; k<M; k++) {
    				int temp = Integer.parseInt(st.nextToken());
    				box[j][k][i] = temp;
    				if(temp ==1) {
    					list.add(new int[] {j,k,i});
    				}
    			}
    		}
    	}
    	// bfs
    	bfs(list);
    	// 검사하기
    	for(int i=0; i<H; i++) {
    		for(int j=0; j<N; j++) {
    			for(int k=0; k<M; k++) {
    				// 안익은 토마토가 있으면 나가기
    				if(box[j][k][i]==0) {
    					answer = -1;
    					break;
					// 최소 일자 찾기
    				}else if(box[j][k][i] > answer) {
    					answer = box[j][k][i];
    				}
    			}
    			if(answer== -1) {
    				break;
    			}
    		}
    		if(answer== -1) {
				break;
			}
    	}
    	// 일자 출력
    	bw.write((answer == -1 ? answer : (answer-1)) +"");
    	bw.flush();
    }
}