/*
    1. dp 문제이다.
        - 본인보다 큰수라면 누적합 저장.
        - 크지 않으면 내 숫자로 초기화
        - dp 배열을 돌면서 최댓값 return
    2. 첫째 줄에 정수 n
        - 둘쨰 줄에 수열이 주어짐
    3. 최대값 return
* */

import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = Integer.MIN_VALUE;
        int[] dp = new int[N];
        dp[0] = arr[0];
        max = Math.max(dp[0], max);
        for(int i=1; i<N; i++){
            dp[i] = Math.max(arr[i], dp[i-1] + arr[i]);
            max = Math.max(dp[i], max);
        }
        // 출력
        bw.write(max+"");
        bw.flush();
    }
}