import java.io.*;
import java.util.*;

/*
    1. 다익스트라 연습 문제이다.
    2. 첫째 줄엔 도시의 개수 N
        - 둘째 줄엔 버스의 개수 M
        - 셋째 줄부터  M+2줄까지 버스의 정보 ( 출발 도시 번호, 도착 도시 번호, 버스 비용 )
        - 마지막 줄에 출발 도시와 도착 도시가 주어진다.
    3. 출발지부터 도착지로 이동할 때 버스비의 최소 비용 return
* */
class Area implements Comparable<Area>{
    int pos; // 도시 번호
    int cost; // 버스 비용
    Area(int pos, int cost){
        this.pos = pos;
        this.cost = cost;
    }
    @Override
    public int compareTo(Area next){
        return cost - next.cost;
    }
}
class Main {
    static int N; // 도시의 개수
    static int M; // 버스의 개수
    static boolean[] visited; // 방문 처리 배열
    static List<List<Area>> graph = new ArrayList<>();
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        // 입력 받기
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int fNum = Integer.parseInt(st.nextToken());
            int sNum = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(fNum).add(new Area(sNum, cost));
        }
        // 출발지와 도착지
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        // 최소 비용 구하기
        bw.write(dijkstra(start, end)+"");
        // 출력
        bw.flush();
    }
    // 다익스트라 알고리즘
    public static int dijkstra(int start, int end){
        PriorityQueue<Area> pq = new PriorityQueue<>();
        int[] lowCost = new int[N+1];
        Arrays.fill(lowCost, Integer.MAX_VALUE);
        pq.offer(new Area(start, 0));
        lowCost[start] = 0;
        while(!pq.isEmpty()){
            Area curArea = pq.poll();
            int pos = curArea.pos;
            if(!visited[pos]){
                visited[pos] = true;
                for(Area area : graph.get(pos)){
                    if(!visited[area.pos] && lowCost[area.pos] > lowCost[pos] + area.cost){
                        lowCost[area.pos] = lowCost[pos] + area.cost;
                        pq.offer(new Area(area.pos, lowCost[area.pos]));
                    }
                }
            }
        }
        return lowCost[end];
    }
}