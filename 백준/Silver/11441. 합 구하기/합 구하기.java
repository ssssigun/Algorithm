import java.io.*;
import java.util.StringTokenizer;

/*
    1. 누적합 문제 연습
    2. 첫째 줄엔 수의 개수 N
        - 둘쨰 줄엔 수 배열
        - 셋째 줄엔 구간의 수 M
        - 그 이후엔 구간이 주어진다
    3. 구간의 합을 return
* */
class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] dp = new int[N+1]; // 누적합 계산 배열
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = dp[i-1] + arr[i]; // 누적합 계산
        }
        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){ // 입력 받으면서 구간 합 구하기
            st = new StringTokenizer(br.readLine());
            int fNum = Integer.parseInt(st.nextToken());
            int sNum = Integer.parseInt(st.nextToken());
            bw.write(dp[sNum] - dp[fNum-1]+"");
            if(i != M-1){ // 마지막빼고 줄바꿈
                bw.write("\n");
            }
        }
        // 출력
        bw.flush();
    }
}