import java.io.*;
import java.util.StringTokenizer;

/*
    1. dp로 문제를 풀 예정
        - dp 배열 하나를 생성해서 이동 가능한 위치만큼 횟수 저장
        - 단 0보다 큰데 자신의 값보다 작으면 저장하지 않는다.
        - 마지막 위치의 값을 return 하고 없으면 도달 불가이므로 -1 return
    2. 첫째 줄엔 미로 크기 N
        - 둘째 줄엔 N개의 정수
    3. 끝에 도달하는 최솟값 return, 도달하지 못하면 -1 return
* */
class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) { // 배열 입력 받기
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 최솟값 구하기
        for(int i=1; i<N; i++){
            int num = arr[i];
            if(i>=2 && dp[i]==0){ // 중간에 끊길 경우 탈출
                break;
            }
            for(int j=i+1; j<=i+num; j++){
                if(j>N){ // 배열 밖으로 나가면 종료
                    break;
                }
                if(dp[j] == 0){
                    dp[j] = dp[i] + 1;
                }else if (dp[j] > dp[i]+1){ // 기존보다 작은 수라면 변경
                    dp[j] = dp[i] + 1;
                }
            }
        }
        if(N>=2 && dp[N] == 0){ // 도달한 적이 없으면 -1 return
            dp[N] = -1;
        }
        // 출력
        bw.write(dp[N]+"");
        bw.flush();
    }
}