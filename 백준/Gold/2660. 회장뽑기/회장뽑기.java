/*
    1. 플로이드 와셜 문제인 것 같다.
        - 최대값이 50이므로 n^3 가능
        - 노드와 간선의 정보로 그래프 만들기
        - 플로이드 와셜로 각 노드에서 노드까지의 거리 구하기
        - 노드당 가장 거리가 먼 노드 구하기 (점수)
        - 점수가 낮은 노드 출력
    2. 첫째 줄엔 회원 수 N
        - 둘째 줄부터 간선의 정보
        - 마지막 줄엔 -1 -1이 주어짐
    3. 첫째 줄엔 점수와 후보수
        - 둘째 줄엔 회장 후보 return
* */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> list  = new ArrayList<>();
        for(int i=0; i<N; i++){
            list.add(new ArrayList<>());
        }
        while(true){
            st = new StringTokenizer(br.readLine());
            int fNum = Integer.parseInt(st.nextToken());
            int sNum = Integer.parseInt(st.nextToken());
            if(fNum == -1 && sNum == -1){ // 마지막 줄
                break;
            }
            list.get(fNum-1).add(sNum-1);
            list.get(sNum-1).add(fNum-1);
        }
        // 플로이드 와셜
        int[][] dist  = new int[N][N];
        for(int i=0; i<N; i++){
            Arrays.fill(dist[i], 10000);
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(i==j){
                    dist[i][j] = 0;
                }
            }
        }
        for(int i=0; i<list.size(); i++){
            for(int j=0; j<list.get(i).size(); j++){
                int t = list.get(i).get(j);
                dist[i][t] = 1;
            }
        }
        for(int k=0; k<N; k++){
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        int[] score = new int[N];
        for(int i=0; i<N; i++){ // 점수 구하기
            int max = 0;
            for(int j=0; j<N; j++){ // 노드에서 가장 먼 값이 점수
                max = Math.max(max, dist[i][j]);
            }
            score[i] = max;
        }
        int min = Integer.MAX_VALUE;
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<N; i++){ // 회장 후보 구하기 (가장 낮은 점수)
            if(min > score[i]){ // 낮은 점수가 나오면 초기화하고 추가
                min = score[i];
                ans.clear();
                ans.add(i);
            }else if(min == score[i]){ // 점수가 같으면 목록에 추가
                ans.add(i);
            }
        }
        // 출력
        bw.write(min+" "+ans.size()+"\n");
        for(int i=0; i<ans.size(); i++){
            bw.write(ans.get(i)+1+"");
            if(i!=ans.size()-1){
                bw.write(" ");
            }
        }
        bw.flush();
    }
}