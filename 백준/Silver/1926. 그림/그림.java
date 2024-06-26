/*
    1. dfs 연습 문제
        - 배열을 순회 하면서 그림 개수 체크
        - 그림의 최대 개수도 체크
    2. 첫째 줄에 세로 n, 가로 m
        - 둘째 줄부터 그림의 정보
    3. 첫째 줄에 그림의 개수
        - 둘째 줄엔 최대 크기를 return
* */

import java.io.*;
import java.util.StringTokenizer;

class Main {
    static int cnt = 0;
    static int max = 0;
    static int tempCnt = 0;
    static int[] dx = {1, 0, -1, 0}; // 방향 벡터
    static int[] dy = {0, -1, 0, 1};
    static int[][] pic; // 그림 배열
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        pic = new int[n][m];
        for(int i=0; i<n; i++){ // 배열 입력 받기
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                pic[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<n; i++){ // 배열 순회하면서 그림이 있으면 크기 확인
            for(int j=0; j<m; j++){
                tempCnt = 0;
                if(pic[i][j] == 1){
                    dfs(i,j);
                    cnt++;
                }
                max = Math.max(tempCnt, max); // 최대값 변경
            }
        }
        // 출력
        bw.write(cnt+"\n");
        bw.write(max+"");
        bw.flush();
    }
    // dfs
    public static void dfs(int x, int y){
        pic[x][y] = 0; // 방문 처리
        tempCnt++;
        for(int i=0; i<4; i++){
            int cx = x + dx[i];
            int cy = y + dy[i];
            if(cx>=0 && cy>=0 && cx<pic.length && cy<pic[0].length && pic[cx][cy]==1){
                dfs(cx,cy);
            }
        }
    }
}