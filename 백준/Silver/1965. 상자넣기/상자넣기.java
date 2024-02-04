/*
    1. LIS 최장 증가 부분 수열 문제였다.
    2. 첫째 줄에 상자의 갯수 N
        - 둘째 줄부터 상자의 크기
    3. 최대 상자를 많이 넣을 수 있는 수 return;
* */

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        int[] arr = new int[N];
        int[] dp = new int[N];
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 부분 수열 찾기
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            // 최장 수열 갱신
            ans = Math.max(ans, dp[i]);
        }
        // 출력
        bw.write(ans+"");
        bw.flush();
    }
}
