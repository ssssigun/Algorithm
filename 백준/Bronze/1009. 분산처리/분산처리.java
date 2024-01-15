/*
 * 1. 분산 처리
 *	- 연산해서 제곱해주고 일의 자리를 확인하면 될 것 같다
 * 2. 테스트 케이스의 개수 T, 그 다음 정수 a와 b
 * 3. 마지막 데이터가 처리 되는 컴퓨터의 번호 retrun
 * */
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st;
    	int T = Integer.parseInt(br.readLine());
    	for(int i=0; i<T; i++) {
    		st = new StringTokenizer(br.readLine());
    		int mul = 1;
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		for(int j=0; j<b; j++) {
    			mul *= a;
    			mul%=10;
    		}
    		String temp = mul+"";
    		if(temp.charAt(temp.length()-1) == '0') {
    			bw.write("10\n");
    		}else {
    			bw.write(temp.charAt(temp.length()-1)+"\n");
    		}
    	}
    	bw.flush();
    }
}