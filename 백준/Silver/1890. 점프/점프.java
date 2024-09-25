/*
    1. bfs 문제인 줄 알았으나 메모리 초과남 (dp 문제인듯)
        - 같은 크기의 dp 배열을 만들기
        - 배열을 순회하면서 본인이 닿는 위치에 +1
        - 오른쪽 아래에 저장되어 있는 값이 경로의 개수이다.
    2. 첫째 줄엔 게임판의 크기 N
        - 둘째 줄부터 N개 줄에는 숫자가 N개 주어짐
        - 0 ~ 9
    3. 가장 오른쪽 아래칸에 도달 할 수 있는 경로의 개수 Return
* */

import java.io.*;
import java.util.StringTokenizer;

class Main {
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        long[][] dp = new long[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = 1;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] >0){
                    for(int k=0; k<2; k++){
                        int cx = i + (dx[k] * map[i][j]);
                        int cy = j + (dy[k] * map[i][j]);
                        if(0<=cx && 0<=cy && cx<N && cy<N){
                            dp[cx][cy] += dp[i][j];
                        }
                    }
                }
            }
        }
        // 출력
        bw.write(dp[N-1][N-1]+"");
        bw.flush();
    }
}