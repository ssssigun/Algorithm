/*
 * 1. 첫줄에 N과 연결도 M, 마지막 줄은 끝내야하는 작업 X
 * 2. 단방향으로 트리를 만들기 위해서 양방향으로 입력받지 않는다 (반대 방향으로 받기)
 * 3. N으로 시작해서 거치는 노드의 갯수 구하기
 * 4. 당연히 dfs 문제이다.
 * */
import java.util.*;
import java.io.*;
public class Main{
	// 트리 배열
	public static List<List<Integer>> tree = new ArrayList();
	// 방문 처리 배열
	public static boolean[] visited;
	// 타겟 넘버
	public static int X;
	// 지나간 노드 갯수
	public static int cnt = 0;
	// dfs
	public static void dfs(int num){
		List<Integer> node = tree.get(num);
		visited[num] = true;
		cnt++;
		// 노드의 연결된 자식 노드 가져오기
		for(int i=0; i<node.size(); i++) {
			int ch = node.get(i);
			if(!visited[ch]) {
				dfs(ch);
			}
		}
	}
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	// 첫줄 입력 받기
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	// 방문 처리 배열 초기화
    	visited = new boolean[N+1];
    	// 트리 크기 초기화
    	for(int i=0; i<=N; i++) {
    		tree.add(new ArrayList());
    	}
    	// 트리 입력 받기
    	for(int i=0; i<M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int fNum = Integer.parseInt(st.nextToken());
    		int sNum = Integer.parseInt(st.nextToken());
    		tree.get(sNum).add(fNum);
    	}
    	// X (기준) 입력 받기
    	X = Integer.parseInt(br.readLine());
    	// dfs 시작
		dfs(X);
		bw.write((cnt-1)+"");
		bw.flush();
    }
}