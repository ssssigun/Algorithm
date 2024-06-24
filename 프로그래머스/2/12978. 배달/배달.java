/*
    1. 다익스트라 문제인 것 같다.
        - 한 노드에서 여러 노드의 최단 거리 구하기
        - 최단 거리를 구해서 본인 포함 K 이하이면 카운트
    2. 마을의 갯수 N
        - 도로의 정보 road [도로1, 도로2, 도로의 길이]
        - 음식 배달이 가능한 시간 K
    3. 주문 받을 수 있는 마을의 개수 return
*/

import java.util.*;
class Road implements Comparable<Road>{ // 도로 객체
    int v;
    int l;
    Road(int v, int l){
        this.v = v;
        this.l = l;
    }
    @Override
    public int compareTo(Road o1){ // 비교함수 (우선 순위 큐 사용을 위함)
        return this.l - o1.l;
    }
}
class Solution {
    public static List<List<Road>> list = new ArrayList<>();
    public static int[] dp;
    public static boolean[] visited;
    public int solution(int N, int[][] road, int K) {
        int ans = 0; // 정답
        for(int i=0; i<=N; i++){ // 노드 배열 초기화
            list.add(new ArrayList());
        }
        
        dp = new int[N+1]; // dp 배열 초기화
        visited = new boolean[N+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        for(int i=0; i<road.length; i++){ // 노드에 값 추가
            int n1 = road[i][0];
            int n2 = road[i][1];
            int leng = road[i][2];
            list.get(n1).add(new Road(n2, leng)); // 양방향이므로 양쪽에 추가
            list.get(n2).add(new Road(n1, leng));
        }
        
        dijkstra(); // 다익스트라로 최단 노드 구하기
        
        for(int i : dp){ // 배달 가능한 마을 갯수 구하기
            if(i <= K){
                ans++;
            }
        }
        return ans;
    }
    // 다익스트라로 최단 거리 구하기
    public static void dijkstra(){
        PriorityQueue<Road> pq = new PriorityQueue<>();
        pq.offer(new Road(1, 0));
        dp[1] = 0;
        while(!pq.isEmpty()){
            Road r = pq.poll();
            
            if(visited[r.v]){
                continue;
            }
            visited[r.v] = true;
            for(Road road : list.get(r.v)){
                if(dp[road.v] > r.l + road.l){
                    dp[road.v] = r.l + road.l;
                    pq.offer(new Road(road.v, dp[road.v]));
                }
            }
        }
    }
}