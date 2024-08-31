/*
    1. 다익스트라 문제이다.
        - 단방향 그래프에서 X노드에서 다른 노드와의 거리 구하기
        - 거리가 K가 된다면 저장
    2. 첫째 줄에 도시의 개수 K, 도로의 개수 M, 거리 정보 K, 출발 도시의 번호 X가 주어짐
        - 둘째 줄부터 M개의 줄에 도로의 정보가 주어진다
        - A -> B
    3. X로부터 출발하여 도달하는 도시 중에 최단 거리가 K인 도시 return
        - 오름차순
        - 단 존재하지 않으면 -1 return
* */

import java.io.*;
import java.util.*;

class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] dist;
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        // 도로 정보 입력
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int fNum = Integer.parseInt(st.nextToken());
            int sNum = Integer.parseInt(st.nextToken());
            graph.get(fNum).add(sNum);
        }
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[X] = 0;
        dijkstra(X);
        List<Integer> ans = new ArrayList<>();
        for(int i=1; i<=N; i++){
            if(dist[i] == K){
                ans.add(i);
            }
        }
        if(ans.isEmpty()){
            bw.write("-1");
        }else{
            for(int i=0; i<ans.size(); i++){
                bw.write(ans.get(i)+"\n");
            }
        }
        // 출력
        bw.flush();
    }
    public static void dijkstra(int start){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(start);
        while(!pq.isEmpty()){
            int cur = pq.poll();
            for(int i=0; i<graph.get(cur).size(); i++){
                int temp = dist[cur] + 1;
                int next = graph.get(cur).get(i);
                if(dist[next] > temp){
                    dist[next] = temp;
                    pq.offer(next);
                }
            }
        }
    }
}