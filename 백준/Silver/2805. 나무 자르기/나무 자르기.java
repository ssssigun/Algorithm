/*
    1. 이분 탐색 문제인 것 같다 (범위가 너무 크다)
        - 최대값에서 천천히
    2. 첫째 줄에 나무의 수 N, 가져가려고 하는 나무의 길이 M
        - 둘째 줄엔 나무의 높이 N개
    3. 적어도 M 미터의 나무를 가져가기 위한 절단기에 설정 높이 최대값
* */

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int high = 0;
        int low = 0;
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer> list  = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){ // 배열 입력
            list.add(Integer.parseInt(st.nextToken()));
            high = Math.max(high, list.get(i));
        }

        Collections.sort(list, Collections.reverseOrder()); // 역순 정렬

        int mid = 0;
        while(low<high){ // 이분 탐색 시작
            mid = (high + low) / 2;
            long sum = 0;
            for(int i=0; i<list.size(); i++){
                int temp = list.get(i);
                if(temp > mid){ // 기준 값보다 높은 값만 차이 값 구하기
                    sum += temp - mid;
                }else{
                    break;
                }
            }
            if(M > sum){ // 합이 작으면 값이 작아져야 한다.
                if(mid == high){
                    break;
                }else{
                    high = mid;
                }
            }else if (M == sum){
                break;
            }else{ // 합이 작으면 값이 커야한다.
                if(low == mid){
                    break;
                }else{
                    low = mid;
                }
            }
        }
        bw.write(mid+"");
        bw.flush();
    }
}