/*
 * 1. 첫째 줄은 수빈이의 위치 N, 동생의 위치 K
 * 2. return 첫줄에 찾는 가장 빠른시간
 * 3. 둘째 줄엔 찾는 방법의 수를 return
 * */
import java.util.*;
import java.io.*;
public class Main{
	// N과 K
	public static int N;
	public static int K;
	// 방문 처리 배열
	public static int[] visited= new int[100001];
	// 출력
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	// bfs
	public static void bfs() throws IOException{
		// 위치 큐
		Queue<Integer> que = new LinkedList();
		que.offer(N);
		int cnt =0;
		while(!que.isEmpty()) {
			int dis = que.peek();
			int dep = visited[dis];
			if(dis == K) {
				bw.write(visited[dis]+"");
				bw.flush();
				return;
			}
			que.poll();
			
			int[] temp = new int[] {dis-1, dis+1, dis*2};
			for(int i:temp) {
				if(i>=0 && i<100001 && visited[i]==0) {
					que.offer(i);
					visited[i] = dep+1; 
				}
			}
		}
	}
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	// 인수 입력 받기
    	N = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    	// bfs로 최소 시간 찾기
    	bfs();
    }
}