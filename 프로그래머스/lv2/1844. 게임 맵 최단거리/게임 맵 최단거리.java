/*
    1. 최단 거리 구하기 (bfs로 접근)
    2. 진행 할 때마다 +1해서 도착지에 값이 최단 거리 값
*/
import java.util.*;
class Solution {
    // 방향 벡터
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0 ,1, 0};
    // bfs
    void bfs(int x, int y, int[][] maps){
        Queue<int[]> que = new LinkedList();
        que.offer(new int[] {x,y});
        //큐에 값이 없을 때까지
        while(!que.isEmpty()){
            x = que.peek()[0];
            y = que.peek()[1]; 
            que.poll();
            for(int i=0; i<4; i++){
                int cx = x + dx[i];
                int cy = y + dy[i];
                if(cx>=0 && cy>=0 && cx<maps.length && cy < maps[0].length){
                    if(maps[cx][cy] == 1){
                        maps[cx][cy] = maps[x][y]+1;
                        que.offer(new int[] {cx,cy});
                    }
                }
            }

        }
    }
    public int solution(int[][] maps) {
        // bfs 실행
        bfs(0,0,maps);
        // 도착지가 최단거리 값

        return maps[maps.length-1][maps[0].length-1] == 1 ? -1 : maps[maps.length-1][maps[0].length-1];
    }
}