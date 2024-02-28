import java.io.*;
import java.util.StringTokenizer;

/*
    1. 백트레킹 문제이다
        - 재료를 1~N개 선택했을 때의 경우를 다 찾아서 확인
        - 신맛은 곱하고 쓴맛은 합하기
        - (전체 재료 신맛의 곱) - (전체 재료 쓴맛의 합) 중 최솟값 return
    2. 첫째 줄엔 재료의 수 N
        - 둘째 줄부터는 재료의 신맛과 쓴맛
    3. 신맛과 쓴맛이 가장 적은 요리의 차이 return
* */
class Main {
    public static int[][] arr; // 재료 배열
    public static boolean[] select; // 선택 여부 확인 배열
    public static int ans = Integer.MAX_VALUE; // 정답 (최솟값)
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        // 입력 받기
        int N = Integer.parseInt(br.readLine()); // 재료의 수
        arr = new int[N][2];
        select = new boolean[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        // 재료 조합하기
        for(int i=1; i<=N; i++){
            back(0,0, i);
        }
        // 출력
        bw.write(ans+"");
        bw.flush();
    }
    // 백트레킹 함수
    public static void back(int start, int depth, int target){
        if(depth == target){ // 원하는만큼 재료를 선택하면 수치 계산
            int mul = 1;
            int sum = 0;
            for(int i=0; i<select.length; i++){
                if(select[i]){ // 선택된 재료들로 차이 계산
                    mul *= arr[i][0];
                    sum += arr[i][1];
                }
            }
            int flavor = Math.abs(mul - sum);
            if(flavor < ans){ // 최솟값이 경우 교체
                ans = flavor;
            }
            return;
        }
        for(int i=start; i<arr.length; i++){
            if(!select[i]){
                select[i] = true;
                back(start+1, depth+1, target);
                select[i] = false;
            }
        }
    }
}