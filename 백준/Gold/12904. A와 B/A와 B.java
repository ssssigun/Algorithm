import java.io.*;

/*
    1. 백트래킹 문제인 것 같다.
        - T를 S로 연산하며 이동, 문자열이 같은지 확인
        - 같으면 1로 변경하고 탈출
    2. 첫째 줄에 문자열 S, 둘째 줄에 문자열 T
    3. 변경 가능하면 1, 불가능하면 0을 return
* */
class Main {
    static String S;
    static String T;
    static int ans = 0; // 정답
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        S = br.readLine();
        T = br.readLine();
        // 문자가 같아지는지 찾기
        cals(T);
        // 출력
        bw.write(ans+"");
        bw.flush();
    }
    // 문자열 연산 함수
    public static void cals(String s){
        if(s.length() == S.length()){ // 같아지면 1 return
            if(S.equals(s)){
                ans = 1;
            }
            return;
        }
        StringBuilder sb = new StringBuilder(s);
        if(sb.charAt(sb.length()-1) == 'A'){ // 끝자리가 A이면 빼기
            sb.deleteCharAt(sb.length()-1);
            cals(sb.toString());
        }else if(sb.charAt(sb.length()-1) == 'B'){ // 끝자리가 B이면 빼고 뒤집기
            sb.deleteCharAt(sb.length()-1);
            sb.reverse();
            cals(sb.toString());
        }
    }
}