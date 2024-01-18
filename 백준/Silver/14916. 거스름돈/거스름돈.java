/*
 * 1. dp 문제
 * 2. 첫째 줄에 거스름돈 액수 n
 * 3. 동전의 최소 개수 return
 * */
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	int n = Integer.parseInt(br.readLine());
    	final int Max_val = Integer.MAX_VALUE;
    	// 초기화
    	int[] dp = new int[n+1+6];
    	dp[0] = Max_val;
    	dp[1] = Max_val;
    	dp[2] = 1;
    	dp[3] = Max_val;
    	dp[4] = 2;
    	dp[5] = 1;
    	// 연산
    	for(int i=6; i<=n; i++) {
    		dp[i] = Math.min(dp[i-2], dp[i-5]) + 1;
    	}
    	// 출력할 수 없는 수는 -1
    	if(dp[n] == Max_val) {
    		dp[n] = -1;
    	}
    	// 출력
    	bw.write(dp[n]+"");
    	bw.flush();
    }
}