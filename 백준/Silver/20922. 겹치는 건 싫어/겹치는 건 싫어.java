/*
    1. 부분 수열 구하는 문제
        - 어렵게 생각했지만 수열 값의 증가가 연속성을 기준으로 확인 (LIS랑 헷갈렸음)
        - 큐 활용하기
    2. 첫째 줄에 수열의 길이 N, 같은 정수 제한값 K
        - 둘째 줄엔 수열이 주어진다.
    3. 최장 연속 부분 수열을 return
* */

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int ans = 0; // 정답
        Queue<Integer> que = new LinkedList<>(); // 수열 큐
        int[] arr = new int[100001]; // 중복 확인 배열

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            if(arr[num] == K){ // 이미 제한값까지 찼으면 큐 값을 빼기
                ans = Math.max(ans, que.size());
                while(!que.isEmpty()){
                    int temp = que.poll();
                    arr[temp]--;
                    if(temp == num){ // 같은 숫자 하나를 빼야함
                        break;
                    }
                }
            }
            arr[num]++;
            que.offer(num);
        }
        ans = Math.max(ans, que.size());
        // 수열의 길이 확인하기
        bw.write(ans+"");
        bw.flush();
    }
}