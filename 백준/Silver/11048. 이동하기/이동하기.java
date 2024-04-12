import java.io.*;
import java.util.StringTokenizer;

/*
    1. dp 알고리즘 재활 실버 문제 풀기
        - 준규는 오른쪽, 아래, 오른쪽 대각으로 이동할 수 있다.
        - dp 배열을 만들고 이동 방향쪽의 누적합을 구하면 될 것 같다.
        - 단, 조건은 항상 최대값일 때만 담을 것
    2. 첫째 줄에 미로의 크기 M x N
        - 둘째 줄부터 N개의 줄에 M개의 숫자가 주어지며 각각 사탕의 개수가 주어진다.
    3. (N,M) 마지막으로 이동했을 때 가져올 수 있는 사탕의 최대값을 return
* */

class Main {
    static int[] dx = {1, 0, 1};
    static int[] dy = {0, 1, 1};
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][M+1];
        int[][] dp = new int[N+1][M+1];
        // 입력 받기
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<N; i++){ // arr 배열을 dp 배열로 복사
            dp[i] = arr[i].clone();
        }
        // 누적합 구하기
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                arr[i][j] = dp[i][j];
                for(int k=0; k<3; k++){
                    dp[i+dx[k]][j+dy[k]] =  Math.max(dp[i+dx[k]][j+dy[k]], arr[i][j] + arr[i+dx[k]][j+dy[k]]); // 현재 값과 다음 값 중에 큰 값을 대입
                }
            }
        }
        // 출력
        bw.write(dp[N-1][M-1]+""); // 도착 지점
        bw.flush();
    }
}