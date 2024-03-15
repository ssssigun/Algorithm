import java.io.*;

/*
    1. 최장 공통 부분 수열(LCS) 문제이다.
        - 처음엔 접근을 아예 못했었다..
        - dp의 대표 문제 중 하나로 두 문자열로 2차원 dp 배열을 활용한다.
        - 두 문자가 같을 때 (x-1),(y-1) +1 값을 return
        - 다를 경우 행-1, 열-1 중 큰 수 return
        - 다 연산한 후 마지막 인덱스의 값이 최장 공통 부분 수열의 길이이므로 정답으로 return
    2. 첫째 줄과 둘째 줄에 두 문자열이 주어진다.
    3. 두 문자열의 LCS 길이 return
* */
class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();
        int[][] dp = new int[str1.length+1][str2.length+1];
        // LCS 구하기
        for(int i=1; i<=str1.length; i++){
            for(int j=1; j<=str2.length; j++){
                if(str1[i-1] == str2[j-1]){ // 만약 문자가 같다면 대각선의 값+1
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{ // 그게 아니라면 행-1이나 열-1중에 큰 값 대입
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        // 출력
        bw.write(dp[str1.length][str2.length]+""); // 마지막 값이 LCS의 길이
        bw.flush();
    }
}