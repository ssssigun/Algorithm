/*
 * 1. 스택 사용
 * 2. 마지막 닫을 때 파이프의 끝인지 레이저인지 구분하기
 * 	- 이외 여는 괄호는 스택에 추가하기
 * 3. 입력은 한줄에 괄호
 * 4. 잘려진 조각을 return
 * */
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		// 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 파이프 스택
		Stack<String> stack = new Stack();
		int cnt = 0;
		// 배치
		String b = br.readLine();
		for(int i=0; i<b.length(); i++) {
			// 여는 괄호면 추가
			if(b.charAt(i) == '(') {
				stack.push("(");
			// 닫는 괄호면 확인하기
			}else {
				if(b.charAt(i-1) == '(') {
					stack.pop();
					cnt+= stack.size();
				}else {
					stack.pop();
					cnt++;
				}
			}
		}
		// 출력
		bw.write(cnt+"");
		bw.flush();
	}
}
	