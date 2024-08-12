/*
    1. 구현?(자료구조) 문제인 것 같다.
        - 이중 순위큐를 두개 사용해서 풀기
        - 석순(아래)과 종유석(위)를 각각의 이중 순위 큐에 넣는다.
        - 석순은 오름차순, 종유석은 내림차순 순서대로 정렬
        - 높이만큼 반복문 실행
            - 석순이 높이보다 낮다면 pop
            - (h - 종류석의 높이) < 현재 높이 라면 pop하고 cnt++
            - 이후 석순의 큐 크기와 cnt를 더한 값이 높이의 값
        - 최솟값이면 갱신
        - 같으면 추가
    2. 첫째 줄에 길이 N과 높이 H가 주어짐
        - 이후 N개의 줄엔 높이가 주어진다.
    3. 파괴하며 지나가야하는 장애물의 최소값과 그 구간의 수를 return
* */

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq1 = new PriorityQueue<>((o1, o2) -> {return o1 - o2;}); // 석순
        PriorityQueue<Integer> pq2 = new PriorityQueue<>((o1, o2) -> {return o2 - o1;}); // 종류석
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        for(int i=0; i<N/2; i++){
            pq1.offer(Integer.parseInt(br.readLine()));
            pq2.offer(Integer.parseInt(br.readLine()));
        }
        int cnt = 0;
        int min = Integer.MAX_VALUE;
        int minCnt = 0;
        for(int i=1; i<=H; i++){
            while(!pq1.isEmpty() && pq1.peek() < i){ // 석순 확인 (높이 보다 낮으면 빼기)
                pq1.poll();
            }
            while(!pq2.isEmpty() && (H -pq2.peek()) < i){ // 종유석 확인
                pq2.poll();
                cnt++;
            }
            int height = cnt + pq1.size(); // 석순 + 종유석이 닿는 값이 현재 높이에서 장애물을 부시는 값
            if(min > height){ // 최솟값 저장
                min = height;
                minCnt = 1;
            }else if(min == height){ // 같으면 개수세기
                minCnt++;
            }
        }
        // 출력
        bw.write(min+" "+minCnt);
        bw.flush();
    }
}