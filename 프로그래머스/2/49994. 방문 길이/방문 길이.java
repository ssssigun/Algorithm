/*
    1. 단순 구현 문제
        - 시간 충분
        - 배열의 크기 11 x 11 x 4 (마지막 부분은 들어온 곳 방향)
        - 명령어 대로 진행
            - 경계를 넘는 명령어 무시
        - 지나간 곳은 방문 처리 (위치 + 방향)
            -  반대 방향도 방문 처리 해줘야 함
            - 다음 위치 + 정방향, 현재 위치 + 역방향 
*/
class Solution {
    public int solution(String dirs) {
        int answer = 0;
        boolean[][][] map = new boolean[11][11][4]; // 맵 배열
        int x = 5;// 현재 위치
        int y = 5;
        String command = "DLUR";
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        
        // 게임 진행
        int dis = 0;
        for(int i=0; i<dirs.length(); i++){
            int idx = command.indexOf(dirs.charAt(i)+""); // 정방향
            int reIdx = idx <= 1 ? idx+2 : idx-2; // 역방향
            int cx = x + dx[idx]; // 다음 위치
            int cy = y + dy[idx];
            if(cx>=0 && cy>=0 && cx<11 && cy<11){ // 범위 안인지 확인
                if(!map[cx][cy][idx]){ // 방문 하지 않은 길인지 확인
                    dis++;
                    map[cx][cy][idx] = true; // 다음 위치 정방향
                    map[x][y][reIdx] = true; // 현재 위치 역방향
                }
                x = cx;
                y = cy;   
            }
        }
        return dis;
    }
}