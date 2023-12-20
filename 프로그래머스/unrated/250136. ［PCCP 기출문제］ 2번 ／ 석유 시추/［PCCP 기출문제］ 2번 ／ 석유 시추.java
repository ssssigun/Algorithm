/*
    1. 세로 n, 가로 m, 땅배열 land (석유 1, 빈칸 0)
    2. 수직으로 뚫었을 때 많은 석유양를 뽑을 수 있도록 return
    3. dfs나 bfs를 활용
    ** 완전 탐색 bfs로 푸니 시간 초과가 나왔음
        - 석유를 먼저 bfs로 그룹화해서 풀기
*/
import java.util.*;
class Solution {
    // 방향 벡터
    static int[] dx = { 1, 0, -1, 0};
    static int[] dy = { 0, -1, 0, 1};
    // 정답 
    static int answer = 0;
    // 라벨링
    static int label = 2;
    static Map<Integer, Integer> map = new HashMap();
    // 방문처리 배열
    static boolean[] visited;
    
    public int solution(int[][] land) {
        // 가로 세로 크기
        int n = land.length;
        int m = land[0].length;
        // 석유 그룹화하기
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(land[i][j] == 1){
                    bfs(i, j, land);
                    label++;
                }
            }
        }
        // 석유 시추
        for(int i=0; i<m; i++){
            int total = 0;
            visited = new boolean[label+1];
            for(int j=0; j<n; j++){
                int t = land[j][i];
                if(t != 0 && !visited[t]){
                    total += map.get(land[j][i]);
                    visited[t] = true;
                }
            }
            if(total > answer){
                answer = total;
            }
        }
        return answer;
    }
    // bfs  
    static void bfs(int x, int y, int[][] land){
        Queue<int[]> que = new LinkedList();
        int cnt = 0;
        que.offer(new int[] {x, y});
        land[x][y] = label;
        cnt++;
        
        while(!que.isEmpty()){
            x = que.peek()[0];
            y = que.peek()[1];
            que.poll();
            for(int i=0; i<4; i++){
                int cx = x + dx[i];
                int cy = y + dy[i];
                if(cx>=0 && cy>=0 && cx<land.length && cy<land[0].length){
                    if(land[cx][cy] == 1){
                        // 방문처리
                        land[cx][cy] = label;
                        // 추가
                        que.offer(new int[]{cx, cy});
                        cnt++;
                    }
                }
            }
        }
        map.put(label, cnt);
    }
}