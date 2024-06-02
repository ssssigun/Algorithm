import java.io.*;
import java.util.StringTokenizer;

/*
    1. 누적합 연습
    2. 첫째 줄엔 배열의 크기 N, M
        - 둘째 줄부터 N개 줄에 배열의 정보
        - 그 이후에 범위의 개수 K
        - 그 다음엔 K개의 범위 (i,j)부터 (x,y)까지
    3. 배열의 합 return
* */
class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][M+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int K = Integer.parseInt(br.readLine());
        for(int i=0; i<K; i++){ // k개의 테스트 케이스
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            int I = Integer.parseInt(st.nextToken());
            int J = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            for(int j=I; j<=X; j++){ // 범위만큼 더하기
                for(int k=J; k<=Y; k++){
                    sum += arr[j][k];
                }
            }
            bw.write(sum+"\n");
        }
        // 출력
        bw.flush();
    }
}