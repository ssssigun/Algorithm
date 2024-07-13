/*
    1. bfs로 풀 수 있을 것 같다
        - 그래프로 연결
        - 1이면 큐에 넣기
        - 인접한 곳 돌기
        - 방문 처리 필수
    2. 첫째 줄에 상근이의 동기수 n
        - 둘째 줄엔 리스트의 길이 m
        - 다음 줄부터 친구 관계
    3. 상근이의 결혼식에 초대하는 동기의 수 return
* */

import java.io.*;
import java.util.*;

class Main {
    static int ans = 0;
    static boolean[] visited; // 방문 처리 배열
    static List<List<Integer>> graph = new ArrayList<>(); // 그래프 정보 리스트
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        StringTokenizer st;
        for(int i=0; i<m; i++){ // 간선 정보
            st = new StringTokenizer(br.readLine());
            int fNum = Integer.parseInt(st.nextToken());
            int sNum = Integer.parseInt(st.nextToken());
            graph.get(fNum).add(sNum);
            graph.get(sNum).add(fNum);
        }
        // bfs로 친구와 친구의 친구 찾기
        bfs();
        // 출력
        bw.write(ans+"");
        bw.flush();
    }
    public static void bfs(){
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{1,0});
        visited[1] = true;
        while(!que.isEmpty()){
            int node = que.peek()[0];
            int depth = que.peek()[1];
            que.poll();
            if(depth == 2){
                return;
            }
            for(int i=0; i<graph.get(node).size(); i++){
                int next = graph.get(node).get(i);
                if(!visited[next]){
                    que.offer(new int[]{next, depth + 1});
                    visited[next] = true;
                    ans++;
                }
            }
        }
    }
}