/*
 * 1. 컴퓨터 1을 통해 바이러스에 걸리게 되는 컴퓨터의 수를 return
 * 2. 첫번째는 정점(노드), 두번째는 에지(간선)
 * 3. 그래프로 만든 다음 dfs를 1번부터 시작하고 자식 노드들 개수 세주기
 * */
import java.util.*;
import java.io.*;

public class Main{
	//방문 처리 배열
	public static boolean[] visited;
	//그래프 배열
	public static ArrayList<ArrayList<Integer>> list = new ArrayList();
	public static int answer = 0;
	//dfs 메서드
	public static void dfs(int num) {
		visited[num] = true;
		answer++;
		for(int i=0; i<list.get(num).size(); i++){
			if(!visited[list.get(num).get(i)]) {
				dfs(list.get(num).get(i));
			}
		}
	}
	//메인문
    public static void main(String[] args) throws IOException{
    	//입력
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int vertex = Integer.parseInt(br.readLine());
    	int edge= Integer.parseInt(br.readLine());
    	//배열 초기화
    	visited = new boolean[vertex+1];
    	for(int i=0; i<=vertex; i++) {
    		list.add(new ArrayList());
    	}
    	// edge 입력 받기
    	for(int i=1; i<=edge; i++) {
    		st = new StringTokenizer(br.readLine());
    		int fNum = Integer.parseInt(st.nextToken());
    		int SNum = Integer.parseInt(st.nextToken());
    		list.get(fNum).add(SNum);
    		list.get(SNum).add(fNum);
    	}
    	//dfs 실행
    	dfs(1);
    	//출력 (컴퓨터1는 제외)
    	System.out.println(answer-1);
    }
}