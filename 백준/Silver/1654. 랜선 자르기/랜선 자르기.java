/*
    1. 이분탐색 연습 문제
        -
    2. 첫째 줄엔 가지고 있는 랜선의 개수 K, 필요한 랜선의 개수 N
        - 그 이후엔 랜선의 길이 K개
    3. N개를 만들 수 있는 랜선의 최대 길이를 return
* */

import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long low = 0;
        long high = 0;
        long mid = 0;
        int[] arr = new int[K];
        for(int i=0; i<K; i++){ // 배열 입력 받으면서 최대값 찾기
            arr[i] = Integer.parseInt(br.readLine());
            high = Math.max(high, arr[i]);
        }
        high++;
        while(low < high){ // 이분 탐색 시작
            mid = (low + high) / 2;
            long cnt = 0;
            for(int i=0; i<K; i++){ // 전선 잘라서 개수 구하기
                cnt += (arr[i] / mid);
            }
            if(cnt < N){ // 개수가 작으면 더 낮은 단위로 잡기
                high = mid;
            }else{ // 개수가 높으면 더 높은 단위로 잡기
                low = mid + 1;
            }
        }

        // 출력
        bw.write((low-1)+"");
        bw.flush();
    }
}