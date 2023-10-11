/*
 * 1. 로봇 청소기로 청소하기, 0은 청소할 곳, 1은 벽
 * 2. 조건 순서대로 진행
 * 	- 현재 위치 청소되었는지 확인
 * 	- 주변에 청소되지 않은 빈칸이 없은 경우
 * 		* 방향을 유지하고 후진하고 처움 조건으로 돌아가기
 * 		* 후진이 불가능하면 정지
 * 	- 주변에 청소되지 않은 빈칸이 있을 경우
 * 		* 반시계로 90도 회전
 *      * 바라보는 앞칸이 청소 되지 않았으면 한칸 전진 후 처음 조건으로 돌아가기.
 * 3. 첫줄엔 방의 크기
 * 4. 둘째 줄에 로봇 청소기 초기 위치(r, c)와 방향(북 0, 동 1, 남 2, 서 3)
 * 5. 로봇 청소기가 작동을 멈출 때까지 청소한 칸의 개수를 출력
 * */
import java.util.*;
import java.io.*;
public class Main {
	// 방
	public static int[][] map;
	// 방향 벡터 (반시계)
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};
	// bfs(주변에 청소할 곳이 있는지 확인)
	public static boolean bfs(int x, int y) {
		for(int i=0; i<4; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];
			if(cx>=0 && cy>=0 && cx<map.length && cy<map[0].length && map[cx][cy]==0) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) throws IOException{
		// 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int result = 0;
		map = new int[N][M];
		// 입력 받기
		st = new StringTokenizer(br.readLine());
		// 로봇 청소기 첫 좌표 및 방향
		int posX = Integer.parseInt(st.nextToken());
		int posY = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		// 방 입력 받기
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 청소 진행
		 while(true) {
			 // 현재 위치 청소
			 if(map[posX][posY] == 0) {
				 map[posX][posY] =-1;
				 result++;
			 }
			 // 주변에 청소 가능한 곳이 있을 경우
			 if(bfs(posX,posY)) {
				 // 반시계 방향 회전
				 dir = dir-1>=0 ? dir-1 : 3;
				 // 앞의 방향이 청소하지 않은 곳이면 이동
				 int cx = posX+dx[dir];
				 int cy = posY+dy[dir];
				 if(cx>=0 && cy>=0 && cx<map.length && cy<map[0].length && map[cx][cy]==0) {
					 posX = cx;
					 posY = cy;
				 }
			 // 주변에 청소 가능한 곳이 없을 경우
			 }else {
				 // 뒤쪽으로 갈 수 있으면 
				 int back = dir+2>3 ? dir-2 : dir+2;
				 int cx = posX+dx[back];
				 int cy = posY+dy[back];
				 if(cx>=0 && cy>=0 && cx<map.length && cy<map[0].length && map[cx][cy]!=1) {
					 posX = cx;
					 posY = cy;
				 // 갈 수 없으면 작동 정지
				 }else if(cx>=0 && cy>=0 && cx<map.length && cy<map[0].length && map[cx][cy]==1){
					 break;
				 }
			 }
		 }
		 bw.write(result+"");
		 bw.flush();
	}
}		