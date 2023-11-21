/*
 * 1. DFS, BFS 둘 다 사용해서 과정을 retrun
 *  - 첫번째 줄엔 DFS 출력
 *  - 두번째 줄엔 BFS 출력
 * 2. 첫째 줄엔 정점(Node)의 갯수 N, 간선(Edge)의 갯수 M, 시작할 정점의 번호  N
 * 3. 둘째 줄부터 간선 정보 M개 (양방향)
 * 4. 그래프 입력 받고 과정을 기록해서 함수(DFS -> BFS)를 실행한 후 출력하기
 * */
import java.io.*;
import java.util.*;
public class Main {
	// 그래프 정보
	static List<List<Integer>> graph = new ArrayList();
	// 방문 처리 배열
	static boolean[] visited;
	// 방향 벡터
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	// 과정 저장
	static StringBuilder sb = new StringBuilder();

 	public static void main(String[] args) throws IOException{
 		// 선언
 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 		StringTokenizer st = new StringTokenizer(br.readLine());
 		int N = Integer.parseInt(st.nextToken());
 		int M = Integer.parseInt(st.nextToken());
 		int V = Integer.parseInt(st.nextToken());
 		// 변수 초기화
 		visited = new boolean[N+1];
 		for(int i=0; i<=N; i++) {
 			graph.add(new ArrayList());
 		}
 		// 간선 정보 입력 받기
 		for(int i=0; i<M; i++) {
 			st = new StringTokenizer(br.readLine());
 			int fNum = Integer.parseInt(st.nextToken());
 			int sNum = Integer.parseInt(st.nextToken());
 			
 			graph.get(fNum).add(sNum);
 			graph.get(sNum).add(fNum);
 		}
 		// 노드 번호가 작은 것부터 방문하기 위해 오름차순 정렬
 		for(int i=1; i<=N; i++) {
 			Collections.sort(graph.get(i));
 		}
 		// DFS 사용
 		dfs(V);
 		// 과정 추가
 		sb.append("\n");
 		// 방문 처리 배열 초기화
 		visited = new boolean[N+1];
 		// BFS 사용
 		bfs(V);
 		bw.write(sb.toString());
 		bw.flush();
	}
 	
	// DFS
	static void dfs(int start) {
		visited[start] = true;
		sb.append(start+" ");
		for(int i=0; i<graph.get(start).size(); i++) {
			int n = graph.get(start).get(i);
			if(!visited[n]) {
				visited[n] = true;
				dfs(n);
			}
		}
	}
	// BFS
	static void bfs(int start) {
		Queue<Integer> que = new LinkedList();
		que.offer(start);
		while(!que.isEmpty()) {
			int n = que.poll();
			visited[n] = true;
			sb.append(n+" ");
			for(int i=0; i<graph.get(n).size(); i++) {
				int temp = graph.get(n).get(i);
				if(!visited[temp]) {
					visited[temp] = true;
					que.offer(temp);
				}
			}
		}
	}
}