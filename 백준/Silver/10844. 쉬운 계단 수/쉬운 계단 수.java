/*
 * 1. dp 문제의 핵심은 점화식
 *  - 자릿수와 자리값을 이용해 풀기
 * 2. 첫째 줄에 자리값 N
 * 3. 계단의 수가 총 몇개인지 return
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	int N = Integer.parseInt(br.readLine());
    	int div = 1000000000;
    	long[][] dp = new long[N+1][10];
    	long ans = 0;
    	// 초기화
    	for(int i=1; i<10; i++) {
    		dp[1][i] = 1;
    	}
    	// 갯수 구하기
    	for(int i=2; i<=N; i++) {
    		for(int j=0; j<10; j++) {
    			if(j == 9) {
    				dp[i][9] = dp[i-1][8] % div;
    			}else if(j == 0) {
    				dp[i][0] = dp[i-1][1] % div;
    			}else {
    				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % div;
    			}
    		}
    	}
    	// 갯수 다 더해서 출력
    	for(int i=0; i<10; i++) {
    		ans += dp[N][i];
    	}
    	bw.write(ans%div+"");
    	bw.flush();
    }
}