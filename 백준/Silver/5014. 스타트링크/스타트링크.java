/*
 * 1. S층에서 G층으로 가기 위해서 눌러야하는 최소 버튼 수 return
 * 	- 도달하지 못하면  use the stairs return
 * 2. 첫째 줄에  F, S, G, U, D가 주어짐
 * 3. U버튼은 U만큼 더하기, D버튼은 D만큼 빼기
 * 4. bfs를 통해서 도달할 수 잇는지 확인
 * */
import java.util.*;
import java.io.*;
public class Main {
	//  F, S, G, U, D
	static int[] num;
	// 정답
	static String ans="use the stairs";
	// 방문처리 배열
	static int[] visited;
	// bfs
	static void bfs() {
		Queue<Integer> que = new LinkedList();
		que.offer(num[1]);
		visited[num[1]] = 1;
		while(!que.isEmpty()) {
			int cur = que.poll();
			// G층에 도달했으면 나가기
			if(cur == num[2]) {
				ans = (visited[cur]-1)+"";
				return;
			}
			// 윗층으로 이동 가능하면 이동
			int up = cur+num[3];
			if(up<=num[0] && visited[up]==0) {
				que.offer(up);
				visited[up] = visited[cur]+1;
			}
			// 아랫층으로 이동 가능하면 이동
			int down = cur-num[4];
			if(down>0 && visited[down]==0) {
				que.offer(down);
				visited[down] = visited[cur]+1;
			}
		}
	}
 	public static void main(String[] args) throws IOException{
		// 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 입력받기
		num = new int[5];
		for(int i=0; i<5; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		visited = new int[num[0]+1];
		// 엘리베이터 움직이기 (bfs)
		bfs();
        // 출력
		bw.write(ans);
		bw.flush();
	}
}		