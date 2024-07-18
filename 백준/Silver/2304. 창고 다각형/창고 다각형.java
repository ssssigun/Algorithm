/*
    1. 핀트를 잘 못잡았다.
        - 큰 기둥을 기준으로 왼쪽과 오른쪽 나눠서 계산
        - 왼쪽은 자기보다 큰 기둥이 나올 경우 면접 계산 후 더해주기
        - 가장 큰 기둥은 미리 면적을 저장
        - 오른쪽 부분은 역순으로 진행하면서 왼쪽가 동일
    2. 첫째 줄엔 기둥의 개수 N
        - N개의 줄엔 왼쪽면 L과 높이 H
    3. 창고 다각형의 면적 return
* */

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        // 입력 받기
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        int[] max = new int[2]; // 0 인덱스, 1 최고 높이
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            max[1] = Math.max(max[1], arr[i][1]);
        }
        Arrays.sort(arr, (o1, o2) ->{return o1[0] - o2[0];}); // L 순서로 정렬
        // 왼쪽 면적 구하기
        int ans = max[1]; // 면적 값
        for(int i=0; i<N; i++){ // 최대 높이 인덱스 값 저장
            if(max[1] == arr[i][1]){
                max[0] = i;
                break;
            }
        }
        int[] prev = arr[0].clone();
        for(int i=1; i<=max[0]; i++){
            if(prev[1] < arr[i][1]){
                ans += (arr[i][0] - prev[0]) * prev[1];
                prev = arr[i].clone();
            }
        }
        // 오른쪽 면적 구하기
        prev = arr[N-1].clone();
        for(int i=N-2; i>=max[0]; i--){
            if(prev[1] <= arr[i][1]){
                ans += (prev[0] - arr[i][0]) * prev[1];
                prev = arr[i].clone();
            }
        }
        // 출력
        bw.write(ans+"");
        bw.flush();
    }
}