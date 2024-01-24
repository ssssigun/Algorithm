/*
 * 1. 입력 크기가 작으므로 완전 탐색가능
 * 	- 자리를 바꾸고 많이 연결된 부분찾기
 * 2. 첫째 줄에 보드의 크기 N
 * 	- NxN 크기로 빨간색 C, 파란색 P, 초록색 Z, 노란색 Y로 주어짐
 * 3. 먹을 수 있는 최대 사탕의 갯수 출력
 * */
import java.io.*;
import java.util.*;
public class Main {
	public static int N;
	public static int max = 0;
	public static int[] d = {1,-1};
	public static char[][] map;
	public static void main(String[] args) throws IOException{
		// 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		// 입력
		map = new char[N][N];
		for(int i=0; i<N; i++) {
			String temp = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = temp.charAt(j);
			}
		}
		// 바꿔보기
		for(int i=0; i<N; i++) { // 좌우 변경 (행끼리)
			for(int j=0; j<N-1; j++) {
				swap(i, j, i,j+1);
				check();
				swap(i, j, i,j+1);
			}
		}
		for(int i=0; i<N; i++) { // 위아래 변경 (열끼리)
			for(int j=0; j<	N-1; j++) {
				swap(j, i, j+1, i);
				check();
				swap(j, i, j+1, i);
			}
		}
		// 출력
		bw.write(max+"");
		bw.flush();
	}
	// swap	
	public static void swap(int i1, int j1, int i2, int j2) {
		char temp = map[i1][j1];
		map[i1][j1] = map[i2][j2];
		map[i2][j2] = temp;
	}
	// check
	public static void check() {
		// 가로
		for(int i=0; i<N; i++) {
			int cnt = 1;
			for(int j=0; j<N-1; j++) {
				if(map[i][j] == map[i][j+1]) {
					cnt++;
				}else {
					cnt = 1;
				}
				max = Math.max(max, cnt);
			}
		}
		// 세로
		for(int i=0; i<N; i++) {
			int cnt = 1;
			for(int j=0; j<N-1; j++) {
				if(map[j][i] == map[j+1][i]) {
					cnt++;
				}else {
					cnt = 1;
				}
				max = Math.max(max, cnt);
			}
		}
	}
}