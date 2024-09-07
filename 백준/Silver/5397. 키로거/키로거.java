/*
    1. 문자열 문제
        - 리스트에 문자를 입력
        - 단 커서 위치를 기록하기
        - 화살표 방향으로 커서의 방향 조절
            - 단 0 아래 X
        - 백스페이스는 커서 앞에 내용 지우기
    2. 첫째 줄에 테스트 케이스의 개수
        - 둘째 줄부터 입력한 문자열
    3. 입력한 것에 맞게 비밀번호 return
* */

import java.io.*;

class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            String str = br.readLine();
            int idx = 0;
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<str.length(); j++){
                char c = str.charAt(j);
                if(c == '<'){ // 왼쪽 화살표일 떄
                    if(idx > 0){
                        idx--;
                    }
                }else if(c == '>'){ // 오른쪽 화살표일 때
                    if(idx <sb.length()){
                        idx++;
                    }
                }else if(c == '-'){ // 백스페이스일 때
                    if(idx > 0){
                        sb.deleteCharAt(idx-1);
                        idx--;
                    }
                }else{ // 나머지 문자일 때
                    sb.insert(idx, c);
                    idx++;
                }
            }
            bw.write(sb.toString()+"\n");
        }
        // 출력
        bw.flush();
    }
}