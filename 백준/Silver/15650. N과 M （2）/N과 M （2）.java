/*
 * 1. 백트래킹 문제 (재귀 사용)
 * 2. 첫째 줄엔 자연수 N과 M
 * 3. 조건을 만족하는 수열 출력 (중복 x)
*/
import java.util.*;
import java.io.*;
public class Main{
	// 출력
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	// 자연수 종류
	static int N;
	// 수열의 길이
	static int M;
	// 방문처리
	static boolean[] visited;
	// 프린트 배열
	static int[] arr;
	// 백트래킹 함수
	static void back(int num, int depth) throws IOException{
		// 수열의 길이가 M이면 출력
		if(depth == M) {
			for(int i=1; i<arr.length-1; i++) {
				bw.write(arr[i]+" ");
			}
			bw.write(arr[arr.length-1]+"\n");
			bw.flush();
		}else {
			for(int i=num; i<=N; i++) {
				if(!visited[i]) {
					visited[i] = true;
					arr[depth+1] = i;
					back(i+1, depth+1);
					visited[i] = false;
				}
			}
		}
	}
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	// N과 M 입력 받기
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	// 배열 초기화
    	visited = new boolean[N+1];
    	arr = new int[M+1];
    	// 출력하기
    	back(1,0);
    }
}