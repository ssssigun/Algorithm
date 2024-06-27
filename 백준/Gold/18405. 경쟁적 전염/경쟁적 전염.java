/*
    1. bfs를 활용하지만 일반 큐가 아닌 우선 순위 큐를 활용
        - 낮은 바이러스가 먼저 퍼지기 때문
    2. 첫째 줄에 시험관 크기 N, 바이러스의 종류 K
        - 둘째 줄 N줄까지 부터 바이러스의 정보
        - 마지막 줄에 시간 S, 확인할 좌표 X, Y
    3. S초가 지났을 때 X,Y에 위치한 바이러스의 종류 return
* */

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
class Virus implements Comparable<Virus>{
    int type; // 바이러스 종류
    int x;
    int y;
    int time; // 생성된 시간
    Virus(int type, int x, int y, int time){
        this.type = type;
        this.x = x;
        this.y = y;
        this.time = time;
    }
    @Override
    public int compareTo(Virus o1){ // 낮은 종류의 바이러스 순서
        return this.time == o1.time ? this.type - o1.type : this.time - o1.time;
    }
}

class Main {
    static int[][] map;
    static int S;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 시험관 크기 N x N
        int K = Integer.parseInt(st.nextToken()); // 바이러스 종류
        map = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken()); // 시간 확인 S
        int X = Integer.parseInt(st.nextToken()); // 마지막 좌표 확인 위치 X
        int Y = Integer.parseInt(st.nextToken()); // 마지막 좌표 확인 위치 Y
        // bfs 실행
        bfs();
        // 출력
        bw.write(map[X][Y]+"");
        bw.flush();
    }
    // bfs
    public static void bfs(){
        PriorityQueue<Virus> pq = new PriorityQueue<>();
        for(int i=1; i<map.length; i++){ // 초기값 생성
            for(int j=1; j<map[0].length; j++){
                if(map[i][j] != 0){
                    pq.offer(new Virus(map[i][j], i, j, 0));
                }
            }
        }
        while(!pq.isEmpty()){
            Virus v = pq.poll();
            if(v.time == S){ // S초가 지났으면 나가기
                return;
            }
            for(int i=0; i<4; i++){
                int cx = v.x + dx[i];
                int cy = v.y + dy[i];
                if(cx>=1 && cy>=1 && cx<map.length & cy<map.length && map[cx][cy] == 0){
                    map[cx][cy] = v.type;
                    pq.offer(new Virus(v.type, cx, cy, v.time+1));
                }
            }
        }
    }
}