/*
 * 1. 첫째 줄에 유저의 수 N, 친구 관계의 수 M
 * 2. 케빈 베이컨 수가 가장 작은 사람을 출력 (1부터 M까지의 베이컨 수 총합)
 * 3. 일단 그래프 모형으로 관계 정리하고 1부터 N까지 돌아가면서 확인
 * 4. 케빈 베이컨 수가 가장 작은 사람을 return
 * */
import java.util.*;
import java.io.*;
public class Main{
	// 그래프 
	public static List<List<Integer>> graph = new ArrayList();
	// 방문 처리 배열
	public static int[] visited;
	// bfs
	public static void bfs(int num) {
		Queue<Integer> que = new LinkedList();
		que.offer(num);
		while(!que.isEmpty()) {
			num = que.peek();
			que.poll();
			for(int i=0; i<graph.get(num).size(); i++) {
				int nNum = graph.get(num).get(i);
				if(visited[nNum] == 0) {
					que.offer(nNum);
					visited[nNum] = visited[num]+1;
				}
			}
		}
	}
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	// 초기값 입력
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	// 케빈 베이컨 수 배열
    	int[] answer = new int[N+1];
    	// 그래프 초기화
    	for(int i=0; i<=N; i++) {
    		graph.add(new ArrayList());
    	}
    	// 그래프 입력 받기
    	for(int i=0; i<M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int fNum = Integer.parseInt(st.nextToken());
    		int sNum = Integer.parseInt(st.nextToken());
    		graph.get(fNum).add(sNum);
    		graph.get(sNum).add(fNum);
    	}
    	// 케빈 베이컨 수 구하기
    	for(int i=1; i<answer.length; i++) {
    		// 방문 겸 케빈 베이컨 수 저장
    		visited = new int[N+1];
    		bfs(i);
    		for(int j=1; j<visited.length; j++) {
    			// 자기 노드 제외
    			if(i==j) {
    				continue;
    			}
    			answer[i] += visited[j];
    		}
    	}
    	// 최소값 찾기
    	int min = 100;
    	int idx = 0;
    	for(int i=1; i<answer.length; i++) {
    		if(min > answer[i]) {
    			min = answer[i];
    			idx = i;
    		}
    	}
    	// 출력
    	bw.write(idx+"");
    	bw.flush();
    }
}