/*
    1. 최단 거리 구하기 bfs
        - 처음에 max값이 담긴 배열 생성
        - 배열 입력을 받아서 목표 지점 저장, 0의 위치는 0으로 초기화
        - 목표 지점에서 시작하여 거리를 구한다.
            - 최솟값이면 갱신
        - 마지막에 배열 전체를 확인하면서 도달하지 못한 값(Max)이면 -1
    2. 첫째 줄엔 지도의 크기 n과 m
        - 이후 n개의 줄에 m개의 숫자가 주어짐
        - 0 이동불가, 1 이동 가능, 2 목표지점
    3. 각 지점에서 목표 지점까지의 거리 return
        - 원래 이동 불가능이면 0
        - 이동 가능하지만 도달하지 못한다면 -1
* */

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        // 배열 생성
        arr = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            Arrays.fill(arr[i], Integer.MAX_VALUE);
        }
        int[] start = new int[2];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 2){
                    arr[i][j] = 0;
                    start[0] = i;
                    start[1] = j;
                    visited[i][j] = true;
                }else if(temp == 0){
                    arr[i][j] = 0;
                    visited[i][j] = true;
                }
            }
        }
        bfs(start);
        // 출력
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j] == Integer.MAX_VALUE){
                    bw.write("-1 ");
                }else{
                    bw.write(arr[i][j]+" ");
                }
            }
            bw.write("\n");
        }
        bw.flush();
    }
    public static void bfs(int[] s){
        Queue<int[]> que = new LinkedList<>();
        que.offer(s);
        while(!que.isEmpty()){
            int[] n = que.poll();
            for(int i=0; i<4; i++){
                int cx = n[0] + dx[i];
                int cy = n[1] + dy[i];
                if(cx>=0 && cy>=0 && cx<arr.length && cy<arr[0].length){
                    if(!visited[cx][cy]){
                        visited[cx][cy] = true;
                        arr[cx][cy] = arr[n[0]][n[1]] + 1;
                        que.offer(new int[]{cx, cy});
                    }
                }
            }
        }
    }
}