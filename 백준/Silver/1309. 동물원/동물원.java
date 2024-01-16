/*
 * 1. dp 문제
 *  - 항상 규칙 찾기
 *  - 2*n 배열 우리에 사자 넣기, 붙어 있을 수 없음
 * 2. 첫째줄은 우리의 크기 N
 * 3. 사자를 배치하는 수를 9901로 나누어서 retrun
 * */
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	int N = Integer.parseInt(br.readLine());
    	final int MOD = 9901;
    	long[][] dp = new long[N+1][3];
    	dp[1][0] = dp[1][1] = dp[1][2] = 1;
    	for(int i=2; i<=N; i++) {
    		dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2])%MOD;
    		dp[i][1] = (dp[i-1][0] + dp[i-1][2])%MOD;
    		dp[i][2] = (dp[i-1][0] + dp[i-1][1]%MOD);
    	}
    	bw.write((dp[N][0] + dp[N][1]+ dp[N][2])%MOD + "");
    	bw.flush();
    }
}