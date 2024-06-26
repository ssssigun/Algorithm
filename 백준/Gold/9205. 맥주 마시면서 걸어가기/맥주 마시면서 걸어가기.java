/*
    1. bfs로 접근해야할 것 같다.
        - 배열로 만들면 최악의 경우 10억이 넘을 것 같다 (시간 초과)
        - 편의점과 목적지 배열을 돌면서 1000이하이면 큐에 넣기
    2. 첫째 줄엔 테스트 케이스의 수 t
       - 각 케이스의 첫째 줄엔 편의점의 개수 n
       - 이후 좌표가 주어짐 n+2개
    3. 도달하면 happy, 도달하지 못하면 sad return
* */

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int[][] arr;
    static boolean[] visited; // 방문처리 배열
    static boolean flag = false;
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        // 입력 받기
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){ // 테스트 갯수만큼 시작
            int n = Integer.parseInt(br.readLine()); // 편의점 개수
            flag = false;
            visited = new boolean[n+3];
            arr = new int[n+3][2];
            for(int j=1; j<=n+2; j++){ // 좌표 정보 입력
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[j][0] = Integer.parseInt(st.nextToken());
                arr[j][1] = Integer.parseInt(st.nextToken());
            }
            bfs(1, n+2);
            if(flag){
                sb.append("happy\n");
            }else{
                sb.append("sad\n");
            }
        }
        // 출력
        bw.write(sb.toString());
        bw.flush();
    }
    // 거리 계산 함수
    public static int calD(int x1, int y1, int x2, int y2){
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
    public static void bfs(int start, int fin){
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        visited[start] = true;
        while(!que.isEmpty()){
            int node = que.poll();
            if(node == fin){ // 목적지에 도착하면 종료
                flag = true;
                return;
            }
            for(int i=0; i<arr.length; i++){
                if(!visited[i] && calD(arr[node][0],arr[node][1],arr[i][0],arr[i][1]) <= 1000){
                    que.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}