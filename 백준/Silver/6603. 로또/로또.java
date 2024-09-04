/*
    1. 백 트래킹 문제인 것 같다.
        - 숫자가 작아서 시간 복잡도가 가능할 것 같음
        - 주어진 집합 S에서 6개를 골라서 출력
    2. 줄 첫번째 수는 k, 다음 나머지 수는 집합 S에 포함되는 수이다.
        - 마지막 줄에는 0이 주어져 있음
    3. 숫자 조합 사전순으로 return
        - 테스트 케이스 사이엔 빈줄 하나 넣기
* */

import java.io.*;
import java.util.StringTokenizer;

class Main {
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        //
        while(true){
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            if(K == 0){ // 입력이 끝나면 나가기
                break;
            }
            arr = new int[K]; // 배열 저장
            for(int i=0; i<K; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            back(0, 0,"");
            sb.append("\n");
        }
        // 출력
        bw.write(sb.toString());
        bw.flush();
    }
    public static void back(int depth, int start, String str){ // 백 트래킹 함수
        if(depth == 6){ // 6개 골랐으면 반환
            sb.append(str+"\n");
            return;
        }
        for(int i=start; i<arr.length; i++){
            back(depth+1, i+1, str+arr[i]+" ");
        }
    }
}