/*
    1. 단축키 지정하기
        - 단어의 첫문자부터 지정한다 (중복 불가)
        - 첫문자들이 이미 있다면 오른쪽으로 이동하면서 지정
        - 지정 불가능하면 납두기
    2.  첫째 줄엔 명령어 N개
        - 이후부터 명령어
    3. 단축키를 대괄호 감싸서 return
* */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Character> list = new ArrayList();
        // 입력 받기
        int N = Integer.parseInt(br.readLine());
        String[] input = new String[N];
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            input[i] = br.readLine();
        }
        // 단축키 지정
        for(int i=0; i<N; i++){
            String[] temp = input[i].split(" ");
            int idx = 0;
            for(int j=0; j<temp.length; j++){ // 첫문자 확인
                char fir = temp[j].charAt(0);
                if(!list.contains(Character.toUpperCase(fir))){
                    list.add(Character.toUpperCase(fir));
                    input[i] = insertS(input[i], idx);
                    visited[i] = true;
                    break;
                }
                idx += temp[j].length() + 1;
            }
            if(!visited[i]){ // 첫문자가 전부 중복이면 진행
                for (int j = 1; j < input[i].length(); j++) { // 왼쪽부터 확인하기
                    char t = input[i].charAt(j);
                    if (t == ' ') {
                        continue;
                    } else if (!list.contains(Character.toUpperCase(t))) {
                        list.add(Character.toUpperCase(t));
                        input[i] = insertS(input[i], j);
                        break;
                    }
                }
            }
        }
        // 출력
        for(int i=0; i<N; i++){
            bw.write(input[i]+"\n");
        }
        bw.flush();
    }
    // 괄호 삽입 함수
    public static String insertS(String s, int idx){
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(0,idx));
        sb.append("[");
        sb.append(s.charAt(idx));
        sb.append("]");
        sb.append(s.substring(idx+1));
        return sb.toString();
    }
}
