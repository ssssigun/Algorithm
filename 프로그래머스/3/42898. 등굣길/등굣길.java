/*
    1. bfs로 풀었다가 시간초과가 났다
        - dp로 경로들을 더하면 도착지 인덱스에 저장될듯하다
    2. 입력은 맵의 크기 m,n, 웅덩이의 위치 puddiles
    3. 도착하는 경우의 수 return
*/
import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles){
        // 선언
        int[] dx = {-1, 0};
        int[] dy = {0, -1};
        int mod = 1000000007;
        int[][] map = new int[n][m];
        map[0][0] = 1;
        for(int i=0; i<puddles.length; i++){
            int x = puddles[i][1] - 1;
            int y = puddles[i][0] - 1;
            map[x][y] = -1;
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == -1){ // 웅덩이면 피하기
                    continue;
                }
                for(int k=0; k<2; k++){
                    int cx = i + dx[k];
                    int cy = j + dy[k];
                    if(cx>=0 && cy>=0 && cx<n && cy<m){
                        if(map[cx][cy] != -1){
                            map[i][j] += map[cx][cy]%mod;   
                        }
                    }
                }
            }
        }
        return map[n-1][m-1]%mod;
    }
}