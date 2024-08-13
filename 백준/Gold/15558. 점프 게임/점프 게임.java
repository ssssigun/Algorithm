/*
    1. bfs 문제인 듯하다.
        - 이동 가능한지 확인하고 이동할 위치를 큐에 넣고 이동
            - 배열 안이면서, 이동 위치에 값이 1이여야 함
        - 초도 같이 기록하기.
            - 기록된 초보다 작으면 이동 x
        - N보다 크게 되면 종료
    2. 첫째 줄에 배열의 크기 N과 이동 거리 K
        - 둘째 줄과 셋째 줄엔 배열이 주어짐
            - 1은 이동 가능
            - 0은 이동 불가
    3. 클리어 가능하면 1, 불가능하면 0 return
* */

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Position{
    int x;
    int y;
    int sec;
    Position(int x, int y, int sec){
        this.x = x;
        this.y = y;
        this.sec = sec;
    }
}
class Main {
    static int K;
    static int[][] arr;
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[2][N];
        for(int i=0; i<2; i++){
            String temp = br.readLine();
            for(int j=0; j<temp.length(); j++){
                arr[i][j] = temp.charAt(j) - '0';
            }
        }
        // 출력
        bw.write(bfs(N));
        bw.flush();
    }
    public static String bfs(int N){
        boolean[] dx = {false, false, true};
        int[] dy = {1, -1, K};
        Queue<Position> que = new LinkedList<>();
        que.offer(new Position(0,0, 0));
        arr[0][0] = 0; // 방문 처리
        while(!que.isEmpty()){
            Position p = que.poll();
            for(int i=0; i<3; i++){ // 이동
                int cx = p.x;
                if(dx[i]){ // 옆 배열로 넘어갈 때
                    if(cx == 0){
                        cx = 1;
                    }else{
                        cx = 0;
                    }
                }
                int cy = p.y + dy[i];
                if(cy >= N){ // 목적지에 도달했으면 1 return
                    return "1";
                }else if(cy>=0 && cy>p.sec && arr[cx][cy] == 1){
                    que.offer(new Position(cx, cy, p.sec+1));
                    arr[cx][cy] = 0;
                }
            }
        }
        return "0";
    }
}