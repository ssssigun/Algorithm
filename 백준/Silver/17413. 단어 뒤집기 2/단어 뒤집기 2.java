/*
 * 1. 태그는 제외하고 뒤집기
 * 	- 순차적으로 확인해서 태그 확인
 *  - 태그가 아니면 그대로 
 * 2. 입력
 * 	- 문자열 S
 * 3. 뒤집은 채로 return
*/
import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
    	// 선언
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out	));
    	StringBuilder sb = new StringBuilder();
    	boolean sw = false;
    	// 입력 받기
    	String temp = br.readLine();
    	for(int i=0; i<temp.length(); i++) {
    		char t = temp.charAt(i);
    		if(t == '<') {
    			if(sb.length() > 0) {
    				bw.write(sb.reverse().toString());
    				sb.setLength(0);
    			}
    			sb.append(t);
    			sw = true;
    		}
    		// 태그면 안뒤집고 추가
    		else if(t == '>') {
        		sb.append(t);
    			bw.write(sb.toString());
    			sb.setLength(0);
    			sw = false;
    		}else if(t == ' ' &&  sw == false) {
				bw.write(sb.reverse().toString());
				bw.write(t);
				sb.setLength(0);
    		}else {
    			sb.append(t);
    		}
    	}
    	if(sb.length()>0) {
    		bw.write(sb.reverse().toString());
    	}
    	// 출력
    	bw.flush();
    }
}