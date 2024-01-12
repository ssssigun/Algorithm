/*
 * 1. 연속 3번 선택은 불가능하다.
 * 2. 첫째줄엔 포도주의 잔의 개수 n
 * 	- 둘째줄부터 n+1줄까지 포두주의 양이 순서대로 주어진다
 * 3. 최대로 마실 수 있는 포도주의 양 return
 * */
import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	// 입력 받기
    	int n = Integer.parseInt(br.readLine());
    	int[] wine = new int[n+1];
    	int[] dp = new int[n+1];
    	for(int i=1; i<=n; i++) {
    		wine[i] = Integer.parseInt(br.readLine());
    	}
    	// 초기값 넣기
    	for(int i=1; i<=n; i++) {
    		if(i == 1) {
    			dp[i] = wine[1];
    		}else if(i == 2) {
    			dp[i] = wine[1] + wine[2];;
    		}else {
    			dp[i] = Math.max(dp[i-1], Math.max(wine[i] + dp[i-2], wine[i] + wine[i-1]+ dp[i-3]));
    		}
    	}
    	// 출력
    	bw.write(dp[n]+"");
    	bw.flush();
    }
}