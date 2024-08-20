/*
    1. 그리디? 구현? 문제인 것 같다.
        - 우선 내림차순 정렬
        - 앞에서부터 하나씩 추가
        - 배열 앞과 뒤 번갈아가면서 추가
        - 이후 앞뒤 차이 최대값 return
    2. 첫 줄에 테스트케이스 T
        - 둘째 줄엔 각 줄의 통나무 개수 N
        - 통나무의 높이 N개
    3. 테스트 케이스마다 최소 난이도 return
* */

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        // 테스트 케이스만큼 반복
        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            Integer[] arr = new Integer[N];
            for(int j=0; j<N; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr, Collections.reverseOrder()); // 내림차순 정렬
            LinkedList<Integer> list = new LinkedList<>();
            for(int j=0; j<N; j++){
                if(j%2 == 0){ // 짝수번째엔 앞에서 넣기
                    list.addFirst(arr[j]);
                }else{ // 홀수는 뒤에서 넣기
                    list.addLast(arr[j]);
                }
            }
            int max = 0;
            for(int j=0; j<list.size()-1; j++){ // 높이 차이 계산
                max = Math.max(Math.abs(list.get(j) - list.get(j+1)), max);
            }
            max = Math.max(Math.abs(list.get(0) - list.get(list.size()-1)), max); // 마지막 연결 부분 계산
            bw.write(max+"\n");
        }
        // 출력
        bw.flush();
    }
}