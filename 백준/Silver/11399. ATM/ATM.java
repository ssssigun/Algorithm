import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
    1. 그리디 연습 문제
        - 인출하는 시간이 뒤로 가야 최솟값이 된다. (이전 값을 이후에 계속 더한 상태로 누적합을 구하기 때문에)
        - 우선 순위 큐를 활용해서 풀어보기
        - 순서 정보는 필요 없다
    2. 첫째 줄에 사람의 수 N
        - 둘째 줄엔 돈을 인출하는데 걸리는 시간
    3. 모든 사람이 돈을 인출하는데 최솟값을 return
* */
class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> que = new PriorityQueue<>();
        int ans = 0;
        int sum = 0;
        // 입력 받기
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            que.offer(Integer.parseInt(st.nextToken()));
        }
        while(!que.isEmpty()){ // 우선 순위 큐에서 적은 숫자부터 진행
            int t = que.poll();
            sum += t; // 기다린 시간 포함 시간 계산
            ans += sum; // 총 걸린 시간
        }
        // 출력
        bw.write(ans+"");
        bw.flush();
    }

}