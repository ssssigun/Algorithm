/*
    1. 이분 탐색 연습 문제
        - 최소 금액은 하루 이용 금액의 최대값
        - 최대 금액은 이용 금액의 총 합
        - mid값을 최소 인출 금액으로 잡고 인출 횟수를 구하기
        - 인출 횟수가 적으면 인출 값이 높으므로 high = mid
        - 인출 횟수가 많으면 인출 값이 낮으므로 low = mid +1
    2. 첫째 줄에 일 수 N, 인출 횟수 M
        - 둘째 줄부터 이용할 금액 N개
    3. 인출해야하는 최소 금액 K를 return
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
        int low = 0;
        int high = 0;
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            low = Math.max(low, arr[i]); // 하루 이용 금액 최대값 구하기
            high += arr[i]; // 전체 이용 총량 구하기
        }
        while(low < high){
            int mid = (low + high) / 2;
            int money = mid;
            int cnt = 1;
            for(int i : arr){ // 돌면서 인출 횟수 확인
                if (money - i >= 0) {
                    money -= i;
                }else{
                    cnt++;
                    money = mid - i;
                }
            }
            if(cnt > M){ // 인출 횟수가 많으면 기준 금액이 낮으므로 올려준다
                low = mid + 1;
            }else{ // 인출 횟수가 적으면 기준 금액이 높으므로 낮춰준다
                high = mid;
            }
        }
        // 출력
        bw.write(low+"");
        bw.flush();
    }
}
