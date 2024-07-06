/*
    1. 바다에 잠겨야함
        - 가장 작은 직사각형으로 만들기
            - 프린트할 때 범위 저장해서 출력
        - 지도가 벗어나는 곳은 바다인 것을 유의
    2. 첫째 줄에 지도의 크기 R C
    3. 50년 후 지도의 변화 return
* */

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<int[]> que = new LinkedList<>();
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int minX = Integer.MAX_VALUE;
        int maxX = 0;
        int minY = Integer.MAX_VALUE;
        int maxY = 0;
        char[][] map = new char[R][C];
        for(int i=0; i<R; i++){
            String temp = br.readLine();
            for(int j=0; j<C; j++){
                map[i][j] = temp.charAt(j);
            }
        }
        // 순회하면서 변경하기
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                int cnt = 0;
                if(map[i][j] == 'X'){
                    for(int k=0; k<4; k++){
                        int cx = i + dx[k];
                        int cy = j + dy[k];
                        if(cx<0 || cy<0 || cx>=R || cy>=C || map[cx][cy]=='.'){
                            cnt++;
                        }
                    }
                    if(cnt >= 3){ // 삼면이 바다이면 바다로 변경
                        que.offer(new int[]{i,j});
                    }else{ // 그게 아니면 좌표 확인하고 저장
                        maxX = Math.max(maxX, i);
                        maxY = Math.max(maxY, j);
                        minX = Math.min(minX, i);
                        minY = Math.min(minY, j);
                    }
                }
            }
        }
        // 바다로 변경
        while(!que.isEmpty()){
            int x = que.peek()[0];
            int y = que.peek()[1];
            que.poll();
            map[x][y] = '.';
        }
        // 출력하기
        for(int i=minX; i<=maxX; i++){
            for(int j=minY; j<=maxY; j++){
                bw.write(map[i][j]+"");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}