/*
    1. 백트래킹 문제이다.
        - 오름차순 수열이므로 정렬
        - M만큼 들어가서 숫자를 출력한다.
        - 단 중복은 X
            - StringBuilder의 indexOf 활용
    2. 숫자 개수 N과 길이 M이 주어짐
        - 둘째 줄엔 숫자 N개
    3. 만들어지는 수열들을 return
* */

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int[] arr;
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 하기
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); // 오름 차순 정렬
        back("",0, 0); // 백트래킹
        // 출력
        bw.write(sb.deleteCharAt(sb.length()-1).toString()); // 마지막 줄바꿈 빼고 출력
        bw.flush();
    }
    public static void back(String str, int depth, int idx){
        if(depth == M){ // 깊이가 M이면 return
            if(sb.indexOf(str) < 0){ // 중복 제거
                sb.append(str + "\n");
            }
            return;
        }else{
            for(int i=idx; i<N; i++){
                int t = arr[i];
                if(depth == 0){
                    back(str+arr[i],depth + 1, i);
                }else{ // 2번째 숫자부터 띄어쓰기 추가
                    back(str+" "+arr[i],depth + 1, i);
                }
            }
        }
    }
}