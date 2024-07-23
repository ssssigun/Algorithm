/*
    1. 문자열 문제이다.
        - 완전 탐색을 해도 시간초과가 나지 않음 (100 * 10 * 10)
        - 처음에 글자수 만큼 문자 배열을 생성
        - H * W를 이동하면서 글자 위치에 있는 문자 확인
        - ?가 아니면 배열에 넣기
    2. 첫째 줄에 문자열의 길이 N, 세로로 번진 개수 H, 가로로 번진 개수 W
        - 둘째 줄부터 번진 문자열 H * W로 주어짐
    3. 최대한 문자 복원해서 Return, 단 복원할 수 없는 부분은 ?로 표시
* */

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        char[] str = new char[N];
        Arrays.fill(str, '?');

        // 입력 받으면서 확인
        for(int i=0; i<H; i++){
            String temp = br.readLine();
            int cnt = 0;
            int idx = 0;
            for(int j=0; j<temp.length(); j++){
                char t = temp.charAt(j);
                if(t != '?'){ // ?가 아니면 배열에 값 넣기
                    str[idx] = t;
                }
                if(++cnt == W){
                    idx++;
                    cnt = 0;
                }
            }
        }
        // 문자열 합치기
        StringBuilder sb = new StringBuilder();
        for(char a : str){
            sb.append(a);
        }
        // 출력
        bw.write(sb.toString());
        bw.flush();
    }
}