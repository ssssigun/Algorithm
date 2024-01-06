/*
 * 1. 걷기(X-1, X+1)나 순간이동(2*X)을 통해 K까지 도달
 * 	- 단 1,2와 다른 점은 순간이동시 시간을 소모하지 않음(0초)
 *  - 걷기일때는 그대로 사용 (1초)
 * 2. 입력은 첫째줄 수빈의 위치 N, 동생의 위치 K
 * 3. 수빈이가 동생을 찾는 가장 빠른 시간 출력
*/
import java.util.*;
import java.io.*;
public class Main{
	public static int N; // 수빈의 위치
	public static int K; // 동생의 위치
	public static int[] visited = new int[100001]; // 방문 처리 배열
	
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    	// 이동 시작
    	bfs();
    	// 출력
    	bw.write(visited[K]+"");
    	bw.flush();
    }
    // bfs
    public static void bfs() {
    	Queue<Integer> que = new LinkedList();
    	// 위치가 같지 않으면 시작
    	if(K != N) que.offer(N);
    	while(!que.isEmpty()) {
    		int now = que.poll();
    		int depth = visited[now];
    		// 종료 조건
    		if(now == K) break;
    		
    		int[] temp = new int[] {2*now, now-1, now+1};
    		for(int i: temp) {
    			if(i>=0 && i<100001 && visited[i] == 0) {
    				if(i == 2*now) {
    					visited[i] = depth;
    				}else {
    					visited[i] = depth +1;
    				}
    				que.offer(i);
    			}
    		}
    	}
    }
}