/*
 * 1. 노드 n개, 간선 n-1개
 * 2. 부모 노드를 출력해주기
 * 3. 트리 먼저 구하자
 * */
import java.util.*;
import java.io.*;
public class Main{
	//방문 처리 배열
	public static boolean[] v;
	// 트리 만들기
	public static ArrayList<ArrayList<Integer>> tree = new ArrayList();
	public static int[] answer;
	//dfs 메서드
	public static void dfs(int num) {
		v[num] = true;
		for(int i=0; i<tree.get(num).size(); i++) {
            //부모노드 저장
			if(answer[tree.get(num).get(i)]==0) {
				answer[tree.get(num).get(i)] = num;
			}
			if(!v[tree.get(num).get(i)]) {
				dfs(tree.get(num).get(i));
			}
		}

	}
	
    public static void main(String[] args) throws IOException{
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 노드 개수 입력
		int node = Integer.parseInt(br.readLine());
		//배열 초기화
		answer = new int[node+1];
		v = new boolean[node+1];
		for(int i=0; i<=node; i++) {
			ArrayList a = new ArrayList();
			tree.add(a);
		}
		//간선 입력 받기 (트리 만들기)
		for(int i=0; i<node-1; i++) {
			st = new StringTokenizer(br.readLine());
			int fNum = Integer.parseInt(st.nextToken());
			int sNum = Integer.parseInt(st.nextToken());
			tree.get(fNum).add(sNum);
			tree.get(sNum).add(fNum);
		}
        //dfs
		dfs(1);
        //출력
		for(int i=2; i<answer.length; i++) {
			System.out.println(answer[i]);
		}
    }
}