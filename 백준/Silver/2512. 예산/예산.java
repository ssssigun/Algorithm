/*
    1. 이분 탐색 문제인 듯 하다.
        - 시간 복잡도는 최대 N * logM
        - 예산의 총합이 총 예산 이하라면 최댓값을 그대로 반환한다.
        - 총 예산 이상이라면 이분 탐색을 통해 상한선을 구해야한다.
            - 미들 값을 상한선으로 두고 계산 했을 때 총 예산 이하라면 low = mid + 1
            - 미들 값을 상한선으로 두고 계산 했을 때 총 예산 이상이라면 high = mid
    2. 첫째 줄엔 지방의 수 N
        - 둘째 줄엔 지방의 예산 N개
        - 마지막 줄엔 총 예산
    3. 배정된 예산 중 최댓값 return
* */

import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        int N  = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        long sum = 0;
        int max = 0;
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            max = Math.max(max, arr[i]);
        }
        int budget = Integer.parseInt(br.readLine());
        if(budget >= sum){ // 총 예산 범위 안에 있으면 최댓값 반환하고 나가기
            bw.write(max+"");
            bw.flush();
            return;
        }
        int low = 0;
        int high = max;
        while(low < high){
            int mid = (high + low) / 2;
            sum = 0;
            for(int i=0; i<N; i++){
                if(mid >= arr[i]){
                    sum += arr[i];
                }else{
                    sum += mid;
                }
            }
            if(sum > budget){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        // 출력
        bw.write((low-1)+"");
        bw.flush();
    }
}