/*
    1. 트리 구조로 된 송전탑 구조, 연결을 하나 끊어 두개로 만들기
    2. 송전탑(node)의 개수 n, 전선의 정보(edge) wires 배열
    3. 두 전력망으로 나눴을 때 차이가 최소가 되는 값 return
    4. 간선 정보를 하나씩 빼면서 bfs를 활용해 전력망 차이 비교해서 return
        - 제한 숫자가 별로 크지 않아서 가능할 것 같음
*/
import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int ans = Integer.MAX_VALUE;
        // 간선 하나씩 빼면서 계산
        for(int i=0; i<wires.length; i++){
            List<List<Integer>> tree = new ArrayList(); // 트리 배열
            for(int j=0; j<=n; j++){
                tree.add(new ArrayList());
            }
            boolean[] visited = new boolean[n+1]; // 방문 처리 배열
            // 간선 정보 추가
            for(int j=0; j<wires.length; j++){
                if(i == j) continue;
                int fNum = wires[j][0];
                int sNum = wires[j][1];
                tree.get(fNum).add(sNum);
                tree.get(sNum).add(fNum);
            }
            int v1 = bfs(tree, visited, 1);
            int v2 = Math.abs(v1-n);
            int m = Math.abs(v1 - v2);
            if(m < ans){
                ans = m;
            }
        }
        return ans;
    }
    // bfs
    public static int bfs(List<List<Integer>> tree, boolean[] visited, int start){
        Queue<Integer> que = new LinkedList();
        que.offer(start);
        int cnt = 1;
        visited[start] = true;
        while(!que.isEmpty()){
            start = que.poll();
            for(int i=0; i<tree.get(start).size(); i++){
                int next = tree.get(start).get(i);
                if(!visited[next]){
                    cnt++;
                    visited[next] = true;
                    que.offer(next);
                }
            }
        }
        return cnt;
    }
}