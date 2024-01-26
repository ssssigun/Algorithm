/*
    1. 대표적인 dp 문제
        - 메모이제이션을 사용
    2. 입력은 삼각형의 정보가 담긴 배열 triangle
    3. 숫자의 최대값 return
*/
import java.io.*;
class Solution {
    public int solution(int[][] triangle) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int answer = 0;
        int[][] dp = new int[triangle.length][];
        // 결과 저장용 배열 복사
        for(int i=0; i<dp.length; i++){
            dp[i] = new int[triangle[i].length];
        }
        for(int i=0; i<dp.length-1; i++){
            for(int j=0; j<dp[i].length; j++){
                // 왼쪽 연산
                dp[i+1][j] = Math.max(triangle[i][j] + triangle[i+1][j], dp[i+1][j]);
                // 오른쪽 연산
                dp[i+1][j+1] = Math.max(triangle[i][j] + triangle[i+1][j+1], dp[i+1][j+1]);
            }
            // 값 복사
            for(int k=0; k<dp[i+1].length; k++){
                triangle[i+1][k] = dp[i+1][k];
            }
        }
        // 최대값 찾기
        for(int i=0; i<dp[dp.length-1].length; i++){
            if(answer < dp[dp.length-1][i]){
                answer = dp[dp.length-1][i];
            }
        }
        bw.write(answer+"");
        bw.flush();
        return answer;
    }
}