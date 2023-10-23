/*
 * 1. 백트래킹 문제 (재귀 사용)
 *  - N개의 자연수로 M개를 골라 수열을 만들어라
 * 	- 주어진 수열 사용
 *  - 오름차순
 *  - 대신 이번엔 주어진 숫자가 중복이 있음
 *  - 이 중복들은 없어야 한다.
 * 2. 첫째 줄엔 N과 M
 * 3. 둘째 줄엔 수 종류
 * 4. 수열을 사전 순(오름차순)으로 return
*/
import java.util.*;
import java.io.*;
public class Main{
	// 수열을 담은 문자열
	static StringBuilder sb = new StringBuilder();
	// 수열의 길이 M
	static int M;
	// 수 보관 배열
	static int[] arr;
	// 수열 배열
	static int[] list;
	// 방문처리 배열
	static boolean[] visited;
	// 백 트래킹 함수
	static void back(int depth) {
		// 수열의 길이가 M일때
		if(depth == M) {
			// 수열 생성해서 문자열에 추가
			for(int i=0; i<list.length-1; i++) {
				sb.append(list[i]+" ");
			}
			sb.append(list[list.length-1]+"\n");
		// 수열의 길이가 부족할 때
		}else {
			// 이전 수 저장
			int before = 0;
			for(int i=0; i<arr.length; i++) {
				// 같은 숫자 중복 넘기기 ex 1 1, 7 7
				if(!visited[i] && before != arr[i]) {
					visited[i] = true;
					list[depth] = arr[i];
					before = arr[i];
					back(depth+1);
					visited[i] = false;
				}
			}
		}
	}
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out	));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	// N과 M 입력 받기
    	int N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	// 배열 크기 초기화
    	arr = new int[N];
    	list = new int[M];
    	visited = new boolean[N];
    	// 배열 입력 받기
    	st = new StringTokenizer(br.readLine());
    	for(int i=0; i<N; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	// 정렬
    	Arrays.sort(arr);
    	// 수열 구하기
    	back(0);
    	// 출력
    	bw.write(sb.toString());
    	bw.flush();
    }
}