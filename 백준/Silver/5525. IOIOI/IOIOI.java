/*
 * 1. Pn 문자열 찾기 (생성해줘야한다)
 * 2. 첫 줄엔 N, 둘째 줄엔 문자열 길이 M, 셋째 줄엔 문자열
 * 3. Pn이 몇개 들어가는지 확 return
 * */
import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringBuilder sb = new StringBuilder();
    	int ans = 0;
    	// N
    	int N = Integer.parseInt(br.readLine());
    	// Pn 생성
    	for(int i=0; i<(2*N)+1; i++) {
    		if(i%2 == 0) {
    			sb.append("I");
    		}else {
    			sb.append("O");
    		}
    	}
    	// M
    	int M = Integer.parseInt(br.readLine());
    	// S
    	String S = br.readLine();
        // Pn이 몇개 있는지 확인
    	for(int i=0; i<=M-sb.length(); i++) {
    		if(sb.toString().equals(S.substring(i,i+sb.length()))) {
    			ans++;
    		}
    	}
    	// 출력
    	bw.write(ans+"");
    	bw.flush();
    }
}