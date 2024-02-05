/*
    1. LIS 구하기 문제 (최장 길이 부분 수열)
        - DP로 풀이 가능
    2. 첫째 줄에 수열의 크기 A
        - 둘째 줄부터 수열이 주어짐
    3. 가장 큰 수열 길이 return
* */

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        int A = Integer.parseInt(br.readLine());
        int[] arr = new int[A];
        int[] dp = new int[A];
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<A; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 찾기
        for(int i=0; i<A; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        // 출력
        bw.write(max+"");
        bw.flush();
    }
}
