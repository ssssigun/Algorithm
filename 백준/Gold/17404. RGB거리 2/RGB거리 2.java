/*
    1. dp 문제인 것 같다.
        - 지나가면서 다음꺼에 본인과 같지 않은 색상을 넣으면 i-1, i+1 성립
        - 더했을때 최솟값을 dp에 저장
        - 처음과 N이 같지않게 하기 위해서 dp배열과 같은 크기의 배열을 하나 더 생성하고 시작점을 저장하기
    2. 첫째 줄에 집의 수 N
        - 이후 N개 줄에 R G B 비용이 주어짐
    3. 조건에 맞는 최솟값 return
* */

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        final int MAXVAL = 1000 * 1000;
        // 입력 받기
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+1][3];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N+1][3];

        int ans = MAXVAL;

        for(int l=0; l<3; l++){ // 처음 3개를 기준으로 초기화 할거임
            for(int i=0; i<N; i++){ // 최솟값을 찾기 위해 전체 초기화
                Arrays.fill(dp[i], MAXVAL);
            }
            for(int i=0; i<3; i++){ // dp의 앞줄 초기화 (인덱스가 다른 경우는 큰값으로 초기화)
                if(l == i){
                    dp[0][i] = arr[0][i];
                }else{
                    dp[0][i] = MAXVAL;
                }
            }
            for(int i=0; i<N; i++){ // 1부터 최솟값 찾기
                for(int j=0; j<3; j++){ // 현재 값
                    int cur = dp[i][j];
                    for(int k=0; k<3; k++){ // 다음 값
                        if(j != k){ // 같은 위치가 아닐때
                            dp[i+1][k] = Math.min(dp[i+1][k], cur + arr[i+1][k]); // 최솟값 대입
                        }
                    }
                }
            }
            int min = Integer.MAX_VALUE;
            for(int i=0; i<3; i++){ // 최솟값 구하기
                if(min > dp[N-1][i] && l != i){
                    min = dp[N-1][i];
                }
            }
            ans = Math.min(ans, min); // 전체 최솟값과 비교
        }
        // 출력
        bw.write(ans+"");
        bw.flush();
    }

}