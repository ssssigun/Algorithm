/*
 * 1. 첫째 줄에 정점의 수 N, 간선의 수 N, 시작 정점 R
 * 2. 노드 방문 순서를 노드 순서대로 return 
 * 3. dfs 수업이니까 dfs로 접근하기
 * */
import java.util.*;
import java.io.*;

public class Main{
	// 그래프로 만들기
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList();
	// 방문처리 배열
	public static int[] visited;
	// 방문 순서 카운트
	public static int cnt=0;
	// dfs
	public static void dfs(int num) {
		visited[num] = ++cnt;
		for(int i=0; i<graph.get(num).size(); i++) {
			int x = graph.get(num).get(i);
			if(visited[x]==0) {
				dfs(x);
			}
		}
	}
    public static void main(String[] args) throws IOException{
    	// 입력 받기
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int node = Integer.parseInt(st.nextToken());
    	int edge = Integer.parseInt(st.nextToken());
    	int startNode = Integer.parseInt(st.nextToken());
    	//배열 초기화
    	visited = new int[node+1];
    	for(int i=0; i<node+1; i++) {
    		graph.add(new ArrayList());
    	}
    	// 그래프 형태로 저장
    	for(int i=0; i<edge; i++) {
    		st = new StringTokenizer(br.readLine());
    		int fNum = Integer.parseInt(st.nextToken());
    		int sNum = Integer.parseInt(st.nextToken());
    		graph.get(fNum).add(sNum);
    		graph.get(sNum).add(fNum);
    	}
    	//오름차순으로 정렬
    	for(int i=0; i<node+1; i++) {
    		Collections.sort(graph.get(i));
    	}
    	// dfs 시작
    	dfs(startNode);
    	// 노드 방문 순서 출력
    	for(int i=1; i<visited.length; i++) {
    		System.out.println(visited[i]);
    	}
    } 
}