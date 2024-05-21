import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
    1. 구현 아니면 그리디 문제인 줄 알았으나 dp (LIS) 문제였다.....
        - 역발상을 해야한다.
        - 철거 전선 개수 = 전깃줄의 전체 갯수 - 겹치지 않게 설치 가능한 최대 갯수이다.
        - A 전봇대 기준으로 오름차순 정렬해준다
        - A가 증가하면 B도 증가해야한다.
    2. 첫째 줄은 전봇대 사이의 전깃줄 개수
        - 둘째 줄부터는 A번호 B번호 형식으로 주어짐
        - 같은 위치에 두 개 이상의 전깃줄이 연결되지 않음
    3. 모든 전깃줄이 서로 교차하지 않기 위해 없애야하는 전깃줄에 최소 개수 return
* */
class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1]; // 중첩 수 확인 변수
        int[][] wire = new int[N+1][2]; // 전깃줄 배열
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            wire[i][0] = Integer.parseInt(st.nextToken());
            wire[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(wire, new Comparator<int[]>(){ // A 전봇대 기준으로 오름차순 정렬
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0] - o2[0];
            }
        });
        dp[1] = 1;
        // 최대 전선 설치 갯수 구하기 (LIS 구하기)
        for(int i=2; i<=N; i++){
            dp[i] = 1;
            for(int j=1; j<i; j++){
                if(wire[i][1] > wire[j][1]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        // 전깃줄을 설치할 수 있는 최대값 구하기
        int max = Integer.MIN_VALUE;
        for(int i=1; i<=N; i++){
            max = Math.max(max, dp[i]);
        }
        // 출력 (전체 개수 - 설치 개수)
        bw.write((N-max)+"");
        bw.flush();
    }
}