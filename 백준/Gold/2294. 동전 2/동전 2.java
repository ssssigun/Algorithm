/*
    1. dp 문제이다.
        - K+1만큼의 배열 생성
        - 동전이 존재하는 위치는 항상 값이 1
        - 동전의 종류를 순회
            - k까지 값을 넣을거임
            - 현재 위치의 값과 (현재 위치 - 동전의 가치) 값+1 중에 최솟값 저장
        - k 위치의 값이 최소의 동전 개수이다.
    2. 첫째 줄엔 동전의 종류 N과 목표 금액 K
        - 이후 N개의 줄에 동전의 가치가 주어짐
    3. 사용한 동전의 최솟값 return
        - 불가능하면 -1
* */

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[K+1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for(int i=0; i<N; i++){
            for(int j=arr[i]; j<=K; j++){
                dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
            }
        }
        // 출력
        bw.write((dp[K] == Integer.MAX_VALUE-1 ? -1 : dp[K])+"");
        bw.flush();
    }
}