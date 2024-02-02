/*
    1. 대표적인 재귀함수 문제였던 것 같다.
    2. 첫째 줄에 첫번째 장대에 쌓인 원판의 개수 N
    3.  첫째 줄에 옮긴 수 K return
        - 단 N이 20이하일 때 과정 출력하기
* */

import java.io.*;
import java.math.BigInteger;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        // 계산식 사용
        BigInteger num = new BigInteger("2");
        bw.write(num.pow(N).subtract(new BigInteger("1"))+"");
        // 20보다 작으면 과정 출력
        if (N <= 20){
            bw.write("\n");
            hanoi(N,1,3);
            bw.write(sb.toString());
        }
        bw.flush();
    }
    // 원판 이동 함수
    public static void hanoi(int N, int start, int finish){
        if(N == 0){
            return;
        }else{
            hanoi(N-1, start, 6- start - finish);
            sb.append(start).append(" ").append(finish).append("\n");
            hanoi(N-1, 6- start - finish, finish);
        }
    }
}
