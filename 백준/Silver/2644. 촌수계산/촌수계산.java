/*
 * 1. 촌수를 구하는 문제 (그래프)
 * 	- dfs(백트레킹) 사용
 * 2. 첫번째 줄은 전체 사람의 수 n, 둘째는 촌수 계산을 할 대상 번호
 * 3. 세번째 줄은 관계의 수 m, 그 이후로 관계
 * 4. 관계를 그래프로 만들고 백트레킹으로 풀기
 * 5. 주어진 사람 촌수 구하고 return
 * */
import java.util.*;
import java.io.*;
public class Main {
	// 그래프 (가족 관계)
	static List<List<Integer>> graph = new ArrayList();
	// 방문 처리 배열
	static boolean[] visited;
	// 정답
	static String ans = "";
	// dfs
	static void dfs(int depth, int num, int fin) {
		// 방문처리
		visited[num] = true;
		// 목적지에 도착하면  depth 출력
		if(num == fin) {
			ans = depth+"";
			return;
		}else {
			// 그게 아니면 찾기
			for(int i=0; i<graph.get(num).size(); i++) {
				if(!visited[graph.get(num).get(i)]) {
					dfs(depth+1, graph.get(num).get(i), fin);
				}
			}
		}
	}
	public static void main(String[] args) throws IOException{
		// 선언 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		// 입력 받기
		// 전체 사람 수 (vertex)
		int n = Integer.parseInt(br.readLine());
		visited = new boolean[n+1];
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList());
		}
		// 타켓 사람
		st = new StringTokenizer(br.readLine());
		int[] t = new int[2];
		t[0] = Integer.parseInt(st.nextToken());
		t[1] = Integer.parseInt(st.nextToken());
		// 관계의 수 (edge)
		int m = Integer.parseInt(br.readLine());
		// 그래프에 저장하기
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int fNum = Integer.parseInt(st.nextToken());
			int sNum = Integer.parseInt(st.nextToken());
			graph.get(fNum).add(sNum);
			graph.get(sNum).add(fNum);
		}
		
		// dfs
		dfs(0, t[0], t[1]);
		
		// 출력 
		ans = ans.equals("") ? "-1" : ans;
		bw.write(ans);
		bw.flush();
	}
}		