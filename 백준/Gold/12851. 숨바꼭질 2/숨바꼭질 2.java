/*
 * 1. 순간 이동(2*X) 및 걷기(X-1 , X+1)로 동생 위치까지 이동
 * 	- bfs로 최단 거리 찾기
 * 2. 첫줄엔 수빈의 위치 N, 동생의 위치 K
 * 3. 가장 빠른 시간, 가장 빠른 시간으로 찾는 방법 수 return
*/
import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int minA = 1; // 최소 시간 방법의 수 저장
    	int[] visited = new int[100001]; // 방문처리 배열
    	// 수빈과 동생의 위치
    	int N = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	// bfs
    	Queue<Integer> que = new LinkedList();
    	// K과 N가 같지 않으면 시작
    	if(K != N) que.offer(N); 
    	while(!que.isEmpty()){
    		int now = que.poll();
    		int depth = visited[now];
    		// 위치 이동 추가
    		int[] temp = new int[] {2*now, now-1, now+1};
    		for(int i : temp) {
    			if(i>=0 && i<100001) {
				// 방문 하지 않았으면 추가 및 방문 처리
    				if(visited[i] == 0) {
    					visited[i] = depth+1;
    					que.offer(i);
    				}else {
				// 방문한 수라도 깊이가 같으면 추가
    					if(visited[i] == depth+1) {
    						que.offer(i);
    					}
				// 방문 했던 것 중에서 동생 위치와 같으면 minA 추가 
    					if(i==K && visited[K]==depth+1) {
    						minA++;
    					}
    				}
    			}
    		}
    	}
    	// 출력
    	bw.write(visited[K]+"\n");
    	bw.write(minA+"");
    	bw.flush();
    }
}