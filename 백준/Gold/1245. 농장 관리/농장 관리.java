/*
    1. N x M 농장에 경비원 배치하기
        - 산봉우리는 인접한 수의 집합
        - 단 주변보다는 높이가 높아야한다.
    2. 첫째 줄에 N과 M이 주어진다.
        - 둘째 줄부터 높이가 주어짐
    3. 산봉우리의 개수 return
* */

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 방향 벡터
    public static int[] dx = {1, 1, 0,-1,-1,-1, 0, 1};
    public static int[] dy = {0,-1,-1,-1, 0, 1, 1, 1};
    public static int[][] map; // 농장
    public static boolean[][] visited; // 방문처리 배열
    public static int ans = 0; // 정답
    public static void main(String[] args) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 산봉우리 찾기
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visited[i][j]){
                    bfs(i,j);
                }
            }
        }
        // 출력
        bw.write(ans+"");
        bw.flush();
    }
    // bfs
    public static void bfs(int x, int y){
        Queue<int[]> que = new LinkedList();
        que.offer(new int[]{x,y});
        String temp = x+" "+y;
        visited[x][y] = true;
        boolean ch = false;
        while(!que.isEmpty()){
            x = que.peek()[0];
            y = que.peek()[1];
            que.poll();
            // 주변보다 높은지 확인
            if(!check(x,y)){
                ch = true;
            }
            // 같은 크기 봉우리 찾기
            for(int i=0; i<dx.length; i++){
                int cx = x + dx[i];
                int cy = y + dy[i];
                if(cx>=0 && cy>=0 && cx < map.length && cy < map[0].length){
                    if(!visited[cx][cy] && map[cx][cy] == map[x][y]){
                        que.offer(new int[]{cx,cy});
                        visited[cx][cy] = true;
                    }
                }
            }
        }
        if(!ch){
            ans++;
        }
    }
    public static boolean check(int x, int y){
        for(int i=0; i<dx.length; i++){
            int cx = x + dx[i];
            int cy = y + dy[i];
            if(cx>=0 && cy>=0 && cx < map.length && cy < map[0].length){
                if(map[x][y] < map[cx][cy]){ //자신보다 큰 봉우리가 있으면 false
                    return false;
                }
            }
        }
        return true;
    }

}
