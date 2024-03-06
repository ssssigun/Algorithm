import java.io.*;
import java.util.StringTokenizer;

/*
    1. 백트레킹 문제인듯하다.
        - 순서를 고려해서 모든 경우의 수를 돌기
        - 지나오면서 500이하로 떨어지면 탈출
        - 그게 아니라 잘 진행되면 ans++
    2. 첫째 줄에 일수 N, 하루 근손실량 K
        - 둘째 줄부터 운동량 키트 근증가량
    3. N개의 운동 키트를 사용하는 모든 경우 중에서 항상 중량이 500 이상이 되도록 하는 경우의 수 return
* */
class Main {
    public static int N; // 일 수
    public static int K; // 하루 근손실량
    public static int weight = 500; // 기본 중량
    public static int[] kit; // 운동 키트 배열
    public static boolean[] visited; // 방문처리배열
    public static int ans = 0; // 정답이 되는 경우의 수 저장

    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        kit = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            kit[i] = Integer.parseInt(st.nextToken());
        }
        // 백트레킹으로 경우의 수 구하기
        back(0);
        // 출력
        bw.write(ans+"");
        bw.flush();
    }
    // 백트레킹 함수
    public static void back(int depth){
        if(depth == N){ // N일차 일때
            ans++;
        }
        for(int i=0; i<N; i++){
            if(!visited[i] &&  weight+kit[i]-K >= 500){
                visited[i] = true;
                weight = weight + kit[i] - K;
                back(depth+1);
                visited[i] = false;
                weight = weight - kit[i] + K;
            }
        }
    }
}