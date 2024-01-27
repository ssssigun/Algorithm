/*
    1. 6개 줄과 1개 줄 전부 최소값 저장하고 이용
        - 단 주의해야할 점은 남은 개 6개 이하일 때 낱개보다 사는게 이득이면 묶음으로 구매
    2. 첫째 줄엔 끊어진 기타줄 N과 기타줄 브랜드 M
        - 둘째 줄엔 6개 패키지의 가격과 낱개 가격
    3. N개를 사기 위한 최소값 return
* */

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] min = new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE};
        int ans = 0;
        // 최솟값 찾아서 저장
        for (int i = 0; i < M; i++) {
            String[] temp = br.readLine().split(" ");
            if(Integer.parseInt(temp[0]) < min[0]){
                min[0] = Integer.parseInt(temp[0]);
            }
            if(Integer.parseInt(temp[1]) < min[1]){
                min[1] = Integer.parseInt(temp[1]);
            }
        }
        // 계산
        while(N != 0){
            if(min[0] > min[1]*6){ // 전부 낱개로 살 때가 싼 경우
                ans =  min[1]*N;
                break;
            }
            if(N >= 6){ // 6보다 클 때
                N -= 6;
                ans += min[0];
            }else{ // 6보다 작을 때
                if(min[0] < min[1] * N){
                    ans += min[0];
                    break;
                }else{ 
                    ans += min[1] * N;
                    break;
                }
            }
        }
        // 출력
        bw.write(ans+"");
        bw.flush();
    }
}