/*
    1. dp 문제인 것 같다.
        - 본인 바로 밑에 열만 밟지 않으면 된다.
        - 전부 다 더하고 최대값 계산
*/
class Solution {
    int solution(int[][] land) {
        int ans = 0;
        int[][] dp = new int[land.length][5];
        dp[0] = land[0].clone();
        for(int i=0; i<land.length-1; i++){ // 행
            for(int j=0; j<4; j++){ // 현재 열
                for(int k=0; k<4; k++){ // 다음 행 다음 열
                    if(j != k){ // 같은 열이 아닐 때 최대값 저장
                        dp[i+1][k] = Math.max(dp[i+1][k], dp[i][j] + land[i+1][k]);
                    }
                }
            }
        }
        for(int i=0; i<dp[0].length; i++){ // 마지막 열에서 최대값 구하기
            ans = Math.max(dp[dp.length-1][i], ans);
        }
        return ans;
    }
}