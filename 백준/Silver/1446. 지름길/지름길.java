/*
    1. 재귀 or 백트래킹으로 풀기
        - 지름길은 도착 지점을 넘어가면 안됨
        - 도착지에 도착하면 최솟값과 비교해서 저장
    2. 지름길의 개수 N, 도착 지점의 위치
        - 이후 지름길 N개가 주어짐
        - 시작점, 도착지점, 길이
    3. 도착지의 최솟값 return
* */

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static boolean[] visited;
    static int[][] road;
    static int ans = Integer.MAX_VALUE;
    static int N;
    static int finish;
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        finish = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        road = new int[N][3];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            road[i][0] = Integer.parseInt(st.nextToken());
            road[i][1] = Integer.parseInt(st.nextToken());
            road[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(road, (o1,o2) ->{return o1[0] - o2[0];}); // 거리 순서 대로 정렬하기
        back(0,0,0);
        // 출력
        bw.write(ans+"");
        bw.flush();
    }
    public static void back(int startIdx, int cur, int distance){
        if(cur == finish){
            ans = Math.min(ans, distance);
            return;
        }else if(cur < finish){
            ans = Math.min(ans, distance + (finish - cur));
        }else{
            return;
        }
        for(int i=startIdx; i<N; i++){
            if(!visited[i] && cur <= road[i][0]){
                visited[i] = true;
                int diff = road[i][0] - cur;
                back(i+1, road[i][1], (distance + road[i][2] + diff));
                visited[i] = false;
            }
        }

    }
}