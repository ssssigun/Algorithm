import java.io.*;
import java.util.StringTokenizer;

/*
*   1. dp 문제이므로 규칙 찾기
*   2. 첫째 줄에 테스트 케이스 T, 둘째 줄부터 정수 n개 및 스티커 점수
*   3. 각 케이스마다 두 변을 공유하지 않는 스티커 점수의 최대값을 구하라
* */
public class Main {
    public static void main(String[] args) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        // 입력 받기
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n+2];
            for(int j=0; j<2; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=2; k<n+2; k++){
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            // 최대값 구하기
            for(int j=2; j<n+2; j++){
                arr[0][j] += Math.max(arr[1][j-1], arr[1][j-2]);
                arr[1][j] += Math.max(arr[0][j-1], arr[0][j-2]);
            }
            bw.write(Math.max(arr[0][n+1], arr[1][n+1])+"\n");
        }
        // 출력하기
        bw.flush();
    }
}
