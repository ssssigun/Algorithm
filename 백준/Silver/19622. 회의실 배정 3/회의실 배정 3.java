/*
    1. dp 문제인 것 같다. (백 트래킹 시간 초과)
        - 시간 범위가 크므로 long 타입 배열 선언
        - long 타입과 같은 크기의 dp 배열 생성
        - k 위치에서 K+2부터 N까지 값 확인
            - k + i가 dp[k+i]보다 크면 저장
            - 최대값인지 확인 후 ans 변수에 저장
    2. 첫째 줄엔 회의의 수 N
        - 이후 N개에 회의
        - 시작 시간, 끝나는 시간, 인원
    3. 회의 진행 최대 인원을 return
* */

import java.io.*;
import java.util.StringTokenizer;

class Main {
    static long ans = 0;
    static long[][] arr;
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        // 입력 받기
        int N = Integer.parseInt(br.readLine());
        arr = new long[N][3];
        long[] dp = new long[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Long.parseLong(st.nextToken());
            arr[i][1] = Long.parseLong(st.nextToken());
            arr[i][2] = Long.parseLong(st.nextToken());
            dp[i] = arr[i][2];
        }
        // dp
        for(int i=0; i<N; i++){
            for(int j=i+2; j<=i+4; j++){
                if(j < N){
                    dp[j] = Math.max(dp[j], dp[i] + arr[j][2]);
                }
            }
        }
        for(int i=0; i<N; i++){
            ans = Math.max(ans, dp[i]);
        }
        // 출력
        bw.write(ans+"");
        bw.flush();
    }
}