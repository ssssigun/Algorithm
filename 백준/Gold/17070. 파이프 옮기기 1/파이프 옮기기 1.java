import java.io.*;
import java.util.StringTokenizer;

/*
    1. 가로,세로 대각 상태 저장을 위해서 3차원 배열 사용
        - 기준은 끝에 위치로
        - 인덱스 값 0 : 가로, 1 : 세로, 2 : 대각
        - dfs로 진행하고 가로, 세로, 대각 상태를 확인하고 상태에 맞게 탐색 진행
        - bfs는 시간 초과가 났다.
    2. 첫째 줄에 집의 크기 N
        - 둘째 줄부터 집의 상태
        - 빈칸은 0, 벽은 1
    3. (N,N) 위치까지 이동하는 경우의 수
* */
class Main {
    static int N;
    static int[][] home; // 집 상태 배열
    static int cnt = 0; // 정답 (이동 방법의 수)
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        // 입력 받기
        N = Integer.parseInt(br.readLine());
        home = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                home[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if(home[N][N] == 1){ // 도착지가 막혀있는 경우는 예외처리
            bw.write("0");
            bw.flush();
            return;
        }
        // 파이프 옮기기
        dfs(1, 2, 0);
        // 출력
        bw.write(cnt+"");
        bw.flush();
    }
    // bfs
    public static void dfs(int x, int y, int dir){
        if(x == N & y == N){ // 도착하면 카운팅
            cnt++;
        }
        int[] dx;
        int[] dy;
        int cx;
        int cy;
        if(dir == 0){ // 가로일 때
            // 오른쪽 확인
            cx = x;
            cy = y + 1;
            if(cy>0 && cy<=N && home[cx][cy] == 0) { // 범위를 넘지 않으면서, 빈칸
                dfs(cx, cy, 0);
            }
            // 대각선 확인
            dx = new int[] {0, 1, 1};
            dy = new int[] {1, 1, 0};
            int t = 0;
            for(int i=0; i<3; i++){
                cx = x + dx[i];
                cy = y + dy[i];
                if(cx>0 && cx<=N && cy>0 && cy<=N && home[cx][cy] == 0){ // 범위를 넘지 않으면서, 빈칸이여야함
                    t++;
                }
            }
            if(t==3){ // 대각위치로 비어 있어야함
                dfs(x+1, y+1, 2);
            }

        }else if(dir == 1){ // 세로일 때
            // 아래 확인
            cx = x + 1;
            cy = y;
            if(cx>0 && cx<=N && home[cx][cy] == 0 ) { // 범위를 넘지 않으면서, 빈칸이여야함
                dfs(cx, cy, 1);
            }
            // 대각선 확인
            dx = new int[] {0, 1, 1};
            dy = new int[] {1, 1, 0};
            int t = 0;
            for(int i=0; i<3; i++){
                cx = x + dx[i];
                cy = y + dy[i];
                if(cx>0 && cx<=N && cy>0 && cy<=N && home[cx][cy] == 0){ // 범위를 넘지 않으면서, 빈칸이여야함
                    t++;
                }
            }
            if(t==3){ // 대각위치로 비어 있어야함
                dfs(x+1, y+1, 2);
            }

        }else if(dir == 2){ // 대각일 때
            // 오른쪽 확인
            cx = x;
            cy = y + 1;
            if(cy>0 && cy<=N && home[cx][cy] == 0) { // 범위를 넘지 않으면서, 빈칸
                dfs(cx, cy, 0);
            }
            // 아래 확인
            cx = x + 1;
            cy = y;
            if(cx>0 && cx<=N && home[cx][cy] == 0) { // 범위를 넘지 않으면서, 빈칸
                dfs(cx, cy, 1);
            }
            // 대각선 확인
            dx = new int[] {0, 1, 1};
            dy = new int[] {1, 1, 0};
            int t = 0;
            for(int i=0; i<3; i++){
                cx = x + dx[i];
                cy = y + dy[i];
                if(cx>0 && cx<=N && cy>0 && cy<=N && home[cx][cy] == 0){ // 범위를 넘지 않으면서, 빈칸이여야함
                    t++;
                }
            }
            if(t==3){ // 대각위치로 비어 있어야함
                dfs(x+1, y+1, 2);
            }
        }
    }
}