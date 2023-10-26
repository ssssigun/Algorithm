/*
    1. 이중 리스트로 그래프 모양 만들고 bfs로 구하기
    2. 입력은 노드의 개수 n, 간선의 정보가 담인 배열 vertex 
    3. 1번 노드에서 가장 멀리 떨어진 노드의 갯수 return
*/
import java.util.*;
class Solution {
    // 그래프
    static List<List<Integer>> graph = new ArrayList();
    // 방문 처리 겸 거리저장 배열
    static int[] visited;
    // 마지막에 방문한 노드 거리 저장 (이게 가장 먼 거리노드임)
    static int dis = 0;
    // dfs
    static void bfs(int num){
        Queue<Integer> que = new LinkedList();
        que.offer(num);
        while(!que.isEmpty()){
            int node = que.poll();
            for(int i=0; i<graph.get(node).size(); i++){
                int nextNode = graph.get(node).get(i);
                if(visited[nextNode] == 0){
                    visited[nextNode] = visited[node]+1;
                    que.offer(nextNode);
                    dis = visited[nextNode];
                }
            }
        }
    }
    public int solution(int n, int[][] edge) {
        int answer = 0;
        // 배열 및 리스트 초기화
        visited = new int[n+1];
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList());
        }
        // 간선의 정보 그래프에 저장
        for(int i=0; i<edge.length; i++){
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }
        // 1번 노드부터의 거리 구하고 저장
        bfs(1);
        // 2번 노드부터 먼 거리 노드 갯수 저장
        for(int i=2; i<visited.length; i++){
            if(dis == visited[i]){
                answer++;
            }
        }
        return answer;
    }
}