/*
    1. 단순 구현 문제이다. (처음에 문제를 잘못 이해함)
        - 스택을 활용해서 위에서부터 무게 중심을 확인해야함
        - 무게 중심은 (상자의 중심+ ... / 상자의 개수)
        - 무게 중심이 아래이 상자의 범위 안에 들어가면 안정적인 상태이다
    2. 첫째 줄엔 상자의 개수 N, 사이즈 L
        - 둘째 줄엔 상자의 중심 N개가 주어진다.
    3. 상자가 균형이 된다면 stable, 안된다면 unstable return
* */

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Stack<Long> stack = new Stack<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            stack.push(Long.parseLong(st.nextToken()));
        }

        long sum = 0;
        int cnt = 0;
        while(cnt < N-1){ // 위에서 부터 무게 중심 확인하기
            long cur = stack.pop(); // 현재 박스의 중심
            sum += cur; // 전체 박스의 중심
            cnt++; // 박스의 개수
            double x = sum / (double) cnt; // 계산한 무게 중심
            long prev = stack.peek();
            if(prev - L < x && x < prev + L){ // 중심 들어가면 스킵
                continue;
            }else{ // 중심에 없으면 불안정
                bw.write("unstable");
                bw.flush();
                return;
            }
        }
        // 끝까지 도달했으면 성공
        bw.write("stable");
        bw.flush();
    }
}