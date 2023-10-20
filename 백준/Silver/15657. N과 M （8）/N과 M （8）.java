/*
 * 1. 백트래킹 문제 (재귀 사용)
 *  - N개의 자연수로 M개를 골라 수열을 만들어라
 * 	- 주어진 수열 사용
 *  - 수열 중복 X
 *  - 숫자 중복 O
 *  - 오름차순
 * 2. 첫째 줄엔 N과 M
 * 3. 둘째 줄엔 수 종류
 * 4. 수열을 사전 순(오름차순)으로 return
*/
import java.util.*;
import java.io.*;
public class Main{
	// 출력할 수열을 담은 문자열
	static StringBuilder sb = new StringBuilder();
	// 선택한 수열
	static int[] select;
	// 수 배열
	static int[] arr;
	// M개 선택
	static int M;
	// 백트래킹 함수
	static void back(int start, int depth) {
		// M개 선택했으면 출력할 문자열에 담기
		if(depth == M) {
			for(int i=0; i<select.length-1; i++) {
				sb.append(select[i]+" ");
				
			}
			sb.append(select[select.length-1]+"\n");
		// 선택을 더해야 하면 select 배열에 추가
		}else {
			for(int i=start; i<arr.length; i++) {
				select[depth] = arr[i];
				back(i,depth+1);
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
    	// 배열 초기화
    	arr = new int[N];
    	select = new int[M];
    	// 수 입력 받기
    	st = new StringTokenizer(br.readLine());
    	for(int i=0; i<N; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	// 정렬
    	Arrays.sort(arr);
    	// 수열 생성
    	back(0, 0);
    	// 출력
    	bw.write(sb.toString());
    	bw.flush();
    }
}