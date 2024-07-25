/*
    1. 플로이드 워셜로 풀기
        - 플로이드 워셜로 거리 먼저 구하기
        - 서로에게 가는 곳이 있으면 사이클이 있으므로 최솟값 return
            - graph[a][b] != INF && graph[b][a] != INF
    2. 첫째 줄에 노드 V, 간선 E
        - 그 이후 출발지 a, 도착지 b, 거리 c E개 (단방향 노드)
    3. 최소 사이클의 도로 값 return
        - 불가능한 경우 -1
* */

import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int[][] arr = new int[V+1][V+1];
        final int max = 100000000;
        for(int i=1; i<=V; i++){
            for(int j=1; j<=V; j++){
                if(i != j){
                    arr[i][j] = max;
                }
            }
        }
        for(int i=0; i<E; i++){ // 간선 정보 입력
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arr[start][next] = cost;
        }
        // 플로이드 워셜로 최소 거리 구하기
        for(int k=1; k<=V; k++){
            for(int i=1; i<=V; i++){
                for(int j=1; j<=V; j++){
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }
        int ans = max; // 사이클의 최소 거리 값
        // 사이클이 있는 지 확인
        for(int i=1; i<=V; i++){
            for(int j=1; j<=V; j++){
                if(i != j && arr[i][j] != max && arr[j][i] != max){
                    ans = Math.min(ans, arr[i][j] + arr[j][i]);
                }
            }
        }
        // 출력
        bw.write((ans == max ? -1 : ans)+"");
        bw.flush();
    }
}