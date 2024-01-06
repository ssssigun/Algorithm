/*
 * 1. 걷기(X-1, X+1)나 순간이동(2*X)을 통해 K까지 도달
 * 2. 입력은 첫째줄 수빈의 위치 N, 동생의 위치 K
 * 3. 수빈이가 동생을 찾는 가장 빠른 시간 return
 * 	- 추가로 정답 경로 출력
 *  - 배열 추가해서 부모 저장하기
*/
import java.util.*;
import java.io.*;
public class Main{
	public static int[] visited = new int[100001]; // 방문 처리 배열
	public static int[] log = new int[100001]; // 부모 저장 배열
	public static int N; // 수빈 위치
	public static int K; // 동생 위치
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken()); 
    	K = Integer.parseInt(st.nextToken()); 
    	// 위치 찾기
    	bfs();
    	// 출력
    	bw.write(visited[K]+"\n"); // 가장 빠른 시간 출력
    	bw.write(findF()); // 경로 찾기 함수로 담아서 출력
    	bw.flush();
    }
    // bfs
    public static void bfs() {
    	Queue<Integer> que = new LinkedList();
    	if(K!=N) que.offer(N); // 출발지와 도착지가 같지 않으면 출발
    	
    	while(!que.isEmpty()) {
    		int now = que.poll();
    		int depth = visited[now];
    		int[] temp = new int[] {2*now, now-1, now+1};
    		for(int i: temp) {
    			if(i>=0 && i<100001 && visited[i]==0) {
    				visited[i] = depth+1;
    				log[i] = now; // 부모 저장
    				que.offer(i);
    			}
    		}
    	}
    }
    // 경로 저장 함수 (역 추적)
    public static String findF() {
    	StringBuilder sb = new StringBuilder();
    	Stack<Integer> stack  = new Stack();
    	int t = K;
    	// 부모 따라 올라가서 stack에 넣기
    	while(t != N) {
    		stack.push(t);
    		t = log[t];
    	}
    	stack.push(t);
    	// String으로 만들기
    	while(!stack.isEmpty()) {
    		sb.append(stack.pop()+" ");
    	}
    	return sb.toString();
    }
}