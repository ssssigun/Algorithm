/*
    1. dp 연습 문제
        - 수만큼의 배열 생성
        - 1부터 시작해서 N에 도달할 때까지 연산, 배열 안에 연산 횟수 저장
        - 먼저 도착하면 그 값 return
    2. 첫째 줄에 정수 N
    3. 최소 연산 횟수 return
* */

import java.io.*;
import java.util.Arrays;

class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        for(int i=1; i<=N; i++){
            if(i*3 <= N){ // 3 곱하기
                dp[i*3] = Math.min(dp[i*3], dp[i] + 1);
            } 
            if(i*2 <= N){ // 2 곱하기
                dp[i*2] = Math.min(dp[i*2], dp[i] + 1);
            }
            if(i+1 <= N){ // 1 더하기
                dp[i+1] = Math.min(dp[i+1], dp[i] + 1);
            }
        }
        // 출력
        bw.write(dp[N]+"");
        bw.flush();
    }
}