/*
    1. 방문 처리 함수로 이중 for문을 돌며 확인하면 될 것 같다.
    2. dfs, bfs 둘 다 사용 가능 할 것 같다.
    3. 노드의 갯수 n, 관계가 computers로 주어진다.
    4. 네트워크 수를 return
*/
import java.util.*;
class Solution {
    // 방문 처리 배열
    public static boolean[] visited;
    // bfs
    public static void bfs(int num, int[][] computers){
        Queue<Integer> que = new LinkedList();
        que.offer(num);
        visited[num+1] = true;
        while(!que.isEmpty()){
            num = que.poll();
            for(int i=0; i<computers[num].length; i++){
                // 자기 자신 skip
                if(i == num){
                // 관계가 있으면 que에 넣기
                }else if(computers[num][i] == 1 && !visited[i+1]){
                    que.offer(i);
                    visited[i+1] =true;
                }
            }
        }
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        // 그래프 및 방문 배열 초기화
        visited = new boolean[n+1];
        // bfs로 네크워크 갯수 찾기
        for(int i=0; i<n; i++){
            // 방문 하지 않았으면 bfs 실행
            if(!visited[i+1]){
                bfs(i, computers); 
                answer++;
            }
        }
        return answer;
    }
}