/*
    1. 최단 거리 구하기 bfs 문제이다.
        - 먼저 레버를 찾아야함
        - 레버를 찾고 출입구로 이동
    2. 미로를 나타낸 문자열 maps
    3. 최소 시간을 return
        - 탈출하지 못한다면 -1
*/
import java.util.*;
class Solution {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] visited;
    static boolean flag = false;
    public int solution(String[] maps) {
        int answer = 0;
        visited = new int[maps.length][maps[0].length()];
        int[] start = new int[2];
        int[] end = new int[2];
        for(int i=0; i<maps.length; i++){ // 시작점과 도착지 구하기
            if(maps[i].contains("S")){ // 시작지
                start[0] = i;
                start[1] = maps[i].indexOf("S");
            }
            if(maps[i].contains("E")){ // 도착지
                end[0] = i;
                end[1] = maps[i].indexOf("E");
            }
        }
        bfs(start[0], start[1], maps); // bfs 실행

        // 0이면 도착하지 못해서 -1
        if(!flag){
            return -1;
        }
        return visited[end[0]][end[1]] == 0 ? -1 : visited[end[0]][end[1]];
    }
    public static void bfs(int x, int y, String[] maps){
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{x,y});
        
        while(!que.isEmpty()){
            x = que.peek()[0];
            y = que.peek()[1];
            que.poll();
            if(!flag && maps[x].charAt(y) == 'L'){ // 레버에 도착했으면 거리값 초기화
                int temp = visited[x][y];
                flag = true;
                while(!que.isEmpty()){
                    que.poll();
                }
                visited = new int[maps.length][maps[0].length()];
                visited[x][y] = temp;
            }
            for(int i=0; i<4; i++){
                int cx = x + dx[i];
                int cy = y + dy[i];
                if(cx>=0 && cy>=0 && cx<maps.length && cy<maps[0].length()){
                    if(maps[cx].charAt(cy) != 'X' && visited[cx][cy] == 0){
                        visited[cx][cy] = visited[x][y] + 1;
                        que.offer(new int[]{cx, cy});
                    }
                }
            }
        }
    }
}