import java.io.*;
import java.util.Stack;

/*
    1. 올바른 괄호 문제의 추가 구현 (스택 + 구현)
        - 괄호를 열때 바로 닫히지 않으면 괄호의 종류에 맞게 곱하기 생성
            - () 2, [] 3
        - 닫힐 때 value값을 ans에 더한다.
    2. 첫째 줄에 괄호 문자열
    3. 값을 연산해서 return
        - 단 올바르지 않은 괄호열이면 0 return
* */
class Main {
    public static void main(String[] arg) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        int value = 1;
        // 입력 받기
        String str = br.readLine();
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c == '('){ // 괄호를 열 때 곱셈
                stack.push(c);
                value *= 2;
            }else if (c == '[') { // 괄호를 열 때 곱셈
                stack.push(c);
                value *= 3;
            }else if(c ==')'){ // 괄호를 닫을 때 확인 후 더하기
                if (stack.isEmpty() || stack.peek() != '(') { // 올바르지 않은 괄호일 때 제외
                    ans = 0;
                    break;
                } else if (str.charAt(i-1) == '(') {
                    ans += value;
                }
                stack.pop();
                value /= 2;
            }else if(c ==']'){ // 괄호를 닫을 때 확인 후 더하기
                if (stack.isEmpty() || stack.peek() != '[') { // 올바르지 않은 괄호일 때 제외
                    ans = 0;
                    break;
                } else if (str.charAt(i-1) == '[') {
                    ans += value;
                }
                stack.pop();
                value /= 3;
            }
        }
        if(!stack.isEmpty()){ // 마지막에 비어있지 않은지 체크
            ans = 0;
        }
        // 출력
        bw.write(ans+"");
        bw.flush();
    }
}