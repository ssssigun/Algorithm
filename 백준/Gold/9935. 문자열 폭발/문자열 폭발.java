import java.io.*;
import java.util.Stack;

/*
    1. 문자열 처리 문제이다.
        - 단순 인덱스로 접근했을 때는 시간 초과가 난다
        - so, stack을 활용하여 접근
        - 폭발 문자의 크기와 stack의 크기가 같아질 때 확인하기
        - index에 접근해서 일치하는지 확인
        - 일치하면 pop
    2. 첫째 줄엔 문자열
        - 둘째 줄엔 폭발 문자열
    3. 모든 폭발이 끝난 후의 문자열 return
        - 단, 남아있는 문자가 없는 경우에는 FRULA return
* */
class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        String explode = br.readLine();
        int leng = explode.length();
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<str.length(); i++){
            stack.push(str.charAt(i));
            if(stack.size() >= leng){ // 폭발 문자와 길이가 같아질 때 시작
                boolean flag = true;

                for(int j=0; j<leng; j++){ // 문자가 같은지 확인하고 틀리면 나가기
                    if(stack.get(stack.size() - leng + j) != explode.charAt(j)){
                        flag = false;
                        break;
                    }
                }
                if(flag){ // 폭발 문자의 길이만큼 pop
                    for(int j=0; j<leng; j++){
                        stack.pop();
                    }
                }
            }
        }
        // 출력
        if(stack.isEmpty()){ // 문자열이 비어 있을 때
            bw.write("FRULA");
        }else{ // 비어 있지 않으면 stack에 있는 문자 return
            for(char c : stack){
                sb.append(c);
            }
            bw.write(sb.toString());
        }
        bw.flush();
    }
}