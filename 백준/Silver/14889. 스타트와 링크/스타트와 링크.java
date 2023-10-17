/*
 * 1. 재귀함수를 이용해서 하기 (백트래킹)
 * 2. 첫째 줄엔 축구 하는 사람 N, N은 짝수
 * 3. 둘째 줄부터 점수표
 * 4. 두팀의 능력치 차이의 최소값 출력
*/
import java.util.*;
import java.io.*;
public class Main{
	// 최소값
	public static int min = Integer.MAX_VALUE;
	// 축구하는 사람의 수 N
	public static int N;
	public static boolean[] visited;
	// 점수판
	public static int[][] score;
	// 백트래킹
	public static void dfs(int idx, int depth) {
		// 인원 다 찼으면 점수 구하기
		if(depth == N/2) {
			int ts1 = 0;
			int ts2 = 0;
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) {
					// 스타트 팀이면 ts1에 추가
					if(visited[i] && visited[j]) {
						ts1 += score[i][j];
						ts1 += score[j][i];
					// 링크 팀이면 ts2에 추가
					}else if(!visited[i] && !visited[j]) {
						ts2 += score[i][j];
						ts2 += score[j][i];
					}
				}
			}
			// 차이값
			int diff = Math.abs(ts1 -ts2);
			// 차이가 최소면 바꾸기
			if(diff < min) {
				min = diff;
			}
			return;
		}else {
		// 안찼으면 인원 추가하기
			for(int i=idx; i<N; i++) {
				if(!visited[i]) {
					visited[i] = true;
					dfs(i+1, depth+1);
					visited[i] = false;
				}
			}
		}
	}
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	List<Integer> list = new ArrayList();
    	// N 입력 받기
    	N = Integer.parseInt(br.readLine());
    	// 방문처리 배열
    	visited = new boolean[N];
    	// 점수판 입력 받기
    	score = new int[N][N];
    	StringTokenizer st;
    	for(int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0; j<N; j++) {
    			score[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	// 돌면서 점수 차이 구하기
    	dfs(0, 0);
    	// 출력
    	bw.write(min+"");
    	bw.flush();
    }
}