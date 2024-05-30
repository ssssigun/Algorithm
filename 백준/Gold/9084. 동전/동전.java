import java.io.*;
import java.util.StringTokenizer;

/*
    1. dp 문제 (많이 헤맸다.)
        - 접근은 쉽게 했으나 일반식을 도출하는 것에 어려움을 느꼈다.
        - DP[i] = DP[i] + DP[i - (사용하는 동전 크기)]
    2. 첫쨰 줄엔 테스트 케이스의 갯수 T
        - 각 테스트 케이스의 첫쨰 줄엔 동전의 가지 수 N
        - 두번째 줄에는 N개의 동전이 오름차순
        - 세번째 줄엔 목표 금액 M
    3. 목표 금액을 만드는 경우의 수를 return
* */
class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        // 입력 받기
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){ // 테스트 케이스 돌기
            int N = Integer.parseInt(br.readLine()); // 동전의 갯수
            int[] coin = new int[N+1]; // 동전 종류 배열
            st = new StringTokenizer (br.readLine());
            for(int j=1; j<=N; j++){ // 동전 입력 받기
                coin[j] = Integer.parseInt(st.nextToken());
            }
            int M = Integer.parseInt(br.readLine()); // 목표 금액
            int[] dp = new int[M+1]; // 경우의 수 배열
            dp[0] = 1;
            for(int j=1; j<=N; j++){ // 경우의 수 구하기
                for(int k=coin[j]; k<=M; k++){
                    dp[k] += dp[k - coin[j]];
                }
            }
            // M 위치에 값이 경우의 수를 나타냄
            bw.write(dp[M]+"\n");
        }
        // 출력
        bw.flush();
    }
}