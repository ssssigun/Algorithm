/*
 * 1. dfs로 풀기
 * 2. 첫째 줄엔  행 R, 열 C
 * 3. 둘째 줄부터 마당 배열
 * 4. 아침까지 살아남은 양과 늑대의 수 return
 * 	- 한 울타리에 많은 수의 동물이 살아남음
 * 	- 단 같으면 늑대가 생존
 * */
import java.io.*;
import java.util.*;
public class Main {
	// 마당 배열
	static char[][] map;
	// 방향 벡터
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	// 정답 배열 [양, 늑대]
	static int[] ans = new int[2];
	// 울타리 안 
	static int[] l = new int[2];

 	public static void main(String[] args) throws IOException{
 		// 선언 
 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 		StringTokenizer st = new StringTokenizer(br.readLine());
 		int R = Integer.parseInt(st.nextToken());
 		int C = Integer.parseInt(st.nextToken());
 		map = new char[R][C];
 		for(int i=0; i<R; i++) {
 			char[] temp = br.readLine().toCharArray();
 			map[i] = temp.clone();
 		}
 		// 마당 확인하기
 		for(int i=0; i<R; i++) {
 			for(int j=0; j<C; j++) {
 				if(map[i][j] == 'o' || map[i][j] == 'v') {
 					l = new int[2];
 					dfs(i,j);
 					// 양이 늑대보다 많을 경우
 					if(l[0] > l[1]) {
 						ans[0] += l[0];
					// 늑대가 많을 경우
 					}else {
 						ans[1] += l[1];
 					}
 				}
 			}
 		}
 		// 출력
 		bw.write(ans[0]+ " "+ ans[1]);
 		bw.flush();
	}
 	// dfs
 	static void dfs(int x, int y) {
 		if(map[x][y] == 'o') {
 			l[0]++;
 		}else if(map[x][y] =='v') {
 			l[1]++;
 		}
 		map[x][y] = '#';
 		for(int i=0; i<4; i++) {
 			int cx = x + dx[i];
 			int cy = y + dy[i];
 			if(cx>=0 && cy>=0 && cx<map.length && cy<map[0].length && map[cx][cy]!='#') {
 				dfs(cx,cy);
 			}
 		}
 	}
}