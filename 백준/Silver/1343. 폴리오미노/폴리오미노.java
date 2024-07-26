/*
    1. 문자열 처리 문제
        - .을 split으로 하니 dot처리가 애매해졋음
        - 그냥 하나씩 입력 받고 dot이 아니면 cnt, dot이면 연산
        - 4로 나뉘면 몫만큼 AAAA 추가
        - 그 다음 2로 나뉘면 BB 추가
        - 완전히 못 덮으면 -1 반환
    2. 보드판 주어짐 .과 X로 이루어져 있음
    3. 사전 순으로 앞서는 답 (AAAA 먼저인 답) return
        - 불가능 하면 -1
* */

import java.io.*;

class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        int leng = 0;
        for(int i=0; i<input.length(); i++){ // 하나씩 확인
            char temp = input.charAt(i);
            if(temp == '.'){ // dot일 때
                if(leng > 0){
                    String t = cal(leng);
                    if(" ".equals(t)){
                        bw.write("-1");
                        bw.flush();
                        return;
                    }else{
                        sb.append(t);
                    }
                    leng = 0;
                }
                sb.append(temp);
            }else{ // dot이 아닐 때
                leng++;
                if(i == input.length()-1){
                    String t = cal(leng);
                    if(" ".equals(t)){
                        bw.write("-1");
                        bw.flush();
                        return;
                    }else{
                        sb.append(t);
                    }
                }
            }
        }
        // 출력
        bw.write(sb.toString());
        bw.flush();
    }
    public static String cal(int leng){ // 문자열의 개수를 확인하고 AAAA나 BB로 치환하기
        StringBuilder sb = new StringBuilder();
        while(leng >= 2){
            if(leng/4 >= 1){
                for(int j=0; j<leng/4; j++){
                    sb.append("AAAA");
                }
                leng %= 4;
            }else if(leng/2 >= 1){
                for(int j=0; j<leng/2; j++){
                    sb.append("BB");
                }
                leng %= 2;
            }
        }
        if(leng > 0){
            sb.setLength(0);
            sb.append(" ");
        }
        return sb.toString();
    }
}