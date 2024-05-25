import java.io.*;
import java.util.StringTokenizer;

/*
    1. 누적합 문제 연습
        - 범위가 주어질 때 일일히 계산하면 시간초과 될듯하다.
        - 미리 행 기준으로 누적 합을 계산해 놓고 범위가 주어지면 거기서 연산하기 -> 처음 시작은 이렇게 했으나 시간 초과 발생
        - 행 기준으로 누적합이 아닌 전체적으로 누적합을 계산해야한다.
        - 누적합의 연산은 (이전행, 지금 열) + (지금 행, 이전 열) - (이전행, 이전열) {중복으로 더하기 때문에 누적합에선 뻄}
        - 영역의 연산은 - (이전행, 지금 열) - (지금 행, 이전 열) + (이전행, 이전열) {중복으로 빼기 때문에 영역계산에서는 더함}
        - 2차원적으로 생각하자
    2. 첫째 줄엔 세로 M, 가로 N
        - 둘쨰 줄엔 영역의 갯수 K
        - 셋째 줄부터 M개는 지도의 정보
        - 그 이후에 K줄에는 영역의 정보 a b c d. (a,b)는 왼쪽 위, (c, d)는 오른쪽 아래 좌표
    3. 영역에 포함 되어있는 정글, 바다, 얼음 수를 return
* */
class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        int[][][] dp = new int[M+1][N+1][3]; // 누적 합 저장, 0 : 정글, 1 : 바다, 2 : 얼음
        // Map 정보와 누적합을 같이 계산
        for(int i=1; i<=M; i++){
            String temp = br.readLine();
            for(int j=1; j<=N; j++){
                char c = temp.charAt(j-1);
                for(int k=0; k<3; k++){ // 이전 값(같은 행, 이전 열) 복사
                    dp[i][j][k] = dp[i][j-1][k] + dp[i-1][j][k] - dp[i-1][j-1][k];
                }
                if(c == 'J'){ // 정글일 때
                    dp[i][j][0]++;
                }else if(c == 'O'){ // 바다일 때
                    dp[i][j][1]++;
                }else if(c == 'I'){ // 얼음일 떄
                    dp[i][j][2]++;
                }
            }
        }
        // 주어진 영역에 대해 계산
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine()); // 좌표 입력 받기
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int[] temp = new int[3];
            for(int j=0; j<3; j++){
                bw.write(dp[c][d][j] - dp[a-1][d][j] - dp[c][b-1][j] + dp[a-1][b-1][j]+" ");
            }
            bw.write("\n");
        }
        // 출력
        bw.flush();
    }
}