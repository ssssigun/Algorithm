/*
    1. 단순 구현문제인 것 같다.
        - 단, 최대 범위는 조심해야하므로 long 사용
        - 가장 작은 숫자들 먼저 더해야하므로 입력 받은 수들 오름차순 sort
        - m번만큼 카드 합체를 진행
        - 마지막에 숫자카드 다 더하기
    2. 첫째 줄에 카드의 개수 n, 합체 수 m
        - 둘째줄엔 자연수 카드 n개
    3. 만들 수 있는 가장 작은 수 return
* */

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 카드 합체
        for(int i=0; i<m; i++){
            Arrays.sort(arr);
            long sum = arr[0] + arr[1];
            arr[0] = sum;
            arr[1] = sum;
        }
        // 합 구하기
        long ans = 0;
        for(int i=0; i<n; i++){
            ans += arr[i];
        }
        // 출력
        bw.write(ans+"");
        bw.flush();
    }
}