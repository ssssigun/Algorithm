/*
    1. 단순 구현
    2. 해당 위치에서 인접한 색상 갯수 찾기
*/
import java.util.*;
class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0; 
        String color = board[h][w]; // 현재 색상
        int max = board.length; // 보드 최댓값
        // 방향 리스트
        int[] dx = {0,1,0,-1};
        int[] dy = {-1,0,1,0};
        // 주변 탐색
        for(int i=0; i<4; i++){
            int nw = w + dx[i];
            int nh = h + dy[i];
            // 범위를 벗어나지 않으면서 색상이 같은면
            if(0<=nw && 0<=nh && nw<max && nh<max && color.equals(board[nh][nw])){
                answer++;
            }
        }
        return answer;
    }

}