/*
 * 1. N개의 자연수, 자연수 M
 * 2. 1과 다른 점은 중복이 없어야한다.
 * 3. 오른차순으로 print
 * */
import java.util.*;
import java.io.*;
public class Main{
	// 정답 배열
	public static int[] arr;
	// N, M
	public static int N;
	public static int M;
	// 출력
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	// dfs
	public static void dfs(int fir,int depth) throws IOException{
		// M개 선택되면 출력
		if(depth == M) {
			for(int i=0; i<arr.length-1; i++) {
				bw.write(arr[i]+ " ");
			}
			bw.write(arr[arr.length-1]+"\n");
			bw.flush();
			return;
		}
		for(int i=fir; i<N; i++) {
				arr[depth] = i + 1;
				dfs(i+1, depth + 1);
		}
	}
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	// N과 M 입력 받기
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	// 배열 크기 및 값 초기화
    	arr = new int[M];
    	// dfs 실행
    	dfs(0, 0);
    	
    }
}