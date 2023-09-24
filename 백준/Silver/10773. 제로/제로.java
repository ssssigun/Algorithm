/*
 * 1. 스택을 사용해서 숫자를 다 담고 0이 나오면 pop해주기
 * 2. 첫줄은 정수들의 갯수 K
 * 3. 최종적으로 stack의 있는 수를 더해서 return
 * */
import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	// 정수 개수 k 입력
    	int K = Integer.parseInt(br.readLine());
    	// 수를 담을 stack 생성
    	Stack<Integer> stack = new Stack();
    	// 입력 받기
    	for(int i=0; i<K; i++) {
    		int inp = Integer.parseInt(br.readLine());
    		// 0 이면 제외
    		if (inp == 0) {
    			stack.pop();
			// 0이 아니면 stack에 push
    		}else {
    			stack.push(inp);
    		}
    	}
    	// 정답을 담을 변수
    	int answer = 0;
    	while(!stack.isEmpty()) {
    		answer += stack.pop();
    	}
    	// 출력
    	bw.write(answer+"");
    	bw.flush();
    }
}