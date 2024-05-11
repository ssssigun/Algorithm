import java.io.*;

/*
    1. vip 좌석을 가준으로 나눠서 계산한다.
        - 각각 나눈 구역의 경우의 수를 곱해준다.
        - 구역마다 경우의 수는 피보나치 수열의 형태를 가지는 것 같다.
    2. 첫째 줄엔 좌석의 개수 N
        - 둘째 줄에는 고정석의 개수 M
        - 그 이후부터 작은 순으로 고정석의 번호가 주어짐
    3. 사람이 앉을 수 있는 가짓수 return
* */
class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int ans = 1;
        int prev = 1;
        // 입력 받기
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[M+1];
        arr[M] = N+1;
        int[] dp = new int[N+3];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=0; i<M; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        // 계산하기
        if (N > 2) { // dp값 생성
            for(int i=3; i<=N; i++){
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        for(int i=0; i<arr.length; i++){ // 경우의 수 구하기
            int temp = arr[i] - prev;
            prev = arr[i] + 1;
            ans *= dp[temp];
        }
        // 출력
        bw.write(ans+"");
        bw.flush();
    }
}