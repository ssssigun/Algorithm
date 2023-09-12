/*
 * 1. N개의 자연수, 자연수 M
 * 2. 이번엔 모든 수가 중복 가능하다.
 * */
import java.util.*;
import java.io.*;
public class Main{
	// 출력
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringBuilder sb = new StringBuilder();
	// 정답 배열
	public static int[] arr;
	// N, M
	public static int N;
	public static int M;
	// dfs
	public static void dfs(int depth) throws IOException{
		if(depth == M) {
			for(int i=0; i<arr.length-1; i++){
				sb.append(arr[i]+" ");
			}
			sb.append(arr[arr.length-1]+"\n");
			return;
		}
		for(int i=0; i<N; i++) {
			arr[depth] = i+1;
			dfs(depth+1);
		}
	}
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	// N, M
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	arr = new int[M];
    	// dfs 
    	dfs(0);
    	// 출력
    	bw.write(sb.toString());
    	bw.flush();
    }
}