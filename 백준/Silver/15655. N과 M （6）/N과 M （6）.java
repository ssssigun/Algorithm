/*
 * 1. 백트래킹 문제 (재귀 사용)
 *  - N개의 자연수로 M개를 골라 수열을 만들어라
 * 	- 주어진 수열 사용
 *  - 오름차순
 *  - 중복 X
 * 2. 첫째 줄엔 N과 M
 * 3. 둘째 줄엔 수 종류
 * 4. 수열을 사전 순(오름차순)으로 return
*/
import java.util.*;
import java.io.*;
public class Main{
	// 수열의 크기
	static int M;
	// 수열 배열
	static int[] list;
	// 방문 처리 배열
	static boolean[] visited;
	// 프린트 문자열 저장
	static StringBuilder sb = new StringBuilder();
	// 백트래킹 함수
	static void back(int start, int depth) {
		// M개 만큼 골랐으면 출력 문자에 담기
		if(depth == M) {
			for(int i=0; i<visited.length; i++) {
				if(visited[i]) {
					sb.append(list[i]+" ");
				}
			}
			sb.append("\n");
		}else {
			for(int i=start; i<list.length; i++) {
				if(!visited[i]) {
					visited[i] = true;
					back(i+1, depth+1);
					visited[i] = false;
				}
			}
		}
	}
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	// N과 M 입력 받기
    	int N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	// 수 입력 받기
    	list = new int[N];
    	visited = new boolean[N];
    	st = new StringTokenizer(br.readLine());
    	for(int i=0; i<N; i++) {
    		list[i] = Integer.parseInt(st.nextToken());
    	}
    	// 오름차순 정렬
    	Arrays.sort(list);
    	// 수 생성
    	back(0, 0);
    	// 출력 
    	bw.write(sb.toString());
    	bw.flush();
    }
}