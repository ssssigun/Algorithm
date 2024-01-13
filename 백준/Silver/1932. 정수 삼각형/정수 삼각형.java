/*
 * 1. 대표적인 dp 문제
 * 2. 첫줄에 삼각형의 크기 n, 둘쨰줄부터 정수 삼각형이 주어짐
 * 3. 합이 최대가 수 return
 * */
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st;
    	int max = 0;
    	int n = Integer.parseInt(br.readLine());
    	int[][] ang = new int[n][n]; // 삼각형 배열
    	int[][] dp = new int[n][n]; // 연산용 배열
    	// 입력 받기
    	for(int i=0; i<n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0; j<i+1; j++) {
    			int t = Integer.parseInt(st.nextToken());
    			ang[i][j] = t;
    			dp[i][j] = t;
    		}
    	}
    	// 연산하기
    	for(int i=0; i<n-1; i++) {
    		for(int j=0; j<i+1; j++) {
    			for(int k=0; k<2; k++) {
    				int sum = dp[i][j] + ang[i+1][j+k];
    				if(sum > dp[i+1][j+k]) {
    					dp[i+1][j+k] = sum;
    				}
    			}
    		}
    	}
    	// 최대값 찾아서 출력
    	for(int i=0; i<n; i++) {
    		if(max < dp[n-1][i]) {
    			max = dp[n-1][i];
    		}
    	}
    	bw.write(max+"");
    	bw.flush();
    }
}