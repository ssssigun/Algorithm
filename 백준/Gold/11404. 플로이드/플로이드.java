/*
    1. 플로이드 워셜 연습 문제
        - 단방향 노드로 계산
        - dist배열에 본인 위치 0, 나머지를 최대값으로 채움
        - 돌면서 최솟값 구하기
    2. 첫째 줄에 노드의 갯수 N
        - 둘째 줄엔 간선의 개수 M
        - 그 이후 간선의 정보
            - 시작 도시 a, 도착 도시 b, 거리 c
    3. 각 줄 i에 i번째 도시와 다른 도시의 거리 출력
        - dist 배열 return
* */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
class Node{
    int end;
    int distance;
    Node(int end, int distance){
        this.end = end;
        this.distance = distance;
    }
}
class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int MAX = 10000001;
        // 입력 받기
        StringTokenizer st;
        List<List<Node>> graph = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M ; i++){ // 간선 정보 입력
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int dis = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(end, dis));
        }

        // 기본값 넣기
        int[][] dist = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(i == j){
                    dist[i][j] = 0;
                }else{
                    dist[i][j] = MAX;
                }
            }
        }
        // 초기값 초기화
        for(int i=0; i<N; i++){
            for(int j=0; j<graph.get(i).size(); j++){
                Node n = graph.get(i).get(j);
                dist[i][n.end] = Math.min(dist[i][n.end], n.distance);
            }
        }
        // 플로이드 와셜 시작
        for(int k=0; k<N; k++){
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(dist[i][j] > dist[i][k] + dist[k][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        // 출력
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                bw.write((dist[i][j] == MAX ? 0 : dist[i][j])+" ");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}