/*
    1. 구현 (그리디?) 문제이다.
        - 숫자를 시작 순서대로 정렬 후 탐색
        - 베열을 돌면서 시간 확인
            - 시간이 겹치지 않는다면 끝 값 갱신 (시작 > 끝)
            - 큐가 비어있거나 시간이 겹친다면 (끝 > 시작) 새로 하나 추가
* */

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (o1, o2) ->{return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];});
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(arr[0][1]);
        for(int i=1; i<N; i++){
            int t = pq.peek();
            if(t <= arr[i][0]){
                pq.poll();
                pq.offer(arr[i][1]);
            }else{
                pq.offer(arr[i][1]);
            }
        }
        // 출력
        bw.write(pq.size()+"");
        bw.flush();
    }
}