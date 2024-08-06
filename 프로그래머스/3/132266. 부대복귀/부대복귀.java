/*
    1. 다익스트라 or 플로이드 와셜문제이다.
        - destination 위치에서 각 노드의 최단 거리를 구한다. (다익스트라)
        - sources의 있는 위치까지의 최단 거리를 return
        - 리스트에 담아서 return
*/
import java.util.*;
class Solution {
    int[] dist;
    List<List<Integer>> graph = new ArrayList<>();
    boolean[] visited;
    public List<Integer> solution(int n, int[][] roads, int[] sources, int destination) {
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<=n; i++){ // 그래프 만들기
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<roads.length; i++){ // 그래프 간선 정보 저장
            graph.get(roads[i][0]).add(roads[i][1]);
            graph.get(roads[i][1]).add(roads[i][0]);
        }
        dist = new int[n+1]; // destination에서 배열 간의 거리
        Arrays.fill(dist, Integer.MAX_VALUE); // 최댓값으로 채움
        visited = new boolean[n+1]; // 방문 처리 배열
        
        dijkstra(destination); // destination에서 배열 간의 거리 찾기
        for(int i=0; i<sources.length; i++){ // destination에서 sources까지 거리 구하기
            ans.add(dist[sources[i]] == Integer.MAX_VALUE ? -1 : dist[sources[i]]); // max값이면 -1
        }
        return ans;
    }
    // 다익스트라 함수
    public void dijkstra(int des){
        PriorityQueue<int[]> pq = new PriorityQueue<>( (o1, o2) -> {return o1[1] - o2[1];}); // 우선순위 큐
        for(int i=0; i<graph.get(des).size(); i++){ // 초기값 생성
            int t = graph.get(des).get(i);
            dist[t] = 1;
        }
        dist[des] = 0; // 본인 값 0
        pq.offer(new int[]{des, 0}); // 초기값
        while(!pq.isEmpty()){
            int[] temp = pq.poll();

            for(int i=0; i<graph.get(temp[0]).size(); i++){
                int next = graph.get(temp[0]).get(i);
                if(!visited[next] && temp[1] + 1 <= dist[next]){
                    visited[next] = true;
                    dist[next] = temp[1] + 1;
                    pq.offer(new int[]{next, temp[1] + 1});
                }
            }
        }
    }
}