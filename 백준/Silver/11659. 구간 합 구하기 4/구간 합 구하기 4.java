/*
    1. 누적합 문제인줄 알았으나 dp 문제인 듯하다
        - 최악의 경우 N x M로 시간 초과
        - 따라서 dp로 지나가면서 누적합을 계산하고
        - 주어진 인덱스 값으로 차이를 구하면 구간의 합이 구해진다.
        -  j의 누적합 - (i-1의 누적합)
    2. 첫째 줄엔 숫자의 개수 N, 구간의 개수 M
        - 둘째 줄엔 숫자 N개
        - 셋째 줄부터 M개의 구간이 주어짐 (i,j)
    3. 구간의 합 return
* */

import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] dp = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){ // 전체 합 구하기
            int t = Integer.parseInt(st.nextToken());
            dp[i] = dp[i-1] + t;
        }

        for(int k=0; k<M; k++){ // 구간 합 구하기 j - (i-1)
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            bw.write((dp[j]-dp[i-1])+"\n");
        }
        // 출력
        bw.flush();
    }
}