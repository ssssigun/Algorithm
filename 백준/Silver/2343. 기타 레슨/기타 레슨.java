/*
    1. 이분 탐색 연습 문제
        - 기존에 했던 것들은 자르는 문제였는데 이건 합치는 문제인 것 같다
        - 전부 더 한 값이 최대값 시작
        -
    2. 첫째 줄에 강의의 수 N, 블루레이의 수 M
        - 둘째 줄엔 강의의 길이
    3. 블루레이의 최소 크기 return
* */

import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int high = 0;
        int low = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            high += arr[i];
        }
        while(low < high){
            int mid = (low + high) / 2;
            int sum = 0;
            int cnt = 1;
            int max = 0;
            for(int i=0; i<N; i++){
                if(sum + arr[i] <= mid){
                    sum += arr[i];
                }else{
                    cnt++;
                    max = Math.max(max, sum);
                    sum = arr[i];
                }
            }
            max = Math.max(max, sum);
            if(cnt > M){ // 블루레이 숫자가 많으면 용량이 적다는 뜻이므로 올리기
                low = mid + 1;
            }else if(cnt < M){ // 블루레이 숫자가 낮으면 용량이 많다는 뜻이므로 내리기
                high = mid;
            }else{ // 블루레이 숫자가 동일할 때 용량의 최소 크기를 찾기
                if(max > mid){
                    low = mid + 1;
                }else{
                    high = mid;
                }
            }
        }
        // 출력
        bw.write(low+"");
        bw.flush();
    }
}