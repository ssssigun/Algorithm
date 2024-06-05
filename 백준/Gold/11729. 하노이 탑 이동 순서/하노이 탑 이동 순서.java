import java.io.*;

/*
    1. 하노이의 탑, 대표적인 재귀 문제
        - 오랜만에 푸는거라 생각이 금방 나지 않았다.
        - 함수를 시작지, 도착지, 경유지, 원판의 갯수를 매개 변수로 받는다.
    2. 첫째 줄에 첫번째 장대에 쌓인 원판의 갯수 N
    3. 첫째 줄에 옮긴 횟수 K, 그 이후 줄에는 이동 경로를 return
* */
class Main {
    static int cnt = 0; // 이동 횟수 저장
    static StringBuilder sb = new StringBuilder(); // 과정 저장
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        hanoi(1,3,2, N); // 재귀함수 시작
        // 출력
        bw.write(cnt+"\n");
        bw.write(sb.toString());
        bw.flush();
    }
    // 재귀 함수
    public static void hanoi(int from, int to, int mid, int N){
        if(N == 1){ // 마지막이면 직접 목적지까지 이동
            sb.append(from + " "+ to+"\n");
            cnt++;
            return;
        }
        // 그게 아니면 경유지를 거쳐야함
        hanoi(from, mid, to, N-1);
        sb.append(from+" "+to+"\n");
        cnt++;
        hanoi(mid, to, from, N-1);
    }
}