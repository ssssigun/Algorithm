/*
 * 1. 백트래킹 문제 (재귀 사용)
 * 2. 첫째 줄엔 자연수 N과 M
 * 3. 조건을 만족하는 수열 return
 * 	- 중복 가능
 *  - 비내림차순 (오름차순)
*/
import java.util.*;
import java.io.*;
public class Main{
	// 출력
	static StringBuilder sb = new StringBuilder();
	// 자연수의 범위
	static int N=0;
	// 수열의 범위
	static int M=0;
	// 수열 배열
	static int[] arr;
	// 백트래킹
	static void back(int start, int depth) {
		// 수열 범위랑 같으면 출력
		if(depth == M) {
			for(int i=0; i<arr.length-1; i++) {
				sb.append(arr[i]+" ");
			}
			sb.append(arr[arr.length-1]+"\n");
		// 아니면 추가
		}else {
			for(int i=start; i<=N; i++) {
				arr[depth] = i;
				back(i, depth+1);
				arr[depth] = 0;
			}
		}
	}
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	// N과 M 입력
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	// 배열 초기화
    	arr = new int[M];
    	// 수열 생성
    	back(1,0);
    	// 출력
    	bw.write(sb.toString());
    	bw.flush();
    }
}