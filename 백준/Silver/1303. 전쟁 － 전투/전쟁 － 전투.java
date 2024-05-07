import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    1. bfs 문제이다
        - 방향은 4방향으로 확인
        - 인접한 병사의 n^2을 해서 더해준다.
    2. 첫째 줄엔 전쟁터의 가로 크기 N, 세로 크기 M
        - 둘째 줄부터 병사들의 옷 색깔이 주어짐
    3. 우리 병사의 위력과 상대 병사의 위력을 return
* */
class Main {
    static int[] dx = {0, 1, 0, -1}; // 방향 벡터
    static int[] dy = {1, 0, -1, 0};
    static int N; // 가로 길이
    static int M; // 세로 길이
    static char[][] arr; // 전쟁터 배열
    static boolean[][] visited; // 방문 처리 배열
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int myTeam = 0;
        int enemyTeam = 0;
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[M][N];
        visited = new boolean[M][N];
        for(int i=0; i<M; i++){
            String temp = br.readLine();
            for(int j=0; j<N; j++){
                arr[i][j] = temp.charAt(j);
            }
        }
        // 세력 계산하기
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    if(arr[i][j] == 'W'){ // 우리팀 세력
                        myTeam += (int) Math.pow(bfs(i,j,'W'),2);
                    }else{ // 상대팀 세력
                        enemyTeam += (int) Math.pow(bfs(i,j,'B'),2);
                    }
                }
            }
        }
        // 출력
        bw.write(myTeam + " " + enemyTeam);
        bw.flush();
    }
    // bfs
    public static int bfs(int x, int y, char s){
        Queue<int[]> que = new LinkedList<>();
        int cnt = 1;
        que.offer(new int[]{x,y});
        visited[x][y] = true;
        while(!que.isEmpty()){
            x = que.peek()[0];
            y = que.peek()[1];
            que.poll();
            for(int i=0; i<4; i++){
                int cx = x + dx[i];
                int cy = y + dy[i];
                if(cx>=0 && cx<M && cy>=0 && cy<N && !visited[cx][cy] && arr[cx][cy] == s){
                    cnt++;
                    visited[cx][cy] = true;
                    que.offer(new int[]{cx,cy});
                }
            }
        }
        return cnt;
    }
}