/*
 * 1. 백트래킹 문제 (재귀 사용)
 *  - N개의 자연수로 M개를 골라 수열을 만들어라
 * 	- 주어진 수열 사용
 *  - 중복 O
 * 2. 첫째 줄엔 N과 M
 * 3. 둘째 줄엔 수 종류
 * 4. 수열을 사전 순(오름차순)으로 return
*/
import java.util.*;
import java.io.*;
public class Main{
	// 프린트 문자열
	static StringBuilder sb = new StringBuilder();
	// 프린트할 배열
	static int[] p;
	// M개 고르기
	static int M;
	// 수 종류
	static int[] arr;
	// 백트래킹 함수
	static void back(int depth) {
		// M개 고르면 출력
		if(depth == M) {
			for(int i=0; i<p.length-1; i++) {
				sb.append(p[i]+" ");
			}
			sb.append(p[p.length-1]+"\n");
		}else {
			for(int i=0; i<arr.length; i++) {
				p[depth] = arr[i];
				back(depth+1);
			}
		}
	}
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	// N과 M 입력
    	int N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	p = new int[M];
    	// 수 입력 받기
    	arr = new int[N];
    	st = new StringTokenizer(br.readLine());
    	for(int i=0; i<N; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	// 정렬
    	Arrays.sort(arr);
    	// 수열 생성
    	back(0);
    	// 출력
    	bw.write(sb.toString());
    	bw.flush();
    }
}