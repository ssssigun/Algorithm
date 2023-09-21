/*
 * 
 * 1. 노드 간의 거리 구하기
 * 2. 그래프 구조로 입력을 받는다 (거리도 포함)
 * 3. dfs로 지나갈 때마다 거리를 더 해주기
 * 4. 첫째 줄은 노드의 개수 N, 거리르 알고 싶은 노드 쌍의 개수 M
 * 5. 둘째 줄부터 N-1까지 연결된 두 점과 거리
 * 6. 마지막 줄은 거리를 알고 싶은 M개 노드 쌍
 * 7. 거리를 구해서 M개 return
 * */
import java.util.*;
import java.io.*;
public class Main{
	// 그래프 배열
	public static List<List<int[]>> graph = new ArrayList();
	// 방문 처리 배열
	public static boolean[] visited;
	// 거리 변수
	public static int distance = 0;
	// 출력 선언
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	// dfs
	public static void dfs(int start, int fin) throws IOException{
		visited[start] = true;
		// 목표 노드에 도착하면 종료
		if(start == fin) {
			bw.write(distance+"\n");
			bw.flush();
			return;
		}
		for(int i=0; i<graph.get(start).size();i++) {
			int[] temp = graph.get(start).get(i);
			if(!visited[temp[0]]) {
				distance += temp[1];
				dfs(temp[0],fin);
				distance -= temp[1];
			}
		}
	}
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	// N과 M 입력 받기
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	// 노드 쌍 저장
    	int[][] node = new int[M][2];
    	// 배열 초기화
    	for(int i=0; i<=N; i++) {
    		graph.add(new ArrayList());
    	}
    	// 노드 관계와 거리 입력 받기
    	for(int i=0; i<N-1; i++) {
    		st = new StringTokenizer(br.readLine());
    		int fNum = Integer.parseInt(st.nextToken());
    		int sNum = Integer.parseInt(st.nextToken());
    		int dis = Integer.parseInt(st.nextToken());
    		graph.get(fNum).add(new int[] {sNum, dis});
    		graph.get(sNum).add(new int[] {fNum, dis});
    	}
    	// 거리 구할 노드 쌍 입력 받기
    	for(int i=0; i<M; i++) {
    		st = new StringTokenizer(br.readLine());
    		node[i][0] = Integer.parseInt(st.nextToken());
    		node[i][1] = Integer.parseInt(st.nextToken());
    	}
    	// 거리 구하기
    	for(int i=0; i<M; i++) {
    		// 초기화
    		visited = new boolean[N+1];
    		distance = 0;
    		// dfs로 거리 계산
    		dfs(node[i][0],node[i][1]);
    	}
    }
}