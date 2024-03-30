import java.io.*;
import java.util.*;

/*
    1. bfs 문제이다.
        - 이분 그래프인지 판별하는 문제이다.
        - 근데 놀랍게도 이분 그래프는 그래프가 두개로 나뉜게 아니라고 한다..
        - 아무튼 색칠하면서 진행하기
        - 인접한 정점이 같은 색상이면 이분 그래프가 아니다.
    2. 첫째 줄에 테스트 케이스의 수 K, 각 테스트 케이스의 첫째 줄엔 정점의 갯수 V, 간선의 갯수 E
    3. 이분 그래프면 YES 아니면 NO return
* */
class Main {
    static int K; // 테스트 케이스의 수
    static int V; // 정점의 갯수
    static int E; // 간선의 갯수
    static final int RED = 1; // 임의의 색상
    static int[] colors; //
    static List<List<Integer>> graph = new ArrayList<>(); // 간선 정보
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        // 입력 받기
        K = Integer.parseInt(br.readLine());
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            colors = new int[V+1];
            for (int j = 0; j <= V; j++) { // 정점 정보 추가
                graph.add(new ArrayList<>());
            }
            for(int j=0; j<E; j++){ // 간선 정보 추가
                st = new StringTokenizer(br.readLine());
                int fNum = Integer.parseInt(st.nextToken());
                int sNum = Integer.parseInt(st.nextToken());
                graph.get(fNum).add(sNum);
                graph.get(sNum).add(fNum);
            }
            // 색칠하면서 확인하기
            boolean flag = false; // 중간에 이분 그래프 확인용 flag값
            for(int j=1; j<=V; j++){
                if(colors[j] == 0){
                    flag = bfs(j);
                }
                if(flag){
                    break;
                }
            }
            if(flag){
                bw.write("NO\n");
            }else{
                bw.write("YES\n");
            }
            // 배열 초기화
            graph.clear();
        }
        // 출력
        bw.flush();
    }
    // bfs
    public static boolean bfs(int n){
        Queue<Integer> que = new LinkedList<>();
        que.offer(n);
        colors[n] = RED; // 시작점 색칠
        while(!que.isEmpty()){
            int cur = que.poll();
            for(int i=0; i<graph.get(cur).size(); i++){
                int next = graph.get(cur).get(i);
                if(colors[cur] == colors[next]){ // 확인 했을 때 본인과 연결된 노드가 같은 색상을 보유하면 이분 그래프가 아님
                    return true;
                }
                if(colors[next] == 0){ // 색상이 없으면 다른 색상으로 칠하기
                    colors[next] = colors[cur] * -1;
                    que.offer(next);
                }
            }
        }
        return false;
    }
}