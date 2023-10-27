/*
    1. 브루트 포스(완전 탐색)
        - 재귀 함수(백트래킹)를 통해서 풀기
        - 던전은 한번만 방문 가능
    2. 입력은 현재 피로도 k, 최소필요도, 소모 필요도의 배열 dungeons
    3. 유저가 탐험할 수 있는 최대 던전의 수를 return
*/
class Solution {
    // 방문 처리 배열
    static boolean[] visited;
    // 최대 방문 수
    static int cnt = 0;
    // 백트래킹
    static void back(int depth, int k, int[][] dun){
        // 전체 던전 순회
        for(int i=0; i<dun.length; i++){
            // 방문하지 않고
            if(!visited[i]){
                // 최소 필요 피로도 조건이 맞으면 실행
                if(k >= dun[i][0]){
                    visited[i] = true;
                    back(depth+1,k-dun[i][1], dun);
                    visited[i] = false;
                }
            }
        }
        // 최대값 넣기
        cnt = Math.max(cnt, depth);
    }
    public int solution(int k, int[][] dungeons) {
        // 배열 초기화
        visited = new boolean[dungeons.length];
        // 최대로 방문할 수 있는 던전의 수 구하기
        back(0, k, dungeons);
        return cnt;
    }
}