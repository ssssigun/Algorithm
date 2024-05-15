import java.io.*;
import java.util.*;

/*
    1. dfs를 활용해서 풀려고 했으나 테스트 케이스에서 틀리고 플로이드/다익스트라로 변경
    2. 첫째 줄엔 지역의 갯수 n, 수색 범위 m, 길의 개수 r
        - 둘째 줄엔 각 구역의 아이템 수 t (노드 정보)
        - 셋째 줄부터는 지역의 끝 번호 a,b, 길의 길이 (간선 정보)
    3. 얻을 수 있는 최대 아이템 수 return
* */
class Position implements Comparable<Position>{
    int posNum; // 지역 번호
    int weight; // 거리
    Position(int posNum, int weight){
        this.posNum = posNum;
        this.weight = weight;
    }
    @Override
    public int compareTo(Position arg){
        return weight - arg.weight;
    }
}
class Main {
    static boolean[] visited; // 방문 처리 배열
    static int n; // 노드의 개수
    static int m; // 수색 범위
    static int r; // 길의 개수
    static int[] dis; // 최단 거리 저장 배열
    static List<List<Position>> graph = new ArrayList<>();
    static int[] nodeInfo;
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        nodeInfo = new int[n+1];
        dis = new int[n+1];
        for(int i=0; i<=n; i++){ // 지역 개수
            graph.add(new ArrayList<>());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){ // 아이템의 개수
            nodeInfo[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<r; i++){ // 연결 정보 + 길의 길이
            st = new StringTokenizer(br.readLine());
            int fNum = Integer.parseInt(st.nextToken());
            int sNum = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(fNum).add(new Position(sNum, weight));
            graph.get(sNum).add(new Position(fNum, weight));
        }
        int ans = 0;
        for(int i=1; i<=n; i++){ // 구역마다 더한 후 최댓값 갱신하기
            ans = Math.max(ans, dijkstra(i));
        }
        // 출력
        bw.write(ans+"");
        bw.flush();
    }
    // 다익스트라 알고리즘 함수
    public static int dijkstra(int start){
        // 배열 값 초기화
        Arrays.fill(dis, Integer.MAX_VALUE);
        Arrays.fill(visited, false);
        PriorityQueue<Position> pQue = new PriorityQueue<>();
        pQue.offer(new Position(start, 0)); // 초기 지역 객체 생성
        dis[start] = 0; // 본인 지역은 거리 0
        while(!pQue.isEmpty()){
            Position curPos = pQue.poll();
            int pos = curPos.posNum;
            if(!visited[pos]){
                visited[pos] = true;

                for(Position position : graph.get(pos)){ // 기존 값보다 최소 거리이면 값 변경
                    if(!visited[position.posNum] && dis[position.posNum] > dis[pos] + position.weight){
                        dis[position.posNum] = dis[pos] + position.weight;
                        pQue.offer(new Position(position.posNum, dis[position.posNum]));
                    }
                }
            }
        }
        int res = 0;
        for(int i=1; i<=n; i++){ // 거리가 수색 범위 안이면 더하기
            if(dis[i] <= m){
                res += nodeInfo[i];
            }
        }
        return res;
    }
}