/*
    1. 공통 문자를 찾아서 반환하기
    2. 첫째 줄에 파일의 갯수 N
        - 그 이후 검색한 결과 N개
    3. 패턴 return
* */

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        int N = Integer.parseInt(br.readLine());
        String[] re = new String[N];
        for(int i=0; i<N; i++){
            re[i] = br.readLine();
        }
        StringBuilder sb = new StringBuilder(re[0]);
        // 패턴 찾기
        for(int i=1; i<N ; i++){
            if(sb.toString().equals(re[i])){
                continue;
            }else{
                for(int j=0; j<sb.length(); j++){
                    if(sb.charAt(j) != re[i].charAt(j)){
                        sb.replace(j,j+1,"?");
                    }
                }
            }
        }
        // 출력
        bw.write(sb.toString());
        bw.flush();
    }
}
