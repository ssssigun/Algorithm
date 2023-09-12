/*
 * 1. 배열을 그래포 형태로 생성 (bfs로 접근)
 * 2. 첫줄은 노드 N개, 간선 M개
 * 3. 숨어야 하는 헛간번호(depth가 깊은 노드 번호), 헛간까지의 거리(depth), 거리가 같은 헛간 갯수(depth가 같은 노드의 갯수)
 * 		3개를 return
 * */
import java.util.*;
import java.io.*;
public class Main{
	// 그래프
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList();
	// 거리 배열
	public static int[] depth;
	// dfs
	public static void bfs(int num) {
		Queue<Integer> que = new LinkedList();
		que.offer(num);
		depth[num] = 1;
		while(!que.isEmpty()) {
			num = que.peek();
			que.poll();
			for(int i=0; i<graph.get(num).size(); i++) {
				if(depth[graph.get(num).get(i)]==0) {
					que.offer(graph.get(num).get(i));
					depth[graph.get(num).get(i)] = depth[num] + 1;
				}
			}
		}
	}
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	// 큰 값과 갯수 구하기
    	int max = 0;
    	int cnt = 0;
    	int idx = 0;
    	// N과 M
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	// 배열 초기화
    	depth = new int[N+1];
    	for(int i=0; i<=N; i++) {
    		graph.add(new ArrayList());
    	}
    	// 그래프 만들기
    	for(int i=0; i<M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int fNum = Integer.parseInt(st.nextToken());
    		int sNum = Integer.parseInt(st.nextToken());
    		graph.get(fNum).add(sNum);
    		graph.get(sNum).add(fNum);
    	}
    	// bfs 실행 (1에서의 거리 구하기)
    	bfs(1);
    	// 가장 먼 거리 노드와 갯수 구하기
    	for(int i=0; i<depth.length; i++) {
    		if(depth[i]>max) {
    			max = depth[i];
    			idx =i;
    			cnt=1;
    		}else if (depth[i]==max) {
    			cnt++;
    		}
    	}
    	// 출력하기
    	bw.write(idx + " " + (max-1) +" " + cnt);
    	bw.flush();
    }
}