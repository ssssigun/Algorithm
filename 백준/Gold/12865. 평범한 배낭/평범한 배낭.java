import java.io.*;
import java.util.StringTokenizer;

/*
    1. 배낭 알고리즘을 활용한 문제이다.
        - 배낭의 최대 무게와 아이템 수로 2차원 배열을 만든다.
        - 물건마다 돌면서 (현재 무게 - 자신의 무게가 >=0)이면 (이전의 가치 + 자신의 가치)를 더한 값과 이전의 값중 큰 값을 넣어준다.
        - 그게 아니면 이전 값을 그대로 넣어준다
    2. 첫줄에 물품 수 N와 버틸 수 있는 무게 K
        - 두번째 줄부터 각 물건의 무게 W와 가치 V가 주어진다.
    3. 한 배낭에 넣을 수 있는 최대의 값 return
* */
class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] data = new int[N+1][2]; // 물건 데이터
        int[][] dp = new int[N+1][K+1]; //dp 배열
        int ans = 0; // 정답, 가치 최대값
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            data[i][0] = Integer.parseInt(st.nextToken());
            data[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<=N; i++){
            for(int j=1; j<=K; j++){
                if(j - data[i][0] >= 0){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-data[i][0]] + data[i][1]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
                if(dp[i][j] > ans){ // 가치가 최대값이면 저장
                    ans = dp[i][j];
                }
            }
        }
        // 출력
        bw.write(ans+"");
        bw.flush();
    }
}