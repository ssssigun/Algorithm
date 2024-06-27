/*
    1. 큐를 이용하여 다리 지나는 시간 구하기
        - 처음엔 w-1개 0를 큐에 추가
        - 하중까지 큐에 넣으면서 pop, 시간 + 1
    2. 첫째 줄에 트럭의 개수 n, 다리의 길이 w, 다리의 하중 l
        - 둘째 줄에는 트럭의 무게
    3. 모든 트럭이 다리를 건너는 최소 시간 return
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
        Queue<Integer> que = new LinkedList<>();
        int time = 1;
        int weight = 0;
        int num = 1;
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] truck = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            truck[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<w; i++){ // 큐에 공백 넣기
            que.offer(0);
        }
        // 초기값
        que.offer(truck[0]);
        weight += truck[0];
        while(!que.isEmpty()){
            time++;
            int t = que.poll();
            weight -= t;
            if(num < n && weight + truck[num] <= l){ // 하중 안에 들어간다면 큐에 넣고 무게 더하기
                que.offer(truck[num]);
                weight += truck[num];
                num++;
            }else if(num < n){ // 그게 아니면 0 추가
                que.offer(0);
            }
        }
        // 출력
        bw.write(time+"");
        bw.flush();
    }
}