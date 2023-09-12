/*
 * 1. N개의 자연수, 자연수 M
 * 2. 10000보다 작은 N개의 자연수가 주어진다.
 * 3. N개의 자연수 중에서 M개를 고른 수열 print
 * */
import java.util.*;
import java.io.*;
public class Main{
	// 출력
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	// 정수 배열
	public static int[] arr;
	// 정답용 배열
	public static int[] num;
	// 방문 처리 배열
	public static boolean[] visited;
	// dfs
	public static void dfs(int M, int depth) throws IOException{
		// M개 다 골랐으면 print
		if(depth == M) {
			for(int i=0; i<num.length-1; i++) {
				bw.write(num[i]+" ");
			}
			bw.write(num[num.length-1]+"\n");
			bw.flush();
			return;
		}
		// 
		for(int i=0; i<arr.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				num[depth] = arr[i];
				dfs(M, depth+1);
				visited[i] = false;
			}
		}
	}
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	// N과 M
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	// 배열 크기 선언
    	arr = new int[N];
    	num = new int[M];
    	visited = new boolean[N];
    	// 자연수의 목록
    	st = new StringTokenizer(br.readLine());
    	for(int i=0; i<N; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	// 사전순 정렬(오름차순)
    	Arrays.sort(arr);
    	// dfs 실행
    	dfs(M, 0);
    }
}