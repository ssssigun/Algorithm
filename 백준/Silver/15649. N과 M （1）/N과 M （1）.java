/*
 * 1. N개의 자연수, 자연수 M
 * 2. 1부터 N까지의 자연수 중에서 중복 없이 M개를 고른 수열 print
 * */
import java.util.*;
import java.io.*;
public class Main{
	// 출력
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	// 방문 처리 배열
	public static boolean[] visited;
	// 프린트 용 배열
	public static int[] arr;
	// dfs
	public static void dfs(int N, int M, int depth) throws IOException{
		// M개를 고르면 탈출 및 프린트
		if(depth == M) {
			for(int i=0; i<arr.length-1; i++) {
				bw.write(arr[i]+" ");
			}
			bw.write(arr[arr.length-1]+"\n");
			bw.flush();
			return;
		}
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				// 방문처리
				visited[i] = true;
				arr[depth] = i+1;
				dfs(N,M, depth+1);
				visited[i] = false;
			}
		}
		
	}
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	// 배열 크기 지정
    	visited = new boolean[N];
    	arr = new int[M];
    	// dfs 실행
    	dfs(N,M,0);
    }
}