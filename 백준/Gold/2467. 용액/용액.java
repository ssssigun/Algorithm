/*
    1. 백트래킹 문제인 줄 알았으나 수가 너무 큼
        - 투 포인터를 이용해서 풀어보자
        - 양쪽 끝에 포인터를 잡고 시작
        - 두 수를 더했을 때 양수이면 left++
        - 두 수를 더했을 때 음수이면 right--
    2. 첫째 줄엔 용액의 개수 N
        - 둘째 줄엔 용액의 특성 값이 오름차순
    3. 특성 값이 0에 가까운 용액 오름차순으로 return
* */

import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left = 1;
        int right = N;
        long min = Long.MAX_VALUE;
        int[] ans = new int[2];
        while(left < right){
            long sum = arr[left] + arr[right];
            if(min > Math.abs(sum)){ // 0에 근사값 구하고 저장
                min = Math.abs(sum);
                ans[0] = arr[left];
                ans[1] = arr[right];
            }
            if(sum < 0){ // 음수가 크면 left 업
                left++;
            }else if(sum == 0){ // 같으면 나가기
                break;
            }else{ // 양수가 크면 right 업
                right--;
            }
        }
        // 출력
        bw.write(ans[0]+" "+ans[1]);
        bw.flush();
    }
}