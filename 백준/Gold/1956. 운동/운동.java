/*
    1. 다익스트라로 구하기
        - N개의 노드에 대해서 다익스트라 확인
        - 자기 자신한테 돌아온다면 최솟값과 비교에서 저장
    2. 첫째 줄에 노드 V, 간선 E
        - 그 이후 출발지 a, 도착지 b, 거리 c E개 (단방향 노드)
    3. 최소 사이클의 도로 값 return
        - 불가능한 경우 -1
* */

import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int n;
    int cost;
    Node(int n, int cost){
        this.n = n;
        this.cost = cost;
    }
    @Override
    public int compareTo(Node o1){
        return this.cost - o1.cost;
    }
}
class Main {
    static List<List<Node>> graph = new ArrayList<>(); // 단방향 그래프
    static int[][] dist;
    static int ans = Integer.MAX_VALUE; // 사이클의 최소 거리 값
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        for(int i=0; i<=V; i++){ // 노드 생성
            graph.add(new ArrayList<>());
        }
        dist = new int[V+1][V+1];
        for(int i=1; i<=V; i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }

        for(int i=0; i<E; i++){ // 간선 정보 입력
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(next, cost));
        }

        for(int i=1; i<=V; i++) { // 전체 노드를 돌면서 사이클 확인, 사이클이면 최솟값 반환
            dijkstra(i);
        }
        for(int i=1; i<=V; i++){
            for(int j=1; j<=V; j++){
                if(i == j){
                    ans = Math.min(ans, dist[i][j]);
                }
            }
        }
        // 출력
        bw.write((ans == Integer.MAX_VALUE ? -1 : ans)+"");
        bw.flush();
    }
    public static void dijkstra(int n){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(n, 0));

        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(dist[n][now.n] < now.cost){
                continue;
            }
            for(int i=0; i<graph.get(now.n).size(); i++){
                Node next = graph.get(now.n).get(i);

                if(dist[n][next.n] > now.cost + next.cost){
                    dist[n][next.n] = now.cost + next.cost;
                    pq.offer(new Node(next.n, dist[n][next.n]));
                }
            }
        }
    }
}