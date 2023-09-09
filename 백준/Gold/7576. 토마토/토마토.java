/*
 * 1. 덜 익은 토마토는 익은 토마토의 영향을 받는다. (양 옆, 위아래 4방향)
 * 2. 언제 보관된 토마토들이 다 익게 되는지 최소 일수 return
 * 	- 모두 익지 못하는 상황이면 -1, 이미 다 익어있으면 0 return
 * 3. 첫 줄은 상자의 크기 가로 M, 세로 N
 * 4. 1은 익은 토마토, 0은 익지 않은 토마토, -1은 토마토가 없다.
 * */
import java.util.*;
import java.io.*;
public class Main{
	// 상자 배열
	public static int[][] box;
	// 방향 벡터
	public static int[] dx = {1, 0, -1, 0};
	public static int[] dy = {0, -1, 0, 1};
	// bfs
	public static void bfs(List<int[]> list) {
		Queue<int[]> que = new LinkedList();
		for(int i=0; i<list.size(); i++) {
			que.offer(list.get(i));
		}
		while(!que.isEmpty()) {
			int x = que.peek()[0];
			int y = que.peek()[1];
			que.poll();
			for(int i=0; i<4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				if(cx>=0 && cy>=0 && cx<box.length && cy<box[0].length) {
					if(box[cx][cy] == 0) {
						que.offer(new int[] {cx,cy});
						box[cx][cy] = box[x][y]+1;
					}
				}
			}
		}
	}
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int answer = 1;
    	int cnt = 0;
    	int M = Integer.parseInt(st.nextToken());
    	int N = Integer.parseInt(st.nextToken());
    	// 익은 토마토 위치를 담은 배열
    	List<int[]> tomato = new ArrayList();
    	// 배열 입력 받기
    	box = new int[N][M];
    	for(int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0; j<M; j++) {
    			box[i][j] = Integer.parseInt(st.nextToken());
    			// 익은 토마토 위치 저장
    			if(box[i][j] == 1) {
    				tomato.add(new int[] {i,j});
    			}else if(box[i][j] == 0) {
    				cnt++;
    			}
    		}
    	}
    	// 이미 익어있는 박스면 스킵
    	if(cnt==0) {
    		N=0;
    	}
    	// bfs 진행 (토마토가 익는 과정)
    	bfs(tomato);
    	
    	// 확인하기
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<M; j++) {
    			if(answer < box[i][j]) {
    				answer = box[i][j];
    			}
    			// 안익은 토마토 발견시
    			if(box[i][j] == 0 ) {
    				answer=-1;
    				break;
    			}
    		}
    		if(answer == -1) {
    			answer=0;
    			break;
    		}
    	}
    	// 출력
    	bw.write((answer-1)+"");
    	bw.flush();
    }
}